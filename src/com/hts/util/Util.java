package com.hts.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Util {
	
	public static int gcd(int m,int n){        
		int k=m>n?n:m;  
        int s = 1;  
        for(int i = 2;i <=k;i ++){  
            for(int j = 2;j <= i;j++){  
                if(m % j == 0 && n % j == 0){  
                    m = m / j;  
                    n = n / j;  
                    s = s * j;  
                }  
            }     
        }  
        return s;           
    }  
	public static JSONArray toJsonArray( List<Map<String, Object>>data){
		JSONArray array =new JSONArray();
		for(Map<String,Object>rowItem:data){
			JSONObject json=new JSONObject();
			try{
				for(Map.Entry<String, Object>entry:rowItem.entrySet()){
					json.put(entry.getKey(), entry.getValue());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			array.add(json);
		}
		
		return array;
	}
	public static void main(String[] args) {
		String str1="abc";
		String str2="abc";
		System.out.println(str1.getBytes());
		System.out.println(str2.getBytes());
	}
}
