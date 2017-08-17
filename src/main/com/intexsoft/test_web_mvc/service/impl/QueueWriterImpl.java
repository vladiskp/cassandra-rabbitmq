package main.com.intexsoft.test_web_mvc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.com.intexsoft.test_web_mvc.entity.User;
import main.com.intexsoft.test_web_mvc.service.QueueWriter;
import main.com.intexsoft.test_web_mvc.service.UserBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@PropertySource(value = "classpath:rabbitmq.properties")
public class QueueWriterImpl implements QueueWriter {

    private ObjectMapper mapper = new ObjectMapper();

    @Value("${rabbitmq.messagesExchange}")
    private String exchange;

    @Value("${rabbitmq.messagesRoutingKey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private UserBuilder userBuilder;

    @Override
    public void writeMessage() {
        try {
            template.convertAndSend(exchange, routingKey, toJSON(userBuilder.build()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private String toJSON(User user) throws JsonProcessingException {
        return mapper.writeValueAsString(user);
    }
}