package main.com.intexsoft.test_web_mvc.test_run;

import main.com.intexsoft.test_web_mvc.entity.PhoneNumber;
import main.com.intexsoft.test_web_mvc.entity.Subscriber;
import main.com.intexsoft.test_web_mvc.service.PhoneFeature;
import main.com.intexsoft.test_web_mvc.service.SubscriberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.config", "main.com.intexsoft.test_web_mvc.service");
        SubscriberService subscriberService = context.getBean(SubscriberService.class);
        PhoneFeature phoneFeature = context.getBean(PhoneFeature.class);
        subscriberService.add(new Subscriber(1, new PhoneNumber("111", "velcome", 2)));
        subscriberService.add(new Subscriber(2, new PhoneNumber("222", "velcome", 5)));
        phoneFeature.makeCall(1, 2);
    }
}