package main.com.intexsoft.test_web_mvc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.service.CallRecordBuilder;
import main.com.intexsoft.test_web_mvc.service.QueueWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(QueueWriterImpl.class);

    @Value("${rabbitmq.messagesExchange}")
    private String exchange;

    @Value("${rabbitmq.messagesRoutingKey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private CallRecordBuilder callRecordBuilder;

    @Override
    public void writeMessage() {
        try {
            logger.info("Prepare to write message in RabbitMQ queue.");
//            CallRecord callRecord = callRecordBuilder.build();
            CallRecord callRecord = new CallRecord(1, 111, 111, 111, 111, 1, true);
            template.convertAndSend(exchange, routingKey, toJSON(callRecord));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
    }

    private String toJSON(CallRecord callRecord) throws JsonProcessingException {
        return mapper.writeValueAsString(callRecord);
    }
}