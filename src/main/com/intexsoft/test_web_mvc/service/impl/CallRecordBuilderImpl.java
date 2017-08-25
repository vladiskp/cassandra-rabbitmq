package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import main.com.intexsoft.test_web_mvc.service.CallRecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CallRecordBuilderImpl implements CallRecordBuilder {

    private int counter = 0;
    private long id;
    private long subscriberId;
    private long duration;
    private long startTime;
    private long endTime;
    private double price;
    private boolean type;

    private CallPriceCalculator callPriceCalculator;

    @Autowired
    public CallRecordBuilderImpl(CallPriceCalculator callPriceCalculator) {
        this.callPriceCalculator = callPriceCalculator;
    }

    @Override
    public CallRecord build(Subscriber subscriber) {
        ++counter;
        id = counter;
        subscriberId = subscriber.getId();
        duration = new Random().nextInt(1000000);
        startTime = System.currentTimeMillis();
        endTime = startTime + duration;
        price = 0;
        type = new Random().nextBoolean();

        return new CallRecord(id, subscriberId, duration, startTime, endTime, price, type);

    }
}