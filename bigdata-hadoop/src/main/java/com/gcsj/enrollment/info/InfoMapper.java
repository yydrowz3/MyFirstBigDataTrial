package com.gcsj.enrollment.info;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class InfoMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private Text outK = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        JSONObject json = JSONObject.parseObject(line);
        String msg = json.getString("unicode") + "\t" +
                json.getString("uniname") + "\t" +
                json.getString("city") + "\t" +
                json.getString("major_code") + "\t" +
                json.getString("profess") + "\t" +
                json.getString("subject") + "\t" +
                json.getString("batch") + "\t" +
                json.getString("plan");

//        String[] split = msg.split("\t");
//        if(split.length == 8) {
//            outK.set(split[5]);
//        }
//        else {
//            outK.set(line);
//        }
        outK.set(msg);
        context.write(outK, NullWritable.get());
    }
}
