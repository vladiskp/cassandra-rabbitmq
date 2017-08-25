package main.com.intexsoft.test_web_mvc.service;

public interface CallPriceCalculator {
    double calculateCallPrice(boolean type, long duration, String phoneOperator);
}