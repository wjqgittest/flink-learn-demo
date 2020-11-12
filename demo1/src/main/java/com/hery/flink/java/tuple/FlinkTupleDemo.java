package com.hery.flink.java.tuple;


import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Date 2020/7/8 14:08
 * @Created by hery
 * @Description flink 的tuple
 */
public class FlinkTupleDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Tuple3<String, Long, Double>> dataStream = senv.fromElements(
                Tuple3.of("0001", 0L, 121.2),
                Tuple3.of("0002", 1L, 201.8),
                Tuple3.of("0003", 2L, 10.3),
                Tuple3.of("0004", 3L, 99.6)
        );

        dataStream.filter(item -> item.f2 > 100).print();

        dataStream.filter(item -> ((Double) item.getField(2) > 100)).print();

        senv.execute("java tuple");
    }
}
