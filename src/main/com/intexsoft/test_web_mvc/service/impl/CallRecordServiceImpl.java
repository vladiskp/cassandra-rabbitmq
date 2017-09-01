package main.com.intexsoft.test_web_mvc.service.impl;

import main.com.intexsoft.test_web_mvc.entity.CallRecord;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.repository.CallRecordRepository;
import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallRecordServiceImpl implements CallRecordService {

    @Autowired
    private CallRecordRepository callRecordRepository;

    @Override
    public void add(CallRecord callRecord) {
        callRecordRepository.save(callRecord);
    }

    @Override
    public List<CallRecord> findAll() {
        return (List<CallRecord>) callRecordRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        callRecordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        callRecordRepository.deleteAll();
    }
}