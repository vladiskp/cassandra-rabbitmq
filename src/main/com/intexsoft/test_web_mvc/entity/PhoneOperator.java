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

    @Value("${mtc.location.rate.internal}")
    private static double mtcLocationRateInternal;

    @Value("${mtc.location.rate.external}")
    private static double mtcLocationRateExternal;

    @Value("${mtc.operator.rate.internal}")
    private static double mtcOperatorRateInternal;

    @Value("${mtc.operator.rate.external}")
    private static double mtcOperatorRateExternal;

    @Value("${velcome.location.rate.internal}")
    private static double velcomeLocationRateInternal;

    @Value("${velcome.location.rate.external}")
    private static double velcomeLocationRateExternal;

    @Value("${velcome.operator.rate.internal}")
    private static double velcomeOperatorRateInternal;

    @Value("${velcome.operator.rate.external}")
    private static double velcomeOperatorRateExternal;

    @Value("${beeline.location.rate.internal}")
    private static double beelineLocationRateInternal;

    @Value("${beeline.location.rate.external}")
    private static double beelineLocationRateExternal;

    @Value("${beeline.operator.rate.internal}")
    private static double beelineOperatorRateInternal;

    @Value("${beeline.operator.rate.external}")
    private static double beelineOperatorRateExternal;

    @Value("${life.location.rate.internal}")
    private static double lifeLocationRateInternal;

    @Value("${life.location.rate.external}")
    private static double lifeLocationRateExternal;

    @Value("${life.operator.rate.internal}")
    private static double lifeOperatorRateInternal;

    @Value("${life.operator.rate.external}")
    private static double lifeOperatorRateExternal;

    static {
        phoneOperator = new HashMap<>();
        phoneOperator.put("MTC", new PhoneOperatorInfo(mtcLocationRateInternal,
                                                       mtcLocationRateExternal,
                                                       mtcOperatorRateInternal,
                                                       mtcOperatorRateExternal));
        phoneOperator.put("VELCOME", new PhoneOperatorInfo(velcomeLocationRateInternal,
                                                           velcomeLocationRateExternal,
                                                           velcomeOperatorRateInternal,
                                                           velcomeOperatorRateExternal));
        phoneOperator.put("BEELINE", new PhoneOperatorInfo(beelineLocationRateInternal,
                                                           beelineLocationRateExternal,
                                                           beelineOperatorRateInternal,
                                                           beelineOperatorRateExternal));
        phoneOperator.put("LIFE", new PhoneOperatorInfo(lifeLocationRateInternal,
                                                        lifeLocationRateExternal,
                                                        lifeOperatorRateInternal,
                                                        lifeOperatorRateExternal));
    }
}