package main.com.intexsoft.test_web_mvc.entity;

import com.datastax.driver.core.DataType.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

// TODO Personal Data
@Table(value="Test_User")
@ToString
public class Subscriber {

    @PrimaryKey("id")
    @Getter @Setter
    private long id;

    @CassandraType(userTypeName = "phone_number", type = Name.UDT)
    private PhoneNumber phoneNumber;

    public Subscriber() {}

    public Subscriber(long id, PhoneNumber phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}