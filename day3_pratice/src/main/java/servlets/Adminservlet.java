package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatedaoImpl;
import pojo.Candidate;
import pojo.User;

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
			HttpSession hs=request.getSession();
			User user=(User)hs.getAttribute("user_details");
			if(user.getRole().equals("admin"))
			{
				pw.print("<h3>Logged in as Admin Welcome </h3>");
				pw.print("<h3>"+user.getFirstName()+"  "+user.getLastName()+"</h3>");
			}
			
			CandidatedaoImpl candidatedao=(CandidatedaoImpl)hs.getAttribute("candidate_daoimpl");
			List<Candidate> candidatelists=new ArrayList<>();
			
			candidatelists=candidatedao.allcandidatelist();
			//displaying table of candidates with their voting count !!!
			pw.print("<table border='2'>");
			pw.print("<tr>");
			
			pw.print("<th>Id</th>");
			pw.print("<th>Name</th>");
			pw.print("<th>party</th>");
			pw.print("<th>Votes</th>");
			
			pw.print("</tr>");
		
			for(Candidate c:candidatelists)
			{
				pw.print("<tr>");
				
				pw.print("<td>"+ c.getCandidateId()+"</td>");
				pw.print("<td>"+ c.getName()+"</td>");
				pw.print("<td>"+ c.getParty()+"</td>");
				pw.print("<td>"+ c.getVotes()+"</td>");
				
				pw.print("</tr>");
			}
			
		
			pw.print("</table>");
			
			
		}
		catch(Exception e)
		{
			throw new ServletException(" err in doget of "+getClass(),e);
		}
	
	}

}
