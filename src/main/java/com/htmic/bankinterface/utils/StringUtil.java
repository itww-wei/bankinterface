package com.htmic.bankinterface.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class StringUtil {

	private StringUtil() {
	}

	/**
	 * 判断字符串是否为一个数字
	 */
	public static boolean isNumber(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		}
		return str.trim().matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	public static boolean isInteger(String str) {
		return str.trim().matches("^[-+]?([0-9]+)$");
	}

	/**
	 * 判断字符串是否为空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	public static List<Integer> idsToList(String ids) {
		if (ids == null || "".equals(ids.trim())) {
			return new ArrayList<Integer>();
		}
		List<Integer> idList = new ArrayList<Integer>();
		String[] idStr = ids.split(",");
		for (int i = 0; i < idStr.length; i++) {
			if (StringUtil.isInteger(idStr[i])) {
				idList.add(Integer.parseInt(idStr[i]));
			}
		}
		return idList;
	}
	
	/**
	 * @description String 转为 Date 
	 * @author wwang 
	 * @date 2016-8-23
	 * @param DateStr
	 * @return
	 */
	public static Date StringToDate(String DateStr){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date=sdf.parse(DateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	

	/**
	 * @description 日期的计算
	 * @author wwang 
	 * @date 2016-8-24
	 * @param ymd 年月日
	 * @param sTime 时分秒
	 * @param days 天数
	 * @return
	 */
	public static String computeDate(Date ymd, String sTime, int days) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(ymd);
			cd.add(Calendar.DATE, days);// 增加天数
			String tempDate = sdf.format(cd.getTime());// 年月日
			tempDate += " " + sTime;// 拼接时分秒
			return tempDate;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * @description 日期的计算
	 * @author wwang 
	 * @date 2016-8-29
	 * @param time 日期
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 时
	 * @param minute 分
	 * @param second 秒
	 * @return
	 */
	public static Date computeDate(Date time, int year,int month,int day,int hour,int minute,int second) {
		try {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(time);
			rightNow.add(Calendar.YEAR,year);//日期减年
	        rightNow.add(Calendar.MONTH,month);//日期加月
	        rightNow.add(Calendar.DAY_OF_YEAR,day);//日期加天
	        rightNow.add(Calendar.HOUR_OF_DAY,hour);//日期加小时
	        rightNow.add(Calendar.MINUTE,minute);//日期加分钟
	        rightNow.add(Calendar.SECOND,second);//日期加秒
	        return rightNow.getTime();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 日期的比较
	 * @param currentDate
	 * @param compartDate
	 * @return true 大于此日期，在此日期之后<br>
	 * 		   false 小于此日期，在此日期之前
	 */
	public static boolean compareToDate(Date currentDate,Date compartDate){
		//0如果参数日期等于此日期; 如果这个日期在Date参数之前返回一个小于0的值 ;  如果这个日期在Date参数之后返回一个大于0的值。
		return currentDate.compareTo(compartDate)>0?true:false;
	}
	
	/**
	 * @description 查询时，结束时间加一天 
	 * @author wwang 
	 * @date 2016-9-1
	 * @return
	 */
	public static java.sql.Date addOneDayDate(java.sql.Date time,int day){
		if (time != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(time);
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + day);
			time = new java.sql.Date(c.getTime().getTime());
		}
		return time;
	}
	
	/**
	 * @description 查询时，结束时间加一天 
	 * @author wwang 
	 * @date 2016-9-1
	 * @return
	 */
	public static Date addOneDayDate(Date time,int day){
		if (time != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(time);
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + day);
			time = c.getTime();
		}
		return time;
	}
	
	public static void main(String[] args) {
		//java.sql.Date res = addOneDayDate(new java.sql.Date(new Date().getTime()), 1);
//		String res = computeDate(new Date(), "00:00:00", 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar cd = Calendar.getInstance();
//		cd.setTime(new Date());
//		cd.add(Calendar.DATE, 2);// 增加天数
//		String tempDate = sdf.format(cd.getTime());// 年月日
		
		Date tempDate = addOneDayDate(new Date(), 3);
		
		System.err.println(sdf.format(tempDate));
	}
}
