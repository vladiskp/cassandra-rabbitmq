package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.service.PriceCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:rates.properties")
public class PriceCalculatorImpl implements PriceCalculator {

    @Value("${call.rate.internal}")
    private double callRateInternal;

    @Value("${call.rate.external}")
    private double callRateExternal;

    @Value("${sms.rate.internal}")
    private double smsRateInternal;

    @Value("${sms.rate.external}")
    private double smsRateExternal;

    @Override
    public double calculateCallPrice(String outPhoneOperator, String inPhoneOperator, long duration) {
        return duration / 1000 * (outPhoneOperator.equals(inPhoneOperator) ? callRateInternal : callRateExternal);
    }

    @Override
    public double calculateSMSPrice(String outPhoneOperator, String inPhoneOperator, String message) {
        return message.length() * (outPhoneOperator.equals(inPhoneOperator) ? smsRateInternal : smsRateExternal);
    }
}