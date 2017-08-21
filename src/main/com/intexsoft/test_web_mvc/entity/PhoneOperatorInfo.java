package main.com.intexsoft.test_web_mvc.entity;

public class PhoneOperatorInfo {

    private double externalPrice;
    private double internalPrice;

    public PhoneOperatorInfo(double externalPrice, double internalPrice) {
        this.externalPrice = externalPrice;
        this.internalPrice = internalPrice;
    }

    public double getExternalPrice() {
        return externalPrice;
    }

    public void setExternalPrice(double externalPrice) {
        this.externalPrice = externalPrice;
    }

    public double getInternalPrice() {
        return internalPrice;
    }

    public void setInternalPrice(double internalPrice) {
        this.internalPrice = internalPrice;
    }
}