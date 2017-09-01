package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.SMSRecord;
import main.com.intexsoft.test_web_mvc.repository.SubscriberRepository;
import main.com.intexsoft.test_web_mvc.service.PriceCalculator;
import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import main.com.intexsoft.test_web_mvc.service.PhoneFeature;
import main.com.intexsoft.test_web_mvc.service.SMSRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PhoneFeatureImpl implements PhoneFeature {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    PriceCalculator priceCalculator;

    @Autowired
    CallRecordService callRecordService;

    @Autowired
    SMSRecordService smsRecordService;

    @Override
    public void makeCall(long outSubscriberId, long inSubscriberId) {
        long duration = new Random().nextInt(1000000);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;
        String outPhoneOperator = subscriberRepository.findById(outSubscriberId).getPhoneNumber().getOperator();
        String inPhoneOperator = subscriberRepository.findById(inSubscriberId).getPhoneNumber().getOperator();
        double price = priceCalculator.calculateCallPrice(outPhoneOperator, inPhoneOperator, duration);
        String outPhoneNumber = subscriberRepository.findById(outSubscriberId).getPhoneNumber().getNumber();
        String inPhoneNumber = subscriberRepository.findById(inSubscriberId).getPhoneNumber().getNumber();

        CallRecord callRecord = CallRecord.builder().id(1)
                                                       .subscriberId(outSubscriberId)
                                                       .duration(duration)
                                                       .startTime(startTime)
                                                       .endTime(endTime)
                                                       .price(price)
                                                       .isInternal(outPhoneOperator.equals(inPhoneOperator))
                                                       .outPhoneNumber(outPhoneNumber)
                                                       .inPhoneNumber(inPhoneNumber)
                                                       .build();

        callRecordService.add(callRecord);
    }

    @Override
    public void writeSMS(long outSubscriberId, long inSubscriberId, String message) {
        int characterQuantity = message.length();
        String outPhoneOperator = subscriberRepository.findById(outSubscriberId).getPhoneNumber().getOperator();
        String inPhoneOperator = subscriberRepository.findById(inSubscriberId).getPhoneNumber().getOperator();
        double price = priceCalculator.calculateSMSPrice(outPhoneOperator, inPhoneOperator, message);
        long sendTime = System.currentTimeMillis();

        SMSRecord smsRecord = SMSRecord.builder().id(1)
                                                 .subscriberId(outSubscriberId)
                                                 .message(message)
                                                 .characterQuantity(characterQuantity)
                                                 .price(price)
                                                 .sendTime(sendTime)
                                                 .isInternal(outPhoneOperator.equals(inPhoneOperator))
                                                 .outNumber(outPhoneOperator)
                                                 .inNumber(inPhoneOperator)
                                                 .build();
        smsRecordService.add(smsRecord);
    }
}