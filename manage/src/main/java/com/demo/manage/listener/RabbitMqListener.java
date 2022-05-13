package com.demo.manage.listener;

import com.demo.manage.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.messaging.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@Slf4j
@Component
public class RabbitMqListener {


    @RabbitListener(queues="sample_queue")
    public void getUserInfo(UserModel userModel){
        log.info("Got user details "+userModel.toString());
    }

}
