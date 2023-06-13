package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;


@WebServlet("/register")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdaoimpl;
	
	@Override
	public void init() throws ServletException {
		//call the userdao and candidate dao implemented classes
		try {
			userdaoimpl=new UserDaoImpl();
			
			
		} catch (Exception e) {
			throw new ServletException(" err in init of "+getClass(),e);
		}
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.set contenttype
		resp.setContentType("text/html");
		//2.get Pw
		try(PrintWriter pw=resp.getWriter())
		{
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String confirmpasword=req.getParameter("confirm-password");
			LocalDate dob=LocalDate.parse(req.getParameter("dob"));
			Period period=Period.between(dob, LocalDate.now());
			Date dob1=Date.valueOf(req.getParameter("dob"));
			
			int age=period.getYears();
			
			int remaining=18-age;
			
			
//			HttpSession hs=req.getSession();
//			UserDaoImpl userdaoimpl=(UserDaoImpl)hs.getAttribute("user_daoimpl");
			if(password.equals(confirmpasword))
			{
				if(age>18)
				{
					pw.print("<h3>"+ userdaoimpl.addusers(fname,lname, email, password,dob1)+"</h3>");	
				}
				else {
					pw.print(" <h3> Sorry you are not eligible to vote !!!<br> please visit after "+ remaining +" years </h3>");
				}
				
			}
			else {
				pw.print(" Incorrect Password !!! ");
			}
			
			
		} catch (Exception e) {
			
			throw new ServletException("error in dopost of :: "+getClass(),e);
			
		}
	}

	@Override
	public void destroy() {
		try {
			userdaoimpl.Cleanup();
		}
		catch(Exception e)
		{
			System.out.println(" error in destroy "+e.getMessage());
		}
		
	}
}
