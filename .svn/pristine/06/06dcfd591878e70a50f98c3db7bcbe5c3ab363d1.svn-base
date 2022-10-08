package com.gcsj.province.enrollment.info;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class InfoReducer extends Reducer<Text, IntWritable, Text, NullWritable> {

    private Text outK = new Text();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        for (IntWritable value : values) {
            sum += value.get();
        }

        outK.set(key + "," + sum);
        context.write(outK, NullWritable.get());
    }
}

