package com.demo.manage.service;


import com.demo.manage.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public static final String QUEUE = "sample_queue";
    public static final String EXCHANGE = "sample_exchange";
    public static final String ROUTING_KEY = "sample_routingKey";


    public void sendUserDetailsViaMQ(UserModel user){
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY, user);

    }
}
