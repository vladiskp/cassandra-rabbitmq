package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.service.SubscriberBuilder;
import org.springframework.stereotype.Service;

@Service
public class SubscriberBuilderImpl implements SubscriberBuilder {

    private int id;
    private String login = "Ivan";
    private int counter = 0;

    @Override
    public Subscriber build() {
        ++counter;
        return new Subscriber();
    }
}