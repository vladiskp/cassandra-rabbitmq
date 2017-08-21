//package main.com.intexsoft.test_web_mvc.service.impl;
//
//import main.com.intexsoft.test_web_mvc.entity.CallRecord;
//import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CallPriceCalculatorImpl implements CallPriceCalculator {
//    @Override
//    public double calculatePriceForOneCall(CallRecord callRecord) {
//        // TODO calculate price related on type of phone call and phone operator
//        return callRecord.getDuration() / 1000 * (callRecord.getType() ? rateInternal : rateExternal);
//    }
//}