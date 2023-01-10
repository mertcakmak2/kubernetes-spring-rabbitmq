package com.example.springrabbitmq.consumer;

import com.example.springrabbitmq.Message;
import com.example.springrabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class RabbitConsumer {

    Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

    @RabbitListener(queues = RabbitmqConfig.QUEUE)
    public void consumeMessageFromQueue(Message message){
        logger.info("Message => " + message.toString());
    }
}
