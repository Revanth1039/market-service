package com.demo.manage.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.manage.controller.exception.MarketExceptionMessage;
import com.demo.manage.dto.MarketDto;
import com.demo.manage.entity.Market;
import com.demo.manage.enums.MarketStatus;
import com.demo.manage.repository.MarketRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageService {

	private MarketRepository marketRepository;
	private RabbitTemplate rabbitTemplate;

	public static final String QUEUE = "pp_queue";
	public static final String EXCHANGE = "pp_exchange";
	public static final String ROUTING_KEY = "pp_routing_key";

	public ManageService(MarketRepository marketRepository, RabbitTemplate rabbitTemplate) {
		this.marketRepository = marketRepository;
		this.rabbitTemplate = rabbitTemplate;
	}

	public MarketDto addMarketToRepository(MarketDto marketDto) throws MarketExceptionMessage {
		try {
		ModelMapper modelMapper = new ModelMapper();
		Market market=modelMapper.map(marketDto, Market.class);
		log.info(market.toString());
		marketRepository.save(market);
		return marketDto;
		}
		catch(Exception ex) {
			throw new MarketExceptionMessage(String.valueOf(HttpStatus.BAD_REQUEST),ex.getMessage());
		}
	}

	public MarketDto getMarketById(String id) throws MarketExceptionMessage {
		Market market = marketRepository.findById(id).orElse(null);
		if(market==null) {
			throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),"Market id not found");
		}
		log.info(market.toString());
		ModelMapper modelMapper = new ModelMapper();
		MarketDto marketDto=modelMapper.map(market, MarketDto.class);
		return marketDto;
	}

	public MarketDto updateMarketInRepository(MarketDto marketDto, String id) throws MarketExceptionMessage {
		log.info(marketDto.toString()+" "+id);
		marketDto.setUpdatedAt(LocalDateTime.now());
		if (marketRepository.existsById(id)) {
			Market market = marketRepository.findById(id).get();
			log.info(market.toString());
			ModelMapper modelMapper = new ModelMapper();
			market=modelMapper.map(marketDto, Market.class);
			marketRepository.save(market);
			return marketDto;
		}
		throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),"Market id not found");
	}

	public MarketDto removeMarketById(String name) throws MarketExceptionMessage {
		if (marketRepository.existsByMarketName(name)) {
			Market market = marketRepository.getByMarketName(name);
			ModelMapper modelMapper = new ModelMapper();
		    MarketDto marketDto=modelMapper.map(market, MarketDto.class);
			marketRepository.deleteByMarketName(name);
			return marketDto;
		}
		throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),"Market id not found");
	}

	public List<MarketDto> findAllMarketsByState(MarketStatus status, Integer pageNo) {
		List<MarketDto> marketModels = new ArrayList<>();
		Pageable paging = PageRequest.of(pageNo, 10);
		Page<Market> pagedResult = marketRepository.findAllByMarketStatusOrderByMarketName(status, paging);
		pagedResult.toList().stream().forEach((market) -> {
			ModelMapper modelMapper = new ModelMapper();
		    MarketDto marketDto=modelMapper.map(market, MarketDto.class);
			marketModels.add(marketDto);
		});
		return marketModels;

	}

	public String sendDataToMQ(MarketDto marketDto) {
		log.info("sending data to MQ");
		rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, marketDto);
		return "Sent data Successfully";
	}

	public MarketDto updateMarketStatus(String id) throws MarketExceptionMessage {
		Market market=marketRepository.findById(id).orElse(null);
		if(market==null) {
			throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),"Market id not found");
		}
		if(market.getMarketStatus()==MarketStatus.ACTIVE)
			market.setMarketStatus(MarketStatus.ARCHIVED);
		else
			market.setMarketStatus(MarketStatus.ACTIVE);
		ModelMapper modelMapper = new ModelMapper();
	    MarketDto marketDto=modelMapper.map(market, MarketDto.class);
	    marketRepository.save(market);
		return marketDto;
	}
}
