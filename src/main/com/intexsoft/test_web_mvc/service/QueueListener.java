package main.com.intexsoft.test_web_mvc.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface QueueListener {
    @RabbitListener(queues = "${rabbitmq.messagesQueue}")
    void processQueue(String message);
}