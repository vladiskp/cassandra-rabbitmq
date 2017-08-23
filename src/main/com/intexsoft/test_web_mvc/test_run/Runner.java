package main.com.intexsoft.test_web_mvc.test_run;

import main.com.intexsoft.test_web_mvc.service.QueueWriter;
import main.com.intexsoft.test_web_mvc.service.impl.QueueWriterImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("main.com.intexsoft.test_web_mvc.service", "main.com.intexsoft.test_web_mvc.config");
        QueueWriter queueWriter = context.getBean(QueueWriterImpl.class);
        queueWriter.writeMessage();
    }
}