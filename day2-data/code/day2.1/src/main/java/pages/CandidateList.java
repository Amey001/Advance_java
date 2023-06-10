package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			//get the cookies from request header 
			//API of httpServletRequest : Cookies[] getCookies()
			Cookie[] cookies=request.getCookies();
			if(cookies!=null)
			{
				//getName,getValue : Cookie class methods
				for(Cookie c: cookies)
				{
					if(c.getName().equals("user_dtls"))
					{
						pw.print("<h5> Validated user_details"+c.getValue()+"</h5>");
						break;
					}
				
				else {
					pw.print("<h5> Sessio tracking failed No cookies Found!!! </h5>");
				}
				}
				pw.print("<h5>Validated user details"+"</h5>");
			}
			else {
				pw.print("<h5> Session Tracking Failed,No Cookies!!!!!</h5> ");
			}
			
			pw.print("<h5>In candidate list page ....</h5>");
			pw.print("<h5> Validated user email " + request.getParameter("em") + "</h5>");
		}
	}

}
