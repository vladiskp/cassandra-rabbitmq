package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;

/**
 * Created by kvp on 21.08.2017.
 */
public interface CallPriceCalculator {
    double calculatePriceForOneCall(CallRecord callRecord);
}
