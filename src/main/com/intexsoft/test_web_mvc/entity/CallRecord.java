package main.com.intexsoft.test_web_mvc.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "Test_Call_Record")
@ToString
@Builder
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
    private boolean locationType;

    @Column
    @Getter @Setter
    private boolean operatorType;

    @Column
    @Getter @Setter
    private String outNumber;

    @Column
    @Getter @Setter
    private String inNumber;

    public CallRecord(){}

    public CallRecord(long id, long subscriberId, long duration, long startTime, long endTime, double price, boolean locationType, boolean operatorType, String outNumber, String inNumber) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.locationType = locationType;
        this.operatorType = operatorType;
        this.outNumber = outNumber;
        this.inNumber = inNumber;
    }
}