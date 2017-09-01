package main.com.intexsoft.test_web_mvc.controller;

import main.com.intexsoft.test_web_mvc.service.CallRecordService;
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
public class CallRecordController {
    private ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.config");
    private CallRecordService callRecordService = context.getBean(CallRecordService.class);

    @RequestMapping("/allCR")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(callRecordService.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/deleteCR/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        callRecordService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/deleteAllCR")
    public ResponseEntity<?> deleteAll() {
        callRecordService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}