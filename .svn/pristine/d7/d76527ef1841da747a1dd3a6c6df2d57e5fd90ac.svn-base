package com.gcsj.school;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gcsj.professional.popular.MyIntWritable;

public class schoolMapper extends Mapper<LongWritable, Text, Text, Text>{
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueString = value.toString();
        
		JSONObject jb = JSONObject.parseObject(valueString);
		if(jb.containsKey("uniname") && jb.containsKey("unicode")) {
			String uniname = (String)jb.get("uniname");
			String unicode = (String)jb.get("unicode");
			Text text = new Text(uniname+" "+unicode);
			context.write(text,new Text(" "));
		}
		else {
			return;
		}
		
		
		
    }
}
