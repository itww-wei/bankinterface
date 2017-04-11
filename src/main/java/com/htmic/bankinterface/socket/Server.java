package com.htmic.bankinterface.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.htmic.bankinterface.model.PayBank;
import com.htmic.bankinterface.model.ProjectBank;
import com.htmic.bankinterface.service.IPayBankService;
import com.htmic.bankinterface.service.IProjectBankService;
import com.htmic.bankinterface.utils.AuthCodeGenerate;
import com.htmic.bankinterface.utils.CommUtil;
import com.htmic.bankinterface.utils.HstSeqNumUtil;
import com.htmic.bankinterface.utils.SpringContextUtil;
import com.htmic.bankinterface.utils.XmlParserUtil;


@SuppressWarnings("all")
public class Server {
	
	private ServerSocket ss;
	
	private InputStreamReader inputStreamReader; 
	
	private BufferedReader bufferedReader;

	final String modelPath = Server.class.getResource("/bank").getPath();
	
	/**
	 * 启动socket服务
	 */
	public void startServer(){

		try {
			//让服务器端程序开始监听来自9101端口的客户端请求
			if (ss==null) {
				 ss = new ServerSocket(9101);
				 System.out.println("模拟银行接口服务器启动成功.........");
			}
			
			//服务器无穷的循环等待客户端的请求
			while(true){	
				/*
				 *accept()方法会在等待用户的socket连接时闲置着，当用户链接
				 *上来时，此方法会返回一个socket(在不同的端口上)以便与客户端
				 *通信。Socket与ServerSocket的端口不同，因此ServerSocket可以
				 *空闲出来等待其他客户端
				 */
				//这个方法会停下来等待要求到达之后再继续
				Socket s = ss.accept();
				
				inputStreamReader = new InputStreamReader(s.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader);
				
				StringBuffer request =new StringBuffer(); //bufferedReader.readLine();
				String reply = null;
				while (!((reply = bufferedReader.readLine()) == null)) {
					request.append(reply);
				}
			        
				System.out.println("接收到了客户端的请求:"+request);
				//PrintWriter printWriter = new PrintWriter(s.getOutputStream());
				
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "gb2312"));
				
				String advice = "I am Server";
				//回复信息
				advice=replyMessage(request.toString());
				System.out.println("回复信息: "+advice);
				//printWriter.println(advice);
				//printWriter.close();
				writer.write(advice);
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private String test1="<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3002</TransCode><TransDate>20161027</TransDate><TransTime>115615</TransTime><SeqNo>1477540575893</SeqNo></head><body><TransRltMsg>创建帐户成功</TransRltMsg><IAcctNo>76700188000120394</IAcctNo><AuthCode>3ns7lb</AuthCode></body></root>";
	private static String test2="<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3012</TransCode><TransDate>20161028</TransDate><TransTime>013820</TransTime><SeqNo>1477633100930</SeqNo></head><body><Result>1</Result><AddWord>保证金入账明细查询成功!!</AddWord><bank><InDate>20161025</InDate><InTime>143000</InTime><InAmount>1000</InAmount><InName>投标人员1</InName><InAcct>0123456789</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>20151211767001880001142220000240397</HstSeqNum><PunInst></PunInst><Gernal></Gernal></bank><bank><InDate>20161025</InDate><InTime>143000</InTime><InAmount>1000</InAmount><InName>投标人员2</InName><InAcct>1234512345</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>20151211767001880001142220000140389</HstSeqNum><PunInst></PunInst><Gernal></Gernal></bank><bank><InDate>20151211</InDate><InTime>161200</InTime><InAmount>1000</InAmount><InName>投标人员3</InName><InAcct>9003010200030390</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>2015121176700188000114483000023821</HstSeqNum><PunInst></PunInst><Gernal></Gernal></bank><bank><InDate>20151211</InDate><InTime>161200</InTime><InAmount>80</InAmount><InName>投标人员4</InName><InAcct>76680106760000001</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>2015121176700188000114483000013814</HstSeqNum><PunInst></PunInst><Gernal></Gernal></bank></body></root>";
	private String test3="<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3032</TransCode><TransDate>20161027</TransDate><TransTime>010726</TransTime><SeqNo>7b7d66c2-e224-4e8f</SeqNo></head><body><AddWord>接收成功</AddWord><BanK><HstSeqNum>20151211767001880001142220000240397</HstSeqNum><InAcctNo>0123456789</InAcctNo><InName>投标人员1</InName><Result>1</Result></BanK></body></root>";
	private String test4="<?xml version='1.0' encoding='gb2312'?><root><body><TransCode>3042</TransCode><Result>1</Result><AddWord>项目开标时间维护成功</AddWord></body></root>";
	private String test5="<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3052</TransCode><TransDate>20161107</TransDate><TransTime>112701</TransTime><SeqNo>1478489221902</SeqNo></head><body><Result>2</Result><AddWord>已退款</AddWord><bank><InDate>20161028</InDate><InTime>103144</InTime><InAmount>1000</InAmount><InName>投标人员1</InName><InAcct>76700188000120133</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>20151211767001880001142220000240397</HstSeqNum><PunInst>0.07</PunInst><BjPunInst></BjPunInst><Result>3</Result><AddWord>已退款</AddWord></bank><bank><InDate>20161102</InDate><InTime>103628</InTime><InAmount>1000</InAmount><InName>投标人员2</InName><InAcct>9003010200030390</InAcct><InMemo>76700188000121288</InMemo><HstSeqNum>2015121176700188000114483000023821</HstSeqNum><PunInst>7.27</PunInst><BjPunInst></BjPunInst><Result>1</Result><AddWord>初始接收</AddWord></bank></body></root>";
	
	/**
	 * 回复信息
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public String replyMessage(String request) throws Exception {
		JSONObject json = XmlParserUtil.xmlParserJson(request);
		
		JSONObject root = json.getJSONObject("root");
		JSONObject head = root.getJSONObject("head");
		JSONObject body = root.getJSONObject("body");
		
		String transCode = head.getString("TransCode");
		System.out.println("响应码："+transCode);

		String path="";
		String message="";
		switch (transCode) {
		case "3001":// 创建账号
			//message=test1;
			message=createProjectAccount(body);
			break;
		case "4011"://入账查询
			//message=test2;
			message=findPayBankInfo(body);
			break;
//		case "3021":
//			break;
		case "3031"://保证金退款请求
			//message=test3;
			message=requestReturnPayBank(body);
			break;
		case "3041"://开标时间维护
			//message=test4;
			message=editOpenBidTime(body);
			break;
		case "3051"://退款明细查询
			//message=test5;
			message=findReturnPayBank(body);
			break;
		default:
			message="响应码错误";
			break;
		}
		return message;
	}

	/**
	 * 退款明细查询
	 * @param body
	 * @return
	 * @throws Exception 
	 */
	private String findReturnPayBank(JSONObject body) throws Exception {
		//获取请求参数
		String projectNo=body.getString("ItemNo");
		IProjectBankService projectBankService=(IProjectBankService) SpringContextUtil.getBean("projectBankServiceImpl");
		//获取银行接口系统中的项目账号信息
		ProjectBank project=projectBankService.findByProjectNo(projectNo);
		
		//获取该项目的保证金退款信息
		IPayBankService payBankService=(IPayBankService) SpringContextUtil.getBean("payBankServiceImpl");
		List<PayBank> result = payBankService.findReturnPayBank(project==null?null:new PayBank(project.getId()), null);
		
		// 生成XML数据
		Map m = new HashMap();
		m.put("bankList", result);
		m.put("SeqNo", HstSeqNumUtil.makeOrderNum());//流水号
		m.put("date", new Date());//当前时间
		String templatePath = CommUtil.readStringFromFile(modelPath + "/3051.xml");
		String content = CommUtil.freemarkerProcess(m, templatePath);
		System.out.println("退款明细查询:3051--->" + content);

		return content;
	}

	
	/**
	 * 项目开标时间维护
	 * @param body
	 * @return
	 * @throws Exception
	 */
	private String editOpenBidTime(JSONObject body) throws Exception {
		//获取请求参数
		String projectNo=body.getString("BiaoDuanNo");
		
		// 生成XML数据
		Map m = new HashMap();
		String templatePath = CommUtil.readStringFromFile(modelPath + "/3042.xml");
		String content = CommUtil.freemarkerProcess(m, templatePath);
		System.out.println("项目开标时间维护:3042--->" + content);
		return content;
	}

	/**
	 * 保证金退款请求
	 * @param body
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("all")
	private String requestReturnPayBank(JSONObject body) throws Exception {
		//获取请求参数
		JSONObject bank = body.getJSONObject("BanK");
		String hstSeqNum=bank.getString("HstSeqNum");
//		BigDecimal bg=new BigDecimal(hstSeqNum);
//		hstSeqNum=bg.toPlainString();
		
		//通过交易流水号查询缴纳保证金信息
		IPayBankService payBankService=(IPayBankService) SpringContextUtil.getBean("payBankServiceImpl");
		PayBank pay = payBankService.findByHstSeqNum(hstSeqNum);
		
		//修改保证金已申请退款
		pay.setIsReturn(1);//已申请
		PayBank result = payBankService.save(pay);
		
		
		//生成XML数据
		Map m = new HashMap();
		m.put("pay", result);
		m.put("SeqNo", HstSeqNumUtil.makeOrderNum());//流水号
		m.put("date", new Date());//当前时间
		String templatePath=CommUtil.readStringFromFile(modelPath+"/3032.xml");
		String content=CommUtil.freemarkerProcess(m, templatePath);
		System.out.println("保证金退款请求:3032--->"+content);
		
		return content;
	}


	/**
	 * 查询入账明细(缴纳信息)
	 * @param body
	 * @return
	 * @throws Exception 
	 */
	private String findPayBankInfo(JSONObject body) throws Exception {
		//获取请求参数
		String projectNo=body.getString("ItemNo");
		IProjectBankService projectBankService=(IProjectBankService) SpringContextUtil.getBean("projectBankServiceImpl");
		//获取银行接口系统中的项目账号信息
		ProjectBank project=projectBankService.findByProjectNo(projectNo);
		//System.err.println("--> "+project.toString());
		
		//获取该项目的保证金缴纳信息
		IPayBankService payBankService=(IPayBankService) SpringContextUtil.getBean("payBankServiceImpl");
		List<PayBank> result = payBankService.findAll(project==null?null:new PayBank(project.getId()), null);
		
		
		//生成XML数据
		Map m = new HashMap();
		m.put("bankList", result);
		m.put("SeqNo", HstSeqNumUtil.makeOrderNum());//流水号
		m.put("date", new Date());//当前时间
		String templatePath=CommUtil.readStringFromFile(modelPath+"/3012.xml");
		String content=CommUtil.freemarkerProcess(m, templatePath);
		System.out.println("查询入账明细(缴纳信息):3012--->"+content);
		return content;
	}

	/**
	 * 创建项目账号
	 * @param body 
	 * @return
	 * @throws Exception 
	 * @throws Exception 
	 */
	@SuppressWarnings("all")
	public String createProjectAccount(JSONObject body) throws Exception{
		//获取请求参数
		String projectNo=body.getString("ProjectNo");
		String projectId=body.getString("BiaoDuanNo");
		IProjectBankService projectBankService=(IProjectBankService) SpringContextUtil.getBean("projectBankServiceImpl");
		//System.err.println("--------->"+projectBankService);
		
		//创建项目账号
		ProjectBank project=new ProjectBank();
		project.setProjectId(projectId);//竞价系统项目id
		project.setProjectNo(projectNo);//竞价系统项目编号
		project.setAuthCode(AuthCodeGenerate.generateAuthCode(6));//授权码
		project.setAcctNo(AuthCodeGenerate.generateAuthCode(17,"0123456789"));//虚拟子账户
		ProjectBank result = projectBankService.save(project);
		
		//生成XML数据
		Map m = new HashMap();
		m.put("p", result);
		m.put("SeqNo", HstSeqNumUtil.makeOrderNum());//流水号
		m.put("date", new Date());//当前时间
		String templatePath=CommUtil.readStringFromFile(modelPath+"/3002.xml");
		String content=CommUtil.freemarkerProcess(m, templatePath);
		System.out.println("创建项目账号:3002--->"+content);
		return content;
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server();
//		server.startServer();
		
//		server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>3001</TransCode><TransDate>20161123</TransDate><TransTime>030842</TransTime><SeqNo>1479884922271</SeqNo></head><body><AcctNo>79410188000131028</AcctNo><ProjectNo>2016BHHWJ0001</ProjectNo><BiaoDuanNo>297e104e58855e21015885d4879b0010</BiaoDuanNo><ProjectName>包河区政府采购中心网络设备采购</ProjectName><OpenDate>20161128</OpenDate><OpenTime>030000</OpenTime><IsRetire>0</IsRetire><MatuDay></MatuDay></body></root>");
		server.replyMessage("<?xml version='1.0' encoding='gb2312'?><root><head><TransCode>4011</TransCode><TransDate>20161228</TransDate><TransTime>044701</TransTime><SeqNo>1482914821999</SeqNo></head><body><ItemNo>www1490185114225</ItemNo><ItemNox>1490185114225</ItemNox><AuthCode>fsdf31</AuthCode></body></root>");
		
	}
	
	
}

