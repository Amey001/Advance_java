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

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.set Contenttype
		response.setContentType("text/html");
		//2.get PW
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("Welcome to Logout Page !!!");
			
			//get the session
			HttpSession hs=request.getSession();
			User voter=(User)hs.getAttribute("user_details");
			
			//check is voter is null 
			if(voter!=null)
			{
				if(voter.isVotingStatus())
				{
					pw.print("You have already voted !!!");
				}
				else {
					//user has not yet voted..
					//http://localhost:8080/day3.1/logout?cid=6
					int candidate=Integer.parseInt(request.getParameter("cid"));
					UserDaoImpl userdao=(UserDaoImpl)hs.getAttribute("user_daoimpl");
					CandidatedaoImpl candidatedao=(CandidatedaoImpl)hs.getAttribute("candidate_daoimpl");
					
					pw.print("<h5>"+userdao.updateVotingStatus(voter.getId())+"</h5>");
					pw.print("<h5>"+candidatedao.incrementCandidateVotes(candidate)+"</h5>");
					
				}
			}
			else {
				System.out.println("No Session Tracking !!!");
				//closing the session 
				hs.invalidate();
				System.out.println("You Have been logged Out !!!");	
			}
		}
		catch(Exception e)
		{
			throw new ServletException("error in do get of "+getClass(),e);
		}

		
	}

}
