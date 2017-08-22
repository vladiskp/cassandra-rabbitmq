package main.com.intexsoft.test_web_mvc.service.impl;

import org.springframework.stereotype.Service;

@Service
public class CallRecordBuilderImpl {

    private int counter = 0;
    private int id;
    private long duration;
    private long startTime;
    private long endTime;
    private long price;
    private String type;
}