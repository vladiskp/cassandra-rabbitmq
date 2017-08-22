package main.com.intexsoft.test_web_mvc.service;

public interface CallPriceCalculator {
    double calculatePriceForOneCall(boolean type, long duration);
}