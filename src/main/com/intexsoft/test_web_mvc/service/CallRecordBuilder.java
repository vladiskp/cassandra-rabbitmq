package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;

public interface CallRecordBuilder {
    CallRecord build(Subscriber subscriber);
}