package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

@Table(value = "Test_SMS_Record")
@ToString
public class SMSRecord {

    @PrimaryKey
    @Getter @Setter
    private long id;

    @Column
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private int characterQuantity;

    @Column
    @Getter @Setter
    private boolean type;

    @Column
    @Getter @Setter
    private double price;

    @Column
    @Getter @Setter
    private long sendTime;

    public SMSRecord() {}

    public SMSRecord(long id, long subscriberId, int characterQuantity, boolean type, double price, long sendTime) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.characterQuantity = characterQuantity;
        this.type = type;
        this.price = price;
        this.sendTime = sendTime;
    }
}