package com.htmic.bankinterface.utils;

import java.sql.Clob;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class ClobJsonValueProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		if(arg0 != null && arg0 instanceof Clob){
			Clob clob = (Clob)arg0;
			return clob.toString();
		}
		return "";
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		if(arg1 != null && arg1 instanceof Clob){
			Clob clob = (Clob)arg1;
			return clob.toString();
		}
		return "";
	}

}
