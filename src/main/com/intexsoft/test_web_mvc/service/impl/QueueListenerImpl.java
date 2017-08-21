package main.com.intexsoft.test_web_mvc.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.service.QueueListener;
import main.com.intexsoft.test_web_mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableRabbit
@PropertySource(value="classpath:rabbitmq.properties")
public class QueueListenerImpl implements QueueListener {

    private final UserService userService;
    private final ObjectMapper mapper;
    private final Logger logger;

    @Autowired
    public QueueListenerImpl(UserService userService) {
        this.userService = userService;
        mapper = new ObjectMapper();
        logger = LoggerFactory.getLogger(QueueWriterImpl.class);
    }

    @Override
    @RabbitListener(queues = "${rabbitmq.messagesQueue}")
    public void processQueue(String message) {
        logger.info("Successfully received in rabbit listener message:\"" + message + "\" from RabbitMQ queue \"${rabbitmq.messagesQueue}\".");
        convertAndSave(message);
    }

    private void convertAndSave(String message) {
        try {
            logger.info("Prepare to write ");
            userService.add(mapper.readValue(message, Subscriber.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}