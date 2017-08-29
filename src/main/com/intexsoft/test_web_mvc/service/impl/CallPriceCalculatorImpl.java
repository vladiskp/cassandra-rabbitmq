package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import org.springframework.stereotype.Service;

@Service
public class CallPriceCalculatorImpl implements CallPriceCalculator {

    @Override
    public double calculateCallPrice(int outCountryCode, int inCountryCode, String outPhoneOperator, String inPhoneOperator, long duration) {
        double locationRate;
        double operatorRate;

        if(outCountryCode == inCountryCode) {
            locationRate = PhoneOperator.getPhoneOperator().get(outPhoneOperator).getLocationRateInternal();
        } else {
            locationRate = PhoneOperator.getPhoneOperator().get(outPhoneOperator).getLocationRateExternal();
        }

        if(outPhoneOperator.equals(inPhoneOperator)) {
            operatorRate = PhoneOperator.getPhoneOperator().get(outPhoneOperator).getOperatorRateInternal();
        } else {
            operatorRate = PhoneOperator.getPhoneOperator().get(outPhoneOperator).getOperatorRateExternal();
        }


        return duration / 1000 * locationRate * operatorRate;
    }
}