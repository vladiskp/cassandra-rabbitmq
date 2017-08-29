package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.repository.SubscriberRepository;
import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import main.com.intexsoft.test_web_mvc.service.PhoneFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PhoneFeatureImpl implements PhoneFeature {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    CallPriceCalculator callPriceCalculator;

    @Autowired
    CallRecordService callRecordService;

    @Override
    public void makeCall(long outSubscriberId, long inSubscriberId) {
        long duration = new Random().nextInt(1000000);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;
        String outPhoneOperator = subscriberRepository.findById(outSubscriberId).getPhoneNumber().getPhoneOperator();
        String inPhoneOperator = subscriberRepository.findById(inSubscriberId).getPhoneNumber().getPhoneOperator();
        double price = callPriceCalculator.calculateCallPrice(outPhoneOperator, inPhoneOperator, duration);
        String outPhoneNumber = subscriberRepository.findById(outSubscriberId).getPhoneNumber().getNumber();
        String inPhoneNumber = subscriberRepository.findById(inSubscriberId).getPhoneNumber().getNumber();

        CallRecord outCallRecord = CallRecord.builder().subscriberId(outSubscriberId)
                                                       .duration(duration)
                                                       .startTime(startTime)
                                                       .endTime(endTime)
                                                       .price(price)
                                                       .isInternal(outPhoneOperator.equals(inPhoneOperator))
                                                       .outPhoneNumber(outPhoneNumber)
                                                       .inPhoneNumber(inPhoneNumber)
                                                       .build();

        callRecordService.add(outCallRecord);
    }
}