package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.PhoneNumber;
import main.com.intexsoft.test_web_mvc.repository.PhoneNumberRepository;
import main.com.intexsoft.test_web_mvc.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Override
    public void add(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }
}