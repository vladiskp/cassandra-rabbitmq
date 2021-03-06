package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;

import java.util.List;

public interface SubscriberService {
    void add(Subscriber subscriber);

    List<Subscriber> findAll();

    void deleteById(long id);

    void deleteAll();
}