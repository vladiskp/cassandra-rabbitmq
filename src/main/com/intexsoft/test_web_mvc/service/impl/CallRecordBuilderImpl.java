package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import main.com.intexsoft.test_web_mvc.service.CallRecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CallRecordBuilderImpl implements CallRecordBuilder {

    private int counter = 0;
    private int id;
    private long duration;
    private long startTime;
    private long endTime;
    private boolean type;
    private double price;
    private CallPriceCalculator callPriceCalculator;

    @Autowired
    public CallRecordBuilderImpl(CallPriceCalculator callPriceCalculator) {
        this.callPriceCalculator = callPriceCalculator;
    }

    @Override
    public CallRecord build() {
        ++counter;
        id = counter;
        duration = new Random().nextInt(1000000);
        startTime = System.currentTimeMillis();
        endTime = startTime + duration;
        type = new Random().nextBoolean();
        price = callPriceCalculator.calculateCallPrice(type, duration);

        return new CallRecord(id, duration, startTime, endTime, price, type);
    }
}