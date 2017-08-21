package main.com.intexsoft.test_web_mvc.test_run;

import main.com.intexsoft.test_web_mvc.entity.PhoneOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private final static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        System.out.println(PhoneOperator.phoneOperators.get("Velcome"));
    }
}