package com.demo.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.manage.dto.MarketDto;
import com.demo.manage.entity.Market;
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
		Market market = new Market();
		BeanUtils.copyProperties(marketDto, market);
		marketRepository.save(market);
		return marketDto;
	}

	public MarketDto getMarketById(String id) {
		Market market = marketRepository.findById(id).get();
		log.info(market.toString());
		MarketDto marketDto = new MarketDto();
		BeanUtils.copyProperties(market, marketDto);
		return marketDto;
	}

	public MarketDto updateMarketInRepository(MarketDto marketDto, String id) {
		log.info(marketDto.toString()+" "+id);
		if (marketRepository.existsById(id)) {
			Market market = marketRepository.findById(id).get();
			log.info(market.toString());
			BeanUtils.copyProperties(marketDto, market);
			return marketDto;
		}
		return null;
	}

	public MarketDto removeMarketById(String name) {
		if (marketRepository.existsByMarketName(name)) {
			Market market = marketRepository.getByMarketName(name);
			MarketDto marketDto = new MarketDto();
			BeanUtils.copyProperties(market, marketDto);
			marketRepository.deleteByMarketName(name);
			return marketDto;
		}
		return null;
	}

	public List<MarketDto> findAllMarketsByState(String state, Integer pageNo) {
		List<MarketDto> marketModels = new ArrayList<>();
		Pageable paging = PageRequest.of(pageNo, 10);
		Page<Market> pagedResult = marketRepository.findAllByMarketStateOrderByMarketName(state, paging);
		pagedResult.toList().stream().forEach((market) -> {
			MarketDto marketDto = new MarketDto();
			BeanUtils.copyProperties(market, marketDto);
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
