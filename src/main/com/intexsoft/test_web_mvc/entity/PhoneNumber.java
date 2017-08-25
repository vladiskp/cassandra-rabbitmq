package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PhoneNumber {

    @Getter @Setter
    private String number;

    @Getter @Setter
    private long subscriberId;

    @Getter @Setter
    private double balance;

    @Getter @Setter
    private String phoneOperator;

    public PhoneNumber() {}

    public PhoneNumber(String number, long subscriberId, double balance, String phoneOperator) {
        this.number = number;
        this.subscriberId = subscriberId;
        this.balance = balance;
        this.phoneOperator = phoneOperator;
    }
}