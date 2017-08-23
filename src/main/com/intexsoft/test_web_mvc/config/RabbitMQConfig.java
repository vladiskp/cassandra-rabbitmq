package main.com.intexsoft.test_web_mvc.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:rabbitmq.properties")
public class RabbitMQConfig {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.messagesExchange:test}")
    private String exchange;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(host);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange(exchange);
        return rabbitTemplate;
    }

    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory listenerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }
}