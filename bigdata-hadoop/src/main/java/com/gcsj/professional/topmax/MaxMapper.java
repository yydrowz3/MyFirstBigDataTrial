package com.gcsj.professional.topmax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import com.gcsj.professional.popular.Utils;


public class MaxMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	private HashMap<String,Integer> topNMin;
	private int topN;
	
	@Override
	protected void setup(Context context)throws IOException, InterruptedException {
		topN = context.getConfiguration().getInt("TopN", 10);
		topNMin =  new HashMap<String,Integer>();
	}
	
	@Override
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
		String line = value.toString();
		String[] profess = line.split(",");
		
		if (topNMin.size()>=topN) {
			Utils.replaceMapMinValue(topNMin, profess[0], Integer.parseInt(profess[1]));
		}else {
			topNMin.put(profess[0],Integer.parseInt(profess[1]));
		}
		
	}
	
	@Override
	protected void cleanup(Context context)throws IOException, InterruptedException {
		
		Iterator<Entry<String,Integer>> it = topNMin.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			context.write(new Text(entry.getKey()),new IntWritable(entry.getValue()));
			
		}
		
	}

}
