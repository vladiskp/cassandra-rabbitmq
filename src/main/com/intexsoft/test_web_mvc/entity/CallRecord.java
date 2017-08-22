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
    private int id;

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
    private long price;

    @Column
    @Getter @Setter
    private String type;
}