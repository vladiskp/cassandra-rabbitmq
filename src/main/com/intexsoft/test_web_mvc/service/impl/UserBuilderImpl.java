package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.User;
import main.com.intexsoft.test_web_mvc.service.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserBuilderImpl implements UserBuilder {

    private int id;
    private String login = "Ivan";
    private int counter = 0;

    @Override
    public User build() {
        ++counter;
        return new User(id + counter, login + counter);
    }
}