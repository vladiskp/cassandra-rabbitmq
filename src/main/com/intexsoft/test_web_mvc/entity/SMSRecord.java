package main.com.intexsoft.test_web_mvc.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

// TODO SendStatus
@Table(value = "Test_SMS_Record")
@ToString
@Builder
public class SMSRecord {

    @PrimaryKey
    @Getter @Setter
    private long id;

    @Column
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private String message;

    @Column
    @Getter @Setter
    private int characterQuantity;

    @Column
    @Getter @Setter
    private double price;

    @Column
    @Getter @Setter
    private long sendTime;

    @Column
    @Getter @Setter
    private boolean isInternal;

    @Column
    @Getter @Setter
    private String outNumber;

    @Column
    @Getter @Setter
    private String inNumber;

    public SMSRecord() {}

    public SMSRecord(long id, long subscriberId, String message, int characterQuantity, double price, long sendTime, boolean isInternal, String outNumber, String inNumber) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.message = message;
        this.characterQuantity = characterQuantity;
        this.price = price;
        this.sendTime = sendTime;
        this.isInternal = isInternal;
        this.outNumber = outNumber;
        this.inNumber = inNumber;
    }
}