package com.htmic.bankinterface.utils;


import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.htmic.bankinterface.dto.JXml;

public class XmlParserUtil {

	public static void main(String[] args) throws Exception {

	}
	
	/**
	 * 将XML转化为Java对象
	 * @param xml
	 * @return
	 */
	public static JXml xmlParserJavaBean(String xml){
		xml=xml.replaceAll("<BanK>","<bank>");
		xml=xml.replaceAll("</BanK>","</bank>");
		
		//处理bank只有一条的数据
		int bankCount = getCount(xml, "</bank>");
		if(bankCount==1){
			xml=xml.replace("</bank>", "</bank><bank><InDate></InDate></bank>");
		}
		
		//将XML转化为json对象
        String json = null;
        JSONObject jsonObj = null;
        try {
            jsonObj = XML.toJSONObject(xml);//xml对象
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.err.println(jsonObj.toString());
        
        //将json对象转化成Java对象
        ObjectMapper om = new ObjectMapper();
        JXml jxml=null;
		try {
			jxml = om.readValue(jsonObj.toString(), JXml.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return jxml;
	}
	
	/**
	 * 将XML转化为Java对象
	 * @param xml
	 * @return
	 */
	public static JSONObject xmlParserJson(String xml){
		//将XML转化为json对象
        String json = null;
        JSONObject jsonObj = null;
        try {
            jsonObj = XML.toJSONObject(xml);//xml对象
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.err.println(jsonObj.toString());
        return jsonObj;
	}
	
	
	/**
	 * 计算字符串出现的次数
	 * @param str
	 * @param sub
	 * @return
	 */
	public static int getCount(String str, String sub) {
		int index = 0;
		int count = 0;
		while ((index = str.indexOf(sub, index)) != -1) {

			index = index + sub.length();
			count++;
		}
		return count;
	}
}

