package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;

public class PhoneOperatorInfo {

    @Getter @Setter
    private double rateInternal;

    @Getter @Setter
    private double rateExternal;

    public PhoneOperatorInfo() {
    }

    public PhoneOperatorInfo(double rateInternal, double rateExternal) {
        this.rateInternal = rateInternal;
        this.rateExternal = rateExternal;
    }
}