package main.com.intexsoft.test_web_mvc.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "Test_Call_Record")
public class CallRecord {

    @PrimaryKey
    private int id;

    @Column
    private long duration;

    @Column
    private long startTime;

    @Column
    private long endTime;

    @Column
    private long price;

}