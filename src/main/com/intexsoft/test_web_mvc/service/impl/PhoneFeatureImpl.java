package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.repository.PhoneNumberRepository;
import main.com.intexsoft.test_web_mvc.repository.SubscriberRepository;
import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import main.com.intexsoft.test_web_mvc.service.CallRecordBuilder;
import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import main.com.intexsoft.test_web_mvc.service.PhoneFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneFeatureImpl implements PhoneFeature {

    @Autowired
    private CallRecordBuilder callRecordBuilder;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    CallPriceCalculator callPriceCalculator;

    @Autowired
    CallRecordService callRecordService;

    @Override
    public void makeCall(long subscriberId) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId);
        CallRecord callRecord;
        String phoneOperator = phoneNumberRepository.findBySubscriberId(subscriberId).getPhoneOperator();
        callRecord = callRecordBuilder.build(subscriber);
        callRecord.setPrice(callPriceCalculator.calculateCallPrice(callRecord.isType(), callRecord.getDuration(), phoneOperator));
        callRecordService.add(callRecord);
    }
}