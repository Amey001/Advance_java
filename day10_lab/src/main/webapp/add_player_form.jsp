<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%-- import JSTL's core tag lib--%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      padding: 20px;
  background-image: linear-gradient(to right, #0099f7, #f11712);
    }
    
    h1 {
      text-align: center;
      color: black;
      
    }
    
    form {
      max-width: 400px;
      margin: 0 auto;
      background-color: #fff;
     
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 5px 10px ;
    }
    
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    
    select, input[type="text"], input[type="date"], input[type="number"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-bottom: 10px;
      font-size: 14px;
    }
    
    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
    
    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>

</head>
<!--jsp will call the beans constructor and keep under application -->
<jsp:useBean id="ipl" class="beans.IPLBean" scope="application" />

<body>
	<%-- <form action="process_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Select Team</td>
				<td><select name="myTeam">
				<c:forEach var="t" items="${applicationScope.ipl.fetchAllTeams()}">
						<option value="${t.id}">${t.abbreviation}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Select DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><input type="number" value="0.00" step="0.01" name="avg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form> --%>
	<h1>Add Player to IPL Team</h1>
  
  <form action="process_form.jsp" method="get">
    <label for="team">Team Name:</label>
   <select name="myTeam">
	<c:forEach var="t" items="${applicationScope.ipl.fetchAllTeams()}">
	<option value="${t.id}">${t.abbreviation}</option>
	</c:forEach>
</select>
    
    <br><br>
    
    <label for="fname">FirstName:</label>
    <input type="text" id="fname" name="fname" required>
    
    <br><br>
    
    <label for="lname">LastName:</label>
    <input type="text" id="lname" name="lname" required>
    <br><br>
    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" required>
    
    <br><br>
    
    <label for="battingAvg">Batting Average:</label>
    <input type="number" step="0.1" id="battingAvg" name="battingAvg" required>
    
    <br><br>
    
    <label for="wickets">Wickets Taken:</label>
    <input type="number" id="wickets" name="wickets" required>
    
    <br><br>
    
    <input type="submit" value="Add Player">
  </form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>