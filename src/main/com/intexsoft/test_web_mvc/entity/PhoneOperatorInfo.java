package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;

public class PhoneOperatorInfo {

    @Getter @Setter
    private double locationRateInternal;

    @Getter @Setter
    private double locationRateExternal;

    @Getter @Setter
    private double operatorRateInternal;

    @Getter @Setter
    private double operatorRateExternal;

    public PhoneOperatorInfo() {
    }

    public PhoneOperatorInfo(double locationRateInternal, double locationRateExternal, double operatorRateInternal, double operatorRateExternal) {
        this.locationRateInternal = locationRateInternal;
        this.locationRateExternal = locationRateExternal;
        this.operatorRateInternal = operatorRateInternal;
        this.operatorRateExternal = operatorRateExternal;
    }
}