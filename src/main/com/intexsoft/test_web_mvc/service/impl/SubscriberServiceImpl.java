package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.repository.SubscriberRepository;
import main.com.intexsoft.test_web_mvc.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public void add(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }

    @Override
    public List<Subscriber> findAll() {
        return (List<Subscriber>) subscriberRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        subscriberRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        subscriberRepository.deleteAll();
    }

    public SubscriberServiceImpl() {}
}