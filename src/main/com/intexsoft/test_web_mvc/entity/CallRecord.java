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
    private boolean isInternal;

    @Column
    @Getter @Setter
    private String outPhoneNumber;

    @Column
    @Getter @Setter
    private String inPhoneNumber;

    public CallRecord(){}

    public CallRecord(long id, long subscriberId, long duration, long startTime, long endTime, double price, boolean isInternal, String outPhoneNumber, String inPhoneNumber) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isInternal = isInternal;
        this.outPhoneNumber = outPhoneNumber;
        this.inPhoneNumber = inPhoneNumber;
    }
}