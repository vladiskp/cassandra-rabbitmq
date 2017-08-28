package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

// TODO Personal Data
@Table(value="Test_User")
@ToString
public class Subscriber {

    @PrimaryKey("id")
    @Getter @Setter
    private long id;

    @Column
    @Getter @Setter
    private String phoneNumber;

    public Subscriber() {}

    public Subscriber(long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}