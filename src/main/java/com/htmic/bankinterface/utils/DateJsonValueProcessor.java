/*
 * <b>文件名</b>：DateJsonValueProcessor.java
 *
 * 文件描述：
 *
 *
 * 2012-9-29  上午10:38:36
 */
package com.htmic.bankinterface.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;

public class DateJsonValueProcessor implements JsonValueProcessor {
	private static final Logger LOG = Logger.getLogger(DateJsonValueProcessor.class);
	// 默认时间格式
	private String patten = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 构造函数 Constructor for DateJsonValueProcessor
	 * 
	 * @param patten
	 *            时间格式字符串
	 */
	public DateJsonValueProcessor(String patten) {
		super();
		this.patten = patten;
	}

	public DateJsonValueProcessor() {
	}

	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		if (null == arg0) {
			return "";
		}
		return formatDate((Date) arg0);
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		if (null == arg1) {
			return "";
		}
		return formatDate((Date) arg1);
	}

	/**
	 * 
	 * <b>方法名</b>：formatDate<br>
	 * <b>功能</b>：格式化时间<br>
	 * 
	 * @author <font color='blue'>zohan</font>
	 * @date 2012-9-29 上午10:42:16
	 * @param value
	 * @return
	 */
	private String formatDate(Date value) {
		String date = null;
		try {
			date = new SimpleDateFormat(patten).format(value);
		} catch (Exception e) {
			LOG.debug("格式化日期出现了错误！", e);
		}

		return date;
	}

}
