package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatedaoImpl;
import dao.UserDaoImpl;
import pojo.User;

@WebServlet(value="/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet{
	private UserDaoImpl userdao;
	private CandidatedaoImpl candidatedaoimpl;
	
	
	@Override
	public void init() throws ServletException {
		try {
			userdao=new UserDaoImpl();
			candidatedaoimpl=new CandidatedaoImpl();
		}catch(Exception e)
		{
			throw new ServletException("err in init of "+getClass(),e);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//1.set contenttype
		resp.setContentType("text/html");
	//2.get Pw
		try(PrintWriter pw=resp.getWriter())
		{
			String email=req.getParameter("em");
			String password=req.getParameter("pass");
			User user=userdao.authentiateuser(email,password);
			
			if(user==null)
			{
				pw.print("login failed !!");
			}
			else {
				//successfull login
				
				// 1.get HttpSession from WC
				HttpSession hs=req.getSession();
				
				// store validated user dtls n dao instances under session  scope
				hs.setAttribute("user_details",user);
				hs.setAttribute("user_daoimpl", userdao);
				hs.setAttribute("candidate_daoimpl", candidatedaoimpl);
				
				
				if(user.getRole().equals("admin"))
				{
					resp.sendRedirect("Adminservlet");
				}
				else {
					if(user.isVotingStatus())
					{
						resp.sendRedirect("logout");
					}
					else {
						resp.sendRedirect("candidate_list");
					}
				}
			}
		}
		catch(Exception e)
		{
			throw new ServletException("err in do post of "+getClass(),e);
		}
		
		
	}

	@Override
	public void destroy() {
		try {
			userdao.Cleanup();
			candidatedaoimpl.Cleanup();
		}catch(Exception e)
		{
		System.out.println("err in destory of "+getClass()+ " " +e);
		}
		
	}

	
	

}
