package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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


@WebServlet("/candidate_list")
public class candidate_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1.setContentType
		response.setContentType("text/html");
	//get PW
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h3> Welcome to Candidate List Page !!</h3>");
			
			HttpSession hs=request.getSession();
			
			//retrieve the user details 
			User userdetails=(User)hs.getAttribute("user_details");
			if(userdetails!=null)
			{
				pw.print("<h2>"+ "Hello "+userdetails.getFirstName()+userdetails.getLastName()+"</h2>");
				
				CandidatedaoImpl dao=(CandidatedaoImpl)hs.getAttribute("candidate_daoimpl");
				List<Candidate> candidatelist=dao.allcandidatelist();
				
				pw.print("<form action='logout'>");
				for(Candidate c:candidatelist)
				//creating dynamic form
				pw.print("<h4><input type='radio' name='cid' value='"+c.getCandidateId()+"'/>"+c.getName()+"</h4>");
				pw.print("<h4><input type='Submit' value='Cast a Vote'></h4>");
				pw.print("</form>");
			}
			else {
				System.out.println("Sesion Tracking Failed !!,No Cookies...");
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException("err in doget of "+getClass(),e);
		}
		
	}

}
