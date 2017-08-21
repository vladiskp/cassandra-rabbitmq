package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;

class PhoneOperatorInfo {

    @Getter @Setter
    private double externalPrice;

    @Getter @Setter
    private double internalPrice;

    PhoneOperatorInfo(double externalPrice, double internalPrice) {
        this.externalPrice = externalPrice;
        this.internalPrice = internalPrice;
    }
}