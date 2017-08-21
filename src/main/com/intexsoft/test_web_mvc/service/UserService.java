package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;

import java.util.List;

public interface UserService {
    void add(Subscriber subscriber);

    List<Subscriber> findAll();

    void deleteById(int id);

    void deleteAll();
}