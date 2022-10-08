package com.gcsj.professional.topmax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.gcsj.professional.popular.Utils;

public class MaxReduce extends Reducer<Text,IntWritable,Text,IntWritable>{
	private HashMap<String,Integer> topNMin;
	private int topN;
	
	@Override
	protected void setup(Context context)throws IOException, InterruptedException {
		topN = context.getConfiguration().getInt("TopN", 10);
		topNMin =  new HashMap<String,Integer>();
	}
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		
			if(topNMin.size()>=topN) {
				Utils.replaceMapMinValue(topNMin, key.toString(), values.iterator().next().get());
			}else {
				topNMin.put(key.toString(),values.iterator().next().get());
			}
	}
	
	@Override
	protected void cleanup(Context context)throws IOException, InterruptedException {
			List<Entry<String,Integer>> orderList = Utils.mapValueOrder(topNMin, false);
			for (Entry<String,Integer> entry : orderList) {
				context.write(new Text(entry.getKey()), new IntWritable(entry.getValue()));
			}
		
	}
	
}
