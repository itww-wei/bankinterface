package com.htmic.bankinterface.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.htmic.bankinterface.model.PayBank;
import com.htmic.bankinterface.model.ProjectBank;
import com.htmic.bankinterface.service.IPayBankService;
import com.htmic.bankinterface.service.IProjectBankService;
import com.htmic.bankinterface.utils.CommUtil;
import com.htmic.bankinterface.utils.HstSeqNumUtil;
import com.htmic.bankinterface.utils.PageDto;

/**
 * 保证金缴纳信息
 * @author wei
 *
 */
@SuppressWarnings("all") 
@RequestMapping("/pay")
@Controller
public class PayBankController {
	
	@Resource
	private IPayBankService payBankService;
	
	@Resource
    private IProjectBankService projectBankService;
	
	/**
	 * 保证金缴纳信息页面
	 * @return
	 */
	@RequestMapping("/pay")
    public ModelAndView pay(String projectId){
		ModelAndView mv=new ModelAndView("/business/pay/pay");
		//查询项目信息
		ProjectBank project = projectBankService.findOne(projectId);
		mv.addObject("project",project);
        return mv;
    }
	
	/**
     * 项目虚拟账号信息列表
     * @param page
     * @param project
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list(PageDto page,PayBank pay) throws Exception{
    	String inName=new String(pay.getInName().trim().getBytes("ISO-8859-1"), "UTF-8");
    	pay.setInName(inName);
    	List<PayBank> list = payBankService.findAll(pay,page);
    	return CommUtil.getPageJSONData(page, true).toString();
    }
    
    @RequestMapping("/save")
    @ResponseBody
    public String save(PayBank pay){
    	pay.setHstSeqNum(HstSeqNumUtil.makeOrderNum()+"HT");//生成交易流水号
    	pay.setInDate(new Date());
    	payBankService.save(pay);
    	return "success";
    }
    
    /**
     * 缴纳保证金页面
     * @param projectId
     * @return
     */
    @RequestMapping("/input")
    public ModelAndView input(String projectId){
		ModelAndView mv=new ModelAndView("/business/pay/input");
		//查询项目信息
		ProjectBank project = projectBankService.findOne(projectId);
		mv.addObject("project",project);
        return mv;
    }
    
    /**
     * 退款
     * @param pay
     * @return
     */
    @RequestMapping("/refund")
    @ResponseBody
    public String refund(PayBank pay){
    	//查询数据库保证金信息
    	PayBank payBank = payBankService.findOne(pay.getId());
    	payBank.setRefundDate(new Date());
    	payBank.setIsReturn(2);//已退款
    	payBank.setAddWord("已退款");
    	payBankService.save(payBank);
    	return "success";
    }
}
