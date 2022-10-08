package com.gcsj.source.Info;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class InfoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text outK = new Text();
    private IntWritable outV = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();

        String[] split = line.split(",");

        Province province = new Province(split[0]);

        outK.set(province.getArea());
        outV.set(Integer.parseInt(split[1]));

        context.write(outK, outV);
    }
}
