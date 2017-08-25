package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.SMSRecord;
import main.com.intexsoft.test_web_mvc.repository.SMSRecordRepository;
import main.com.intexsoft.test_web_mvc.service.SMSRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSRecordServiceImpl implements SMSRecordService {

    @Autowired
    SMSRecordRepository smsRecordRepository;

    @Override
    public void add(SMSRecord smsRecord) {
        smsRecordRepository.save(smsRecord);
    }
}