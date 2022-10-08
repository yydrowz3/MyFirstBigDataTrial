package com.gcsj.cleandata;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CleanMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private Text outK = new Text();
    private Text outV = new Text();
    private JSONObject msg = new JSONObject();
    private JSONObject json = new JSONObject();
    private JSONArray data = new JSONArray();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String one = value.toString();
        json = JSONObject.parseObject(one);

        if("1".equals(json.getString("status"))) {

            data = json.getJSONArray("data");

            for (Object datum : data) {

                msg = (JSONObject)datum;

                //去除重复无用字段
                msg.remove("id");
                msg.remove("sid");
                msg.remove("school");
                msg.remove("sub_type");
                msg.remove("stu_time");
                msg.remove("state");
                msg.remove("year");
                msg.remove("level");

                //使用fastjson的SerializerFeature序列化WriteMapNullValue属性：
                String s = JSONObject.toJSONString(msg, SerializerFeature.WriteMapNullValue);
                if(s.contains("null")) {
                    continue;
                }
                outK.set(s);
                context.write(outK, NullWritable.get());
            }
        }
    }
}
