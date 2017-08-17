package main.com.intexsoft.test_web_mvc.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface QueueWriter {
    @Scheduled(fixedRate = 1000)
    void writeMessage();
}