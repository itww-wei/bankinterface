package com.htmic.bankinterface.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextUtil {

	private SpringContextUtil() {
	}

	protected static ApplicationContext ctx = null;

	/**
	 * 获取Spring管理的bean
	 * 
	 * @param name
	 * @return bean
	 * @author huangb
	 * @date 2011-03-03
	 */
	public static Object getBean(String name) {
		if (ctx == null) {
			ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		}
		return ctx.getBean(name);
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		ctx = applicationContext;
	}

	public static ApplicationContext setApplicationContext() {
		ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		return ctx;
	}

	/**
	 * <b>方法名</b>：isContextInited<br>
	 * <b>功能</b>：判断spring容器是否已经初始化<br>
	 * 
	 * @author <font color='blue'>Administrator</font>
	 * @date 2012-8-30 下午03:00:00
	 * @return
	 */
	public static boolean isContextInited() {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		return context != null;
	}
}
