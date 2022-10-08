package com.gcsj.province.enrollment.info;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class InfoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text outK = new Text();
    private IntWritable outV = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        JSONObject json = JSONObject.parseObject(line);

        outK.set(json.getString("city"));
        outV.set(Integer.parseInt(json.getString("plan")));

        context.write(outK, outV);
    }
}
