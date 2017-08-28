package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:rates.properties")
public class PhoneOperator {

    @Getter
    private static Map<String, PhoneOperatorInfo> phoneOperator;

    @Value("${mtc.rate.internal}")
    private static double mtcRateInternal;

    @Value("${mtc.rate.external}")
    private static double mtcRateExternal;

    @Value("${velcome.rate.internal}")
    private static double velcomeRateInternal;

    @Value("${velcome.rate.external}")
    private static double velcomeRateExternal;

    @Value("${beeline.rate.internal}")
    private static double beelineRateInternal;

    @Value("${beeline.rate.external}")
    private static double beelineRateExternal;

    @Value("${life.rate.internal}")
    private static double lifeRateInternal;

    @Value("${life.rate.external}")
    private static double lifeRateExternal;

    static {
        phoneOperator = new HashMap<>();
        phoneOperator.put("MTC", new PhoneOperatorInfo(mtcRateInternal, mtcRateExternal));
        phoneOperator.put("VELCOME", new PhoneOperatorInfo(velcomeRateInternal, velcomeRateExternal));
        phoneOperator.put("BEELINE", new PhoneOperatorInfo(beelineRateInternal, beelineRateExternal));
        phoneOperator.put("LIFE", new PhoneOperatorInfo(lifeRateExternal, lifeRateExternal));
    }
}