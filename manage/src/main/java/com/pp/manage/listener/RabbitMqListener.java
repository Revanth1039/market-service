package com.pp.manage.listener;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pp.manage.entity.Market;
import com.pp.manage.repository.MarketRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class RabbitMqListener {


	@Autowired
	private MarketRepository marketRepository;

    
    @RabbitListener(queues="pp_queue")
    public void getUserInfo(Map<String,Object> marketDto){
    	ModelMapper modelMapper = new ModelMapper();
    	log.info(marketDto.toString());
		Market market=modelMapper.map(marketDto, Market.class);
        log.info("Got the details "+market.toString());
        marketRepository.save(market);
        log.info("successfully stored into database");
    }

}
