package main.com.intexsoft.test_web_mvc.entity;

import com.datastax.driver.core.DataType.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

// TODO Personal Data
@Table(value="subscriber")
@ToString
public class Subscriber {

    @PrimaryKey("id")
    @Getter @Setter
    private long id;

    @Column("phone")
    @CassandraType(userTypeName = "phone", type = Name.UDT)
    @Getter @Setter
    private PhoneNumber phoneNumber;

    public Subscriber() {}

    public Subscriber(long id) {
        this.id = id;
    }

    public Subscriber(long id, PhoneNumber phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}