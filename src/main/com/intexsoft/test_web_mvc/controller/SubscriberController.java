package main.com.intexsoft.test_web_mvc.controller;

import main.com.intexsoft.test_web_mvc.service.SubscriberService;
import main.com.intexsoft.test_web_mvc.service.impl.SubscriberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class SubscriberController {

    private ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.config");
    private SubscriberService subscriberService = context.getBean(SubscriberServiceImpl.class);

    @RequestMapping("/allS")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(subscriberService.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/deleteS/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        subscriberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/deleteAllS")
    public ResponseEntity<?> deleteAll() {
        subscriberService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}