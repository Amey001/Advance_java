<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello, ${params.fn} , ${requestScope.student_details.lastName} </h5>
	
	<%
	Student s1=(Student)request.getAttribute("student_details");
		if(s1.isAdmitted())
		{
			%>
			<h3 style="color"> Congratulation !!! you have been Admitted to  ${requestScope.student_details.selectedCourse}</h3>
			<% 
			
		}
		else{
			%>
		<h3 style="color"> Sorry !!!  Regret to inform that you can't be  admitted in ${requestScope.student_details.selectedCourse}</h3>	
			<%
			
		}
	%>

</body>
</html>