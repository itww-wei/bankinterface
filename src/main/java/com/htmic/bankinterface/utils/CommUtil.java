package com.htmic.bankinterface.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;



import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @description 通用工具了
 * @author fengya
 * @date 2015-7-30 上午11:08:33
 */
public class CommUtil {
	/**
	 * @description 对分页数据进行封装成json数据的形势
	 * @author fengya
	 * @date 2015-7-30 上午11:08:44
	 * @param page
	 *            分页数据对象
	 * @param isDateFormat
	 *            数据中是否需要日期转换
	 * @return
	 * @return JSONObject 返回的json数据
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject getPageJSONData(PageDto page, boolean isDateFormat) {
//		PageDataDto dataJson = new PageDataDto();
//		dataJson.setTotal(page.getTotalCount());
//		dataJson.setRows(page.getResult());
//		dataJson.setTotalPages(page.getTotalPages());
		if (isDateFormat) {
			DateJsonValueProcessor processor = new DateJsonValueProcessor();
			DateJsonValueProcessor dateProcessor = new DateJsonValueProcessor("yyyy-MM-dd");
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(Date.class, processor);
			config.registerJsonValueProcessor(java.sql.Date.class, dateProcessor);
			return JSONObject.fromObject(page, config);
		} else {
			return JSONObject.fromObject(page);
		}
	}

	/**
	 * @description 对字符串集合中查找是否包含ID
	 * @author fengya
	 * @date 2015-7-30 下午04:24:26
	 * @param ids
	 * @param id
	 * @return
	 * @return boolean
	 */
	public static boolean contains(String[] ids, String id) {
		if (StringUtil.isEmpty(id)) {
			return false;
		}
		for (String temp : ids) {
			if (temp.trim().equals(id.trim())) {
				return true;
			}
		}
		return false;
	}

	

	public static String freemarkerProcess(Map input, String templatePath) {
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		String template = "content";
		stringLoader.putTemplate(template, templatePath);
		Configuration cfg = new Configuration();
		cfg.setTemplateLoader(stringLoader);
		try {
			Template templateCon = cfg.getTemplate(template);
			StringWriter writer = new StringWriter();
			templateCon.process(input, writer);
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String readStringFromFile(String fileName) {
		FileInputStream in;
		String str = "";
		try {
			in = new FileInputStream(fileName);
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			str = new String(buffer, "gb2312");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
