package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> findAll();

    void deleteById(int id);

    void deleteAll();
}