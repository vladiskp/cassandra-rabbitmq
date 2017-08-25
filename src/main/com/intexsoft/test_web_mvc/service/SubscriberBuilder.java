package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;

@FunctionalInterface
public interface SubscriberBuilder {
    Subscriber build();
}