package main.com.intexsoft.test_web_mvc.service.impl;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.com.intexsoft.test_web_mvc.actor.BillingActorSystem;
import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.service.QueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableRabbit
@PropertySource(value="classpath:rabbitmq.properties")
public class QueueListenerImpl implements QueueListener {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(QueueWriterImpl.class);

    @Override
    @RabbitListener(queues = "${rabbitmq.messagesQueue}")
    public void processQueue(String message) {
        logger.info("Successfully received in rabbit listener message:\"" + message + "\" from RabbitMQ queue \"${rabbitmq.messagesQueue}\".");
        ActorSystem actorSystem = ActorSystem.create("BillingSystem");
        ActorRef kernel = actorSystem.actorOf(Props.create(BillingActorSystem.class), "kernel");
        try {
            kernel.tell(convert(message), ActorRef.noSender());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CallRecord convert(String message) throws IOException {
        return mapper.readValue(message, CallRecord.class);
    }
}