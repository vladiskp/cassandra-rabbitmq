package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.repository.CallRecordRepository;
import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallRecordServiceImpl implements CallRecordService {

    @Autowired
    private CallRecordRepository callRecordRepository;

    @Override
    public void add(CallRecord callRecord) {
        callRecordRepository.save(callRecord);
    }
}