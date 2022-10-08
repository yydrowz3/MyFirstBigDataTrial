package com.gcsj.province;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gcsj.professional.popular.MyIntWritable;

import java.io.IOException;


public class ProvinceMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String valueString = value.toString();
        
		JSONObject jb = JSONObject.parseObject(valueString);
		if(jb.containsKey("city") && jb.containsKey("city_code")) {
			String city = (String)jb.get("city");
			String city_code = (String)jb.get("city_code");
			Text text = new Text(city+" "+city_code);
			context.write(text,new Text(" "));
		}
		else {
			return;
		}
		
		
		
    }
}
