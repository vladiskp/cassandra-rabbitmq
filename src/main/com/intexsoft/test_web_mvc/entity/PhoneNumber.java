package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PhoneNumber {

    @Getter @Setter
    private String number;

    @Getter @Setter
    private double balance;

    @Getter @Setter
    private PhoneOperator phoneOperator;
}