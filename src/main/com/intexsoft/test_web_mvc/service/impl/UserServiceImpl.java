package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.repository.UserRepository;
import main.com.intexsoft.test_web_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(Subscriber subscriber) {
        userRepository.save(subscriber);
    }

    @Override
    public List<Subscriber> findAll() {
        return (List<Subscriber>) userRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public UserServiceImpl() {}
}