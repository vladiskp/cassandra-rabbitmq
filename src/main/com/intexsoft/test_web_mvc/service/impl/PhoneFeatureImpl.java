package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.repository.PhoneNumberRepository;
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
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    CallPriceCalculator callPriceCalculator;

    @Autowired
    CallRecordService callRecordService;

    @Override
    public void makeCall(long outSubscriberId, long inSubscriberId) {
        long duration = new Random().nextInt(1000000);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;
        int outCountryCode = phoneNumberRepository.findBySubscriberId(outSubscriberId).getCountryCode();
        int inCountryCode = phoneNumberRepository.findBySubscriberId(inSubscriberId).getCountryCode();
        String outPhoneOperator = phoneNumberRepository.findBySubscriberId(outSubscriberId).getPhoneOperator();
        String inPhoneOperator = phoneNumberRepository.findBySubscriberId(inSubscriberId).getPhoneOperator();
        String outPhoneNumber = phoneNumberRepository.findBySubscriberId(outSubscriberId).getNumber();
        String inPhoneNumber = phoneNumberRepository.findBySubscriberId(inSubscriberId).getNumber();
        double outPrice = callPriceCalculator.calculateCallPrice(outCountryCode, inCountryCode, outPhoneOperator, inPhoneOperator, duration);
        double inPrice = 0;

        CallRecord outCallRecord = CallRecord.builder().id(1)
                                                       .subscriberId(outSubscriberId)
                                                       .duration(duration)
                                                       .startTime(startTime)
                                                       .endTime(endTime)
                                                       .price(outPrice)
                                                       .outNumber(outPhoneNumber)
                                                       .inNumber(inPhoneNumber).build();

        CallRecord inCallRecord = CallRecord.builder().id(2)
                                                        .subscriberId(inSubscriberId)
                                                        .duration(duration)
                                                        .startTime(startTime)
                                                        .endTime(endTime)
                                                        .price(inPrice)
                                                        .outNumber(outPhoneNumber)
                                                        .inNumber(inPhoneNumber).build();
        callRecordService.add(outCallRecord);
        callRecordService.add(inCallRecord);
    }
}