package com.demo.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	public static final String QUEUE = "sample_queue";
	public static final String EXCHANGE = "sample_exchange";
	public static final String ROUTING_KEY = "sample_routingKey";

	public ManageService(MarketRepository marketRepository, RabbitTemplate rabbitTemplate) {
		this.marketRepository = marketRepository;
		this.rabbitTemplate = rabbitTemplate;
	}

	public MarketDto addMarketToRepository(MarketDto marketDto) {
		ModelMapper modelMapper = new ModelMapper();
		Market market=modelMapper.map(marketDto, Market.class);
		log.info(market.toString());
		marketRepository.save(market);
		return marketDto;
	}

	public MarketDto getMarketById(String id) {
		Market market = marketRepository.findById(id).get();
		log.info(market.toString());
		ModelMapper modelMapper = new ModelMapper();
		MarketDto marketDto=modelMapper.map(market, MarketDto.class);
		return marketDto;
	}

	public MarketDto updateMarketInRepository(MarketDto marketDto, String id) {
		log.info(marketDto.toString()+" "+id);
		if (marketRepository.existsById(id)) {
			Market market = marketRepository.findById(id).get();
			log.info(market.toString());
			ModelMapper modelMapper = new ModelMapper();
			market=modelMapper.map(marketDto, Market.class);
			marketRepository.save(market);
			return marketDto;
		}
		return null;
	}

	public MarketDto removeMarketById(String name) {
		if (marketRepository.existsByMarketName(name)) {
			Market market = marketRepository.getByMarketName(name);
			ModelMapper modelMapper = new ModelMapper();
		    MarketDto marketDto=modelMapper.map(market, MarketDto.class);
			marketRepository.deleteByMarketName(name);
			return marketDto;
		}
		return null;
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
}
