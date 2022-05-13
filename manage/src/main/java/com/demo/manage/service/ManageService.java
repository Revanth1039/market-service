package com.demo.manage.service;


import com.demo.manage.entity.Market;
import com.demo.manage.model.MarketModel;
import com.demo.manage.repository.MarketRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	public MarketModel addMarketToRepository(MarketModel marketModel) {
        Market market=new Market();
        BeanUtils.copyProperties(marketModel,market);
        marketRepository.save(market);
        return marketModel;
    }

    public MarketModel getMarketById(String name) {
        Market market=marketRepository.getByMarketName(name);
        log.info(market.toString());
        MarketModel marketModel=new MarketModel();
        BeanUtils.copyProperties(market,marketModel);
        return marketModel;
    }

    public MarketModel updateMarketInRepository(MarketModel marketModel) {
        Market market=new Market();
        BeanUtils.copyProperties(marketModel,market);
        marketRepository.save(market);
        return marketModel;
    }

    public MarketModel removeMarketById(String name) {
        if(marketRepository.existsByMarketName(name)){
            Market market=marketRepository.getByMarketName(name);
            MarketModel marketModel=new MarketModel();
            BeanUtils.copyProperties(market,marketModel);
            marketRepository.deleteByMarketName(name);
            return marketModel;
        }
        return null;
    }

    public List<MarketModel> findAllMarketsByState(String state,Integer pageNo) {
        List<MarketModel> marketModels=new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo,10);
        Page<Market> pagedResult=marketRepository.findAllByMarketStateOrderByMarketName(state,paging);
        pagedResult.toList().stream().forEach((market) -> {
            MarketModel marketModel=new MarketModel();
            BeanUtils.copyProperties(market,marketModel);
            marketModels.add(marketModel);
        });
        return marketModels;

    }

	public String sendDataToMQ(MarketModel marketModel) {
		log.info("sending data to MQ");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, marketModel);
        return "Sent data Successfully";
	}
}
