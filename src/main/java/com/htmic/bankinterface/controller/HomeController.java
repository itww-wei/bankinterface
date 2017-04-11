package com.htmic.bankinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页
 * @author wei
 *
 */
@RequestMapping("/portal")
@Controller
public class HomeController {
	
	@RequestMapping("/index")
    public ModelAndView testUser(){
    	ModelAndView mv=new ModelAndView("/portal/index");
        return mv;
    }
}
