package com.pp.manage.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pp.manage.dto.MarketDto;
import com.pp.manage.entity.Market;
import com.pp.manage.enums.MarketStatus;
import com.pp.manage.exception.MarketExceptionMessage;
import com.pp.manage.repository.MarketRepository;
import com.pp.manage.service.ManageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageServiceImpl implements ManageService{
	
	private MarketRepository marketRepository;
	private RabbitTemplate rabbitTemplate;

	@Value("${manage-service.exceptions.market-not-found}")
	private String marketNotFoundMessage;
	
	
	public static final String QUEUE = "pp_queue";
	public static final String EXCHANGE = "pp_exchange";
	public static final String ROUTING_KEY = "pp_routing_key";

	public ManageServiceImpl(MarketRepository marketRepository, RabbitTemplate rabbitTemplate) {
		this.marketRepository = marketRepository;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public MarketDto addMarketInRepository(MarketDto marketDto) throws MarketExceptionMessage {
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

	@Override
	public MarketDto getMarketById(String id) throws MarketExceptionMessage {
		Market market = marketRepository.findById(id).orElse(null);
		if(market==null) {
			throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),marketNotFoundMessage);
		}
		log.info(market.toString());
		ModelMapper modelMapper = new ModelMapper();
		MarketDto marketDto=modelMapper.map(market, MarketDto.class);
		return marketDto;
	}

	@Override
	public MarketDto updateMarketInRepository(MarketDto marketDto, String id) throws MarketExceptionMessage {
		log.info(marketDto.toString()+" "+id);
		marketDto.setUpdatedAt(LocalDateTime.now());
		if (marketRepository.existsById(id)) {
			Market market = marketRepository.getByMarketID(id);
			log.info(market.toString());
			ModelMapper modelMapper = new ModelMapper();
			market=modelMapper.map(marketDto, Market.class);
			marketRepository.save(market);
			return marketDto;
		}
		throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),marketNotFoundMessage);
	}

	@Override
	public MarketDto removeMarketById(String name) throws MarketExceptionMessage {
		if (marketRepository.existsByMarketName(name)) {
			Market market = marketRepository.getByMarketName(name);
			ModelMapper modelMapper = new ModelMapper();
		    MarketDto marketDto=modelMapper.map(market, MarketDto.class);
			marketRepository.deleteByMarketName(name);
			return marketDto;
		}
		throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),marketNotFoundMessage);
	}

	@Override
	public List<MarketDto> findAllMarketsByStatus(MarketStatus status, Integer pageNo) {
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
	@Override
	public String sendDataToMQ(MarketDto marketDto) {
		log.info("sending data to MQ");
		rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, marketDto);
		return "Sent data Successfully";
	}
	
	@Override
	public MarketDto updateMarketStatus(String id) throws MarketExceptionMessage {
		Market market=marketRepository.findById(id).orElse(null);
		if(market==null) {
			throw new MarketExceptionMessage(String.valueOf(HttpStatus.NOT_FOUND),marketNotFoundMessage);
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
