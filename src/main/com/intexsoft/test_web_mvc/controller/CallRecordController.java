package main.com.intexsoft.test_web_mvc.controller;

import main.com.intexsoft.test_web_mvc.service.CallRecordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/callRecord")
public class CallRecordController {
    private ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.config");
    private CallRecordService callRecordService = context.getBean(CallRecordService.class);

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("callRecords", callRecordService.findAll());
        return "callRecords";
    }
}