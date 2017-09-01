package main.com.intexsoft.test_web_mvc.service;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;

import java.util.List;

public interface CallRecordService {
    void add(CallRecord callRecord);

    List<CallRecord> findAll();

    void deleteById(long id);

    void deleteAll();
}