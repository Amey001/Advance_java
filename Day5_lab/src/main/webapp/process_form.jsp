<%@page import="pojos.Student"%>
<%@page import="pojos.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//out.flush(); //exc
	// 1. read req param : Student details
	String firstname=request.getParameter("fn");
	String lastname=request.getParameter("ln");
	int score=Integer.parseInt(request.getParameter("score"));
	Course course=Course.valueOf(request.getParameter("course").toUpperCase());
	
	Student s1=new Student(firstname,lastname,score,course);
	if(score>course.getMinScore())
	{
		s1.setAdmitted(true);
		//server pull :forward 
		//min Scope of attributes : page | request | session | application ---> request is the best 
		//add attribute
		request.setAttribute("student_details", s1);
		
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
	
		rd.forward(request, response);
	
		System.out.println(" come backed to process_form ");  // it will print on console
	}
	



%>>


</body>
</html>