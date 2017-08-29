package main.com.intexsoft.test_web_mvc.entity;

import com.datastax.driver.core.DataType.Name;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType("phone_number")
@ToString
public class PhoneNumber {

    @CassandraType(type = Name.TEXT)
    private String number;

    @CassandraType(type = Name.TEXT)
    private String phoneOperator;

    @CassandraType(type = Name.DOUBLE)
    private double balance;

    public PhoneNumber() {}

    public PhoneNumber(String number, String phoneOperator, double balance) {
        this.number = number;
        this.phoneOperator = phoneOperator;
        this.balance = balance;
    }
}