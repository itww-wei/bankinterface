package com.htmic.bankinterface.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.htmic.bankinterface.model.ProjectBank;
import com.htmic.bankinterface.service.IProjectBankService;
import com.htmic.bankinterface.utils.CommUtil;
import com.htmic.bankinterface.utils.PageDto;
import com.htmic.bankinterface.utils.Sort;


/**
 * Created by wei on 2017/3/20.
 */
@RequestMapping("/project")
@Controller
public class ProjectBankController {

    @Resource
    private IProjectBankService projectBankService;

//    @RequestMapping("/test/{id}")
//    public ModelAndView testUser(@PathVariable("id") String id){
//    	ModelAndView mv=new ModelAndView("/portal/index");
//    	ProjectBank pb=new ProjectBank();
//    	pb.setId(id);
//    	List<ProjectBank> res = projectBankService.findAll(pb);
//    	for (ProjectBank p : res) {
//    		System.err.println(p.toString());
//		}
//        return mv;
//    }
    
    
    @RequestMapping("/test")
    @ResponseBody
    public String testUser(@RequestParam Map<String, Object> map,Integer start,ProjectBank project,PageDto page) throws Exception{
    	//ModelAndView mv=new ModelAndView("/portal/index");
    	project.setCreateTime(new Date());
    	project.setProjectNo("www"+System.currentTimeMillis());
    	project.setAcctNo("rrrr"+System.currentTimeMillis());
    	project.setAuthCode(("fsdf3"+System.currentTimeMillis()).substring(0, 6));
    	project.setProjectId(System.currentTimeMillis()+"");
    	projectBankService.save(project);
    	return this.getJson();
    }
    
    /**
     * 项目虚拟账号信息首页
     * @return
     */
    @RequestMapping("/testIndex")
    public ModelAndView testIndex(){
    	ModelAndView mv=new ModelAndView("/business/test/project");
        return mv;
    }
    
    /**
     * 项目虚拟账号信息首页
     * @return
     */
    @RequestMapping("/project")
    public ModelAndView project(){
    	ModelAndView mv=new ModelAndView("/business/project/project");
        return mv;
    }
    
    /**
     * 项目虚拟账号信息列表
     * @param page
     * @param project
     * @return
     * @throws Exception
     */
    @SuppressWarnings("all")
	@RequestMapping(value="/list")
    @ResponseBody
    public String list(@RequestBody PageDto page,ProjectBank project,HttpServletRequest request) throws Exception{
    	String no=request.getParameter("projectNo");
    	List<ProjectBank> list = projectBankService.findAll(project,page);
    	return CommUtil.getPageJSONData(page, true).toString();
    }
    
    
    public String getJson(){
    	return "{\"page\":0,\"limit\":10,\"total\":66,\"data\":[{\"id\":\"1\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"2\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"3\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"4\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"5\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"6\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"7\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"8\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"9\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"},{\"id\":\"10\",\"name\":\"Tiger Nixon\",\"position\":\"System Architect\",\"salary\":\"$320,800\",\"start_date\":\"2011/04/25\"}]}";
    }
}
