package main.com.intexsoft.test_web_mvc.entity;

import java.util.HashMap;
import java.util.Map;

public class PhoneOperator {
    private static Map<String, PhoneOperatorInfo> phoneOperators;

    static {
        phoneOperators = new HashMap<>(4);
        phoneOperators.put("MTC", new PhoneOperatorInfo(5.23, 2.22));
        phoneOperators.put("VELCOME", new PhoneOperatorInfo(4.33, 3.33));
        phoneOperators.put("LIFE", new PhoneOperatorInfo(2.40, 1.15));
        phoneOperators.put("BEELINE", new PhoneOperatorInfo(3.0, 4.12));
    }
}