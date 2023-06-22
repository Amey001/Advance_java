package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/departments") //optional but reco.for seperation 
//: this spring bean will handle all dept related ewquests
public class DepartmentController {
	
	//Sc will serach for springbean of the  type departmentService 
	//dependency :: service layer i/f
	@Autowired //bytype,field level D.I
	private DepartmentService deptService;
	
	//constructor
	public DepartmentController() {
		System.out.println(" in ctor of "+ getClass());
		
	}
	
	//add a request handling method
	@GetMapping("/list")
	public ModelAndView showdetails()
	{
		System.out.println(" in get dept list !!");
		return new ModelAndView("/dept/list","dept_list",deptService.getAllDepts());
		//controller -->MNV -->DS -->LVN-->VR -->AVN :/WEB-INF/views/dept/list.jsp
		//-->YES-->request.setAttribute("dept_list",dept list);
		//-->RD rd=request.getRD("/WEB-INF/views/dept/list.jsp");
		//rd.forward(request,response) -->JSP : ${...}
	}

}
