package application.service;

import application.data.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import application.entity.Message;

import java.util.List;

@RestController
public class WorkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message) {
        LOGGER.info("Message to be sent :" + message);
        rabbitTemplate.convertAndSend("TopicExchange","topic",message);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public List<Message> getMessage() {
        LOGGER.info("Messages present are :" + Data.messages);
        return Data.messages;
    }

}
