package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.PhoneOperator;
import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class CallPriceCalculatorImpl implements CallPriceCalculator {

    @Override
    public double calculateCallPrice(boolean type, long duration, String phoneOperator) {
        double rate = type ? PhoneOperator.getPhoneOperator().get(phoneOperator).getRateInternal() : PhoneOperator.getPhoneOperator().get(phoneOperator).getRateExternal();
        return duration / 1000 * rate;
    }
}