package com.gcsj.professional.major;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MajorMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        JSONObject json = JSONObject.parseObject(line);

        String profess = json.getString("profess");

        //将专业名称缩短
        int i = profess.indexOf("(");
        if(i <= 0 || i > profess.length()) {
            i = profess.length();
        }
        String substring = profess.substring(0, i);

        outK.set(json.getString("major_code") + "," + substring + "," + json.getString("subject"));
        context.write(outK, NullWritable.get());
    }
}
