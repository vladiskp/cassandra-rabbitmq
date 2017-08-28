package main.com.intexsoft.test_web_mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "Test_Call_Record")
@ToString
public class CallRecord {

    @PrimaryKey
    @Getter @Setter
    private long id;

    @Column
    @Getter @Setter
    private long subscriberId;

    @Column
    @Getter @Setter
    private long duration;

    @Column
    @Getter @Setter
    private long startTime;

    @Column
    @Getter @Setter
    private long endTime;

    @Column
    @Getter @Setter
    private double price;

    @Column
    @Getter @Setter
    private boolean type;

    @Column
    @Getter @Setter
    private String outNumber;

    @Column
    @Getter @Setter
    private String inNumber;

    public CallRecord(){}

    public CallRecord(long id, long subscriberId, long duration, long startTime, long endTime, double price, boolean type, String outNumber, String inNumber) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.type = type;
        this.outNumber = outNumber;
        this.inNumber = inNumber;
    }
}