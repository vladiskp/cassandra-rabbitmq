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
    private long id;

    @Column
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private String number;

    @Column
    @Getter @Setter
    private int countryCode;

    @Column
    @Getter @Setter
    private String phoneOperator;

    @Column
    @Getter @Setter
    private double balance;

    public PhoneNumber() {}

    public PhoneNumber(long id, long subscriberId, String number, int countryCode, String phoneOperator, double balance) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.number = number;
        this.countryCode = countryCode;
        this.phoneOperator = phoneOperator;
        this.balance = balance;
    }
}