package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

@Table(value = "Test_Phone_Number")
@ToString
public class PhoneNumber {

    @PrimaryKey
    @Getter @Setter
    private String number;

    @Column
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private double balance;

    @Column
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