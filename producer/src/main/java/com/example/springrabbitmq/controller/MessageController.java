package com.example.springrabbitmq.controller;

import com.example.springrabbitmq.Message;
import com.example.springrabbitmq.config.RabbitmqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MessageController {

    Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private final RabbitTemplate template;

    public MessageController(RabbitTemplate template) {
        this.template = template;
    }

    @GetMapping(path = "")
    private String getMessage(){
        Message message = new Message();
        message.setMessage("test 123");
        message.setId(UUID.randomUUID().toString());

        template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, message);
        logger.info("Message sending =>" + message.toString());
        return "Success";
    }


}
