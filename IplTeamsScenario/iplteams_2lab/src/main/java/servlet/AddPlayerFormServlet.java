package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamdaoImpl;
import pojos.Teams;

@WebServlet(value="/addplayerform",loadOnStartup = 1)
public class AddPlayerFormServlet extends HttpServlet{
	TeamdaoImpl teamdaoimp;
		
	@Override
	public void init() throws ServletException {
		try {
			teamdaoimp=new TeamdaoImpl();
			
		} catch(Exception e) {
			throw new ServletException(" in init of "+getClass(),e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		1.set Contenttype
		resp.setContentType("text/html");
		//get PW
		try(PrintWriter pw=resp.getWriter())
		{
//			//get the team list
			List<Teams> teams=teamdaoimp.getSelectedDetails();
			//create a dynamic form 
			pw.print("<style>\r\n"
					+ "    body {\r\n"
					+ "      font-family: Arial, sans-serif;\r\n"
					+ "      background-color: #f2f2f2;\r\n"
					+ "      padding: 20px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    h1 {\r\n"
					+ "      text-align: center;\r\n"
					+ "      color: #333;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    form {\r\n"
					+ "      max-width: 400px;\r\n"
					+ "      margin: 0 auto;\r\n"
					+ "      background-color: #fff;\r\n"
					+ "      padding: 20px;\r\n"
					+ "      border-radius: 5px;\r\n"
					+ "      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    label {\r\n"
					+ "      display: block;\r\n"
					+ "      font-weight: bold;\r\n"
					+ "      margin-bottom: 5px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    select, input[type=\"text\"], input[type=\"date\"], input[type=\"number\"] {\r\n"
					+ "      width: 100%;\r\n"
					+ "      padding: 8px;\r\n"
					+ "      border: 1px solid #ccc;\r\n"
					+ "      border-radius: 4px;\r\n"
					+ "      box-sizing: border-box;\r\n"
					+ "      margin-bottom: 10px;\r\n"
					+ "      font-size: 14px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    input[type=\"submit\"] {\r\n"
					+ "      background-color: #4CAF50;\r\n"
					+ "      color: white;\r\n"
					+ "      padding: 10px 15px;\r\n"
					+ "      border: none;\r\n"
					+ "      border-radius: 4px;\r\n"
					+ "      cursor: pointer;\r\n"
					+ "      font-size: 16px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    input[type=\"submit\"]:hover {\r\n"
					+ "      background-color: #45a049;\r\n"
					+ "    }\r\n"
					+ "  </style>");
			pw.print("<form>\r\n"
					+ "    <label for=\"team\">Team Name:</label>\r\n"
					+ "    <select id=\"team\" name=\"team\">\r\n"
					+ "      <option value=\"Mumbai Indians\">Mumbai Indians</option>\r\n"
					+ "      <option value=\"Chennai Super Kings\">Chennai Super Kings</option>\r\n"
					+ "      <option value=\"Kolkata Knight Riders\">Kolkata Knight Riders</option>\r\n"
					+ "      <option value=\"Royal Challengers Bangalore\">Royal Challengers Bangalore</option>\r\n"
					+ "      <option value=\"Rajasthan Royals\">Rajasthan Royals</option>\r\n"
					+ "      <option value=\"Delhi Capitals\">Delhi Capitals</option>\r\n"
					+ "      <option value=\"Punjab Kings\">Punjab Kings</option>\r\n"
					+ "      <option value=\"Sunrisers Hyderabad\">Sunrisers Hyderabad</option>\r\n"
					+ "    </select>\r\n"
					+ "    \r\n"
					+ "    <br><br>\r\n"
					+ "    \r\n"
					+ "    <label for=\"name\">Name:</label>\r\n"
					+ "    <input type=\"text\" id=\"name\" name=\"name\" required>\r\n"
					+ "    \r\n"
					+ "    <br><br>\r\n"
					+ "    \r\n"
					+ "    <label for=\"dob\">Date of Birth:</label>\r\n"
					+ "    <input type=\"date\" id=\"dob\" name=\"dob\" required>\r\n"
					+ "    \r\n"
					+ "    <br><br>\r\n"
					+ "    \r\n"
					+ "    <label for=\"battingAvg\">Batting Average:</label>\r\n"
					+ "    <input type=\"number\" step=\"0.01\" id=\"battingAvg\" name=\"battingAvg\" required>\r\n"
					+ "    \r\n"
					+ "    <br><br>\r\n"
					+ "    \r\n"
					+ "    <label for=\"wickets\">Wickets Taken:</label>\r\n"
					+ "    <input type=\"number\" id=\"wickets\" name=\"wickets\" required>\r\n"
					+ "    \r\n"
					+ "    <br><br>\r\n"
					+ "    \r\n"
					+ "    <input type=\"submit\" value=\"Add Player\">\r\n"
					+ "  </form>");
			
			
		}catch(Exception e)
		{
			throw new ServletException(" in do get of "+getClass(),e);
		}
	
	}

	
	@Override
	public void destroy() {
		System.out.println("in destroy of "+getClass());
	}

	
	
	

}
