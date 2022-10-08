package com.gcsj.school_major;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import com.alibaba.fastjson.JSONObject;

public class SMMapper extends Mapper<LongWritable, Text, Text, Text>{
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueString = value.toString();
        
		JSONObject jb = JSONObject.parseObject(valueString);
		if(jb.containsKey("unicode") && jb.containsKey("major_code")) {
			String major_code = (String)jb.get("major_code");
			String unicode = (String)jb.get("unicode");
			Text text = new Text(unicode + " " + major_code);
			context.write(text,new Text(" "));
		}
		else {
			return;
		}
		
		
		
    }

}
