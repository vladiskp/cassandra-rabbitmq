package main.com.intexsoft.test_web_mvc.test_run;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.service.SubscriberBuilder;

public class Runner {
    public static void main(String[] args) {
        SubscriberBuilder subscriberBuilder = () -> Subscriber.builder().id(1).login("test_lambda").build();
        Subscriber subscriber = subscriberBuilder.build();
        System.out.println(subscriber);
    }
}