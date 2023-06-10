package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminservlet
 */
@WebServlet("/Adminservlet")
public class Adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.setcontenttype
		response.setContentType("text/html");
		//2.
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h3>Welcome to Admin Page </h3>");
			
		}
		catch(Exception e)
		{
			throw new ServletException(" err in doget of "+getClass(),e);
		}
	
	}

}
