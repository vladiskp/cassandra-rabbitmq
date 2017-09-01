package main.com.intexsoft.test_web_mvc.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.cassandra.mapping.Column;

@Table(value = "sms_record")
@ToString
@Builder
public class SMSRecord {

    @PrimaryKey
    @Getter @Setter
    private long id;

    @Column("subscriber_id")
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private String message;

    @Column("character_quantity")
    @Getter @Setter
    private int characterQuantity;

    @Column
    @Getter @Setter
    private double price;

    @Column("send_time")
    @Getter @Setter
    private long sendTime;

    @Column("is_internal")
    @Getter @Setter
    private boolean isInternal;

    @Column("out_number")
    @Getter @Setter
    private String outNumber;

    @Column("in_number")
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