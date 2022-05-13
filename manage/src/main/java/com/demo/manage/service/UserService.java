package com.demo.manage.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.manage.dto.UserDto;

@Service
public class UserService {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public static final String QUEUE = "sample_queue";
    public static final String EXCHANGE = "sample_exchange";
    public static final String ROUTING_KEY = "sample_routingKey";


    public void sendUserDetailsViaMQ(UserDto userDto){
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY, userDto);

    }
}
