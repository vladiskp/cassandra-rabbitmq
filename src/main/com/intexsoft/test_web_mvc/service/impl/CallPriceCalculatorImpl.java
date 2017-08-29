package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.service.CallPriceCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:rates.properties")
public class CallPriceCalculatorImpl implements CallPriceCalculator {

    @Value("${rate.internal}")
    private double rateInternal;

    @Value("${rate.external}")
    private double rateExternal;

    @Override
    public double calculateCallPrice(String outPhoneOperator, String inPhoneOperator, long duration) {
        return duration / 1000 * (outPhoneOperator.equals(inPhoneOperator) ? rateInternal : rateExternal);
    }
}