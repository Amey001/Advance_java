package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //manditory to tell Sc :: following is req handling 
//controller =handler,containing req handling methods
public class HomePageController {

	public HomePageController() {
		System.out.println(" in ctor of :: "+ getClass());
		
	}
	
	//add a req handling method to forward the clnt to index.jsp
	@RequestMapping("/") //can intercept get/put/post/delete ...
	public ModelAndView showHomePage()
	{
		System.out.println(" in show home page !!");
		//API o.s.w.s ModelAndView(String viewname,String modelAttrName,Object value)
		return new ModelAndView("/index","timestamp",LocalDateTime.now());	
//Handler( Controller) returns MNV(modelnview) object-->D.S(dispatcher servlet)
//-->sends L.V.N-->V.R-->AVN : /WEB-INF/views/index.jsp-->D.S		
//chks for modelattr-->Yes-->saves it under the request scope
//Why ? -->because it server pull -->RD rd=request.getRd("/WEB-INF/views")
//rd.forward(request,response)-->JSP--.${...}...in index.jsp dynamic respose generation
	}
	
}
//Controller will call the service layer for B.L bean Controller(dependent) 
//on service(dependency) sitting in IOC(inversion control)
//
//service is going to call Hibernatebased dao layer -->AutoWire DAO
//dao -->DB and Db returns the 
