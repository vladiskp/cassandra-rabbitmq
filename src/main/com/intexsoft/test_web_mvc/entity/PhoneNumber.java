package main.com.intexsoft.test_web_mvc.entity;

import com.datastax.driver.core.DataType.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;


@UserDefinedType("phone")
@ToString
public class PhoneNumber {

    @CassandraType(type = Name.TEXT)
    @Getter @Setter
    private String number;

    @CassandraType(type = Name.TEXT)
    @Getter @Setter
    private String operator;

    @CassandraType(type = Name.DOUBLE)
    @Getter @Setter
    private double balance;

    public PhoneNumber() {}

    public PhoneNumber(String number, String operator, double balance) {
        this.number = number;
        this.operator = operator;
        this.balance = balance;
    }
}