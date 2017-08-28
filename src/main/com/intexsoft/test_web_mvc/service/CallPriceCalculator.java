package main.com.intexsoft.test_web_mvc.service;

public interface CallPriceCalculator {
    double calculateCallPrice(int outCountryCode, int inCountryCode, String outPhoneOperator, String inPhoneOperator, long duration);
}