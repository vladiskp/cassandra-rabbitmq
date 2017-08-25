package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneFeatureImpl {

//    @Autowired
//    private CallRecordBuilder callRecordBuilder;

    @Autowired
    private UserRepository userRepository;

    public Subscriber makeCall (long subscriberId) {
        Subscriber subscriber = userRepository.findById(subscriberId);
        return new Subscriber();
    }
}