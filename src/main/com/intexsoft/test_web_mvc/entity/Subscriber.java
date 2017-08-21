package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

@Table(value="Test_User")
@ToString
public class Subscriber {

    @PrimaryKey("id")
    @Getter @Setter
    private int id;

    @Column("login")
    @Getter @Setter
    private String login;

    public Subscriber() {}

    public Subscriber(int id, String login) {
        this.id = id;
        this.login = login;
    }
}