package pages;

//when will web container creates a empty maps? -->Web Application deployment time

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//loadonstartup=-1 its lazy
//@WebServlet(value="/test1",loadOnStartup=2)  //internally are web servlets

@WebServlet("/test1")
//Wc reads this only once @ web app dep time
//Wc creates an empty map n then populates URL map
//key ::test1  value ::pages.Servlet1  (fully qualified servlet class name)
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" in do-get by "+Thread.currentThread());
		
		//1.Set response Content type(setting resp Header content-type:text/html 
		resp.setContentType("text/html");  //made for client
		//2 get the printWriter to send the character oriented buffer data (resp) to client
		try(PrintWriter pw=resp.getWriter())
		{	//print in the buffer of printwriter
			pw.print("<h1>Welcome 2 Servlet"+getClass()+" TS :: "+LocalDateTime.now()+"</h1>");	//get class will give you the name of class loaded
			
			
		}//Wc : pw.flush()-->buffer contents are sent -->pw.close()
	}

	@Override
	public void destroy() {
		System.out.println(" in destroy !!"+Thread.currentThread());
	}

	// First method is called
	@Override
	public void init() throws ServletException {
		System.out.println(" in init method !! "+Thread.currentThread());
	}
	
	

}
