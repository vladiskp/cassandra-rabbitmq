package main.com.intexsoft.test_web_mvc.service;

public interface PhoneFeature {
    void makeCall(long outSubscriberId, long inSubscriberId);

    void writeSMS(long outSubscriberId, long inSubscriberId, String message);
}