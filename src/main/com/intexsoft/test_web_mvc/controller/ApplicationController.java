package main.com.intexsoft.test_web_mvc.controller;

import main.com.intexsoft.test_web_mvc.service.QueueWriter;
import main.com.intexsoft.test_web_mvc.service.UserService;
import main.com.intexsoft.test_web_mvc.service.impl.QueueWriterImpl;
import main.com.intexsoft.test_web_mvc.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    private ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.config");
    private UserService userService = context.getBean(UserServiceImpl.class);
    private QueueWriter queueWriter = context.getBean(QueueWriterImpl.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String test() {
        return "index";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() throws InterruptedException {
        queueWriter.writeMessage();
        return "redirect:users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "users";
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public String deleteAll() {
        userService.deleteAll();
        return "users";
    }
}