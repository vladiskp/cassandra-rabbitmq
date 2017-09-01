package main.com.intexsoft.test_web_mvc.service;

public interface PriceCalculator {
    double calculateCallPrice(String outPhoneOperator, String inPhoneOperator, long duration);

    double calculateSMSPrice(String outPhoneOperator, String inPhoneOperator, String message);
}