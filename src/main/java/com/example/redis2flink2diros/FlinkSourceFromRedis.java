package com.example.redis2flink2diros;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.HashMap;

public class FlinkSourceFromRedis {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        MyRedisSource myRedisSource1 = new MyRedisSource();
        DataStream<HashMap<String, String>> data = env.addSource(myRedisSource1);

        data.print();
        env.execute();
    }
}