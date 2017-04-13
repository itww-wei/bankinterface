package com.htmic.bankinterface.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.htmic.bankinterface.socket.Server;

public class InitContextDataListener implements ServletContextListener{
	// 启动运行日志
	/** log */
	private static final Logger LOG = Logger.getLogger(InitContextDataListener.class);
	public void contextDestroyed(ServletContextEvent arg0) {
		// 停止所有定时任务
		LOG.info("****************************************************");
		LOG.info("系统停止，停止定时任务！");
//		if (TimeTaskManager.isStarted()) {
//			TimeTaskManager.getScheduler().isShutdown();
//			TimeTaskManager.getScheduler().clear();
//			LOG.info("停止定时任务成功！");
//		}
		LOG.info("****************************************************");
	}

	public void contextInitialized(ServletContextEvent context) {
		Thread thread = new Thread() {
			public void run() {
				//启动socket服务
				Server server=new Server();
				server.startServer();
			}
		};
		thread.start();
		
		//测试
		Server server=new Server();
		try {
//			server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3001</TransCode><TransDate>20161123</TransDate><TransTime>030842</TransTime><SeqNo>1479884922271</SeqNo></head><body><AcctNo>79410188000131028</AcctNo><ProjectNo>2016BHHWJ0001</ProjectNo><BiaoDuanNo>297e104e58855e21015885d4879b0010</BiaoDuanNo><ProjectName>包河区政府采购中心网络设备采购</ProjectName><OpenDate>20161128</OpenDate><OpenTime>030000</OpenTime><IsRetire>0</IsRetire><MatuDay></MatuDay></body></root>");
//			server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>4011</TransCode><TransDate>20161228</TransDate><TransTime>044701</TransTime><SeqNo>1482914821999</SeqNo></head><body><ItemNo>2016BHHWJ0001</ItemNo><ItemNox>297e104e58855e21015885d4879b0010</ItemNox><AuthCode>JSkgmn</AuthCode></body></root>");
//			server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3031</TransCode><TransDate>20170111</TransDate><TransTime>032801</TransTime><BiaoDunNo>297e104e58855e21015885d4879b0010</BiaoDunNo><SeqNo>1484119681527</SeqNo></head><body><TotalNum>1</TotalNum><BanK><BankNo></BankNo><BankName></BankName><HstSeqNum>20170323104015514001HT</HstSeqNum><InAcctNo>187232322644</InAcctNo><InName>汪玮</InName><InTranAmt>4800</InTranAmt></BanK></body></root>");
//			server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3041</TransCode><TransDate>20170215</TransDate><TransTime>050054</TransTime><SeqNo>1487149254775</SeqNo></head><body><BiaoDuanNo>297e104e58855e21015885d4879b0010</BiaoDuanNo><OpenDate>20170207</OpenDate><OpenTime>090000</OpenTime></body></root>");
			server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3051</TransCode><TransDate>20170324</TransDate><TransTime>090000</TransTime><SeqNo>1490317200841</SeqNo></head><body><ItemNo>2017BHHWJ0041</ItemNo><ItemNox>402884905afe407e015afe4514dd0001</ItemNox><AuthCode>KxSEBF</AuthCode ></body></root>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
