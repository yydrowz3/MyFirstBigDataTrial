package com.gcsj.professional.popular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {
	
	/**
	 * @author wuxj
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void replaceMapMaxValue(HashMap<String,Integer> map,String key,Integer value) {
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	           @Override
	           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	               return o1.getValue().compareTo(o2.getValue());
	           }
	       });
		Entry<String, Integer> entry = list.get(list.size()-1);
		if(value < entry.getValue()) {
			map.remove(entry.getKey());
			map.put(key, value);
		}
		
		
	}
	
	
	/**
	 * @author wuxjֵ
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void replaceMapMinValue(HashMap<String,Integer> map,String key,Integer value) {
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); 
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	           @Override
	           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	               return o1.getValue().compareTo(o2.getValue());
	           }
	       });
		Entry<String, Integer> entry = list.get(0);
		
		if(value > entry.getValue()) {
			map.remove(entry.getKey());
			map.put(key, value);
		}
		
		
	}
	
	
	/**
	 * @author wuxj
	 * @param map
	 * @param isDesc �Ƿ��� trueΪ����falseΪ����
	 * @return
	 */
	public static List<Entry<String,Integer>> mapValueOrder(HashMap<String,Integer> map, boolean isDesc) {
		
		
		List<Map.Entry<String, Integer>> orderList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); 
		
		
		Collections.sort(orderList, new Comparator<Map.Entry<String, Integer>>() {
	           @Override
	           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	        	   int result = o2.getValue().compareTo(o1.getValue());
	               return isDesc?result:-result;
	           }
	       });
		
		return orderList;
		
	}

}