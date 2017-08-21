package main.com.intexsoft.test_web_mvc.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

@Table(value="Test_User")
public class Subscriber {

    @PrimaryKey("id")
    private int id;

    @Column("login")
    private String login;

    public Subscriber() {}

    public Subscriber(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}