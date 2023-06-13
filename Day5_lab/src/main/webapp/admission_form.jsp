<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
    }
  
    h1 {
      text-align: center;
    }
  
    .form-container {
      max-width: 500px;
      margin: 0 auto;
      background-color: #f2f2f2;
      padding: 20px;
      border-radius: 5px;
    }
  
    .form-group {
      margin-bottom: 20px;
    }
  
    .form-group label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
  
    .form-group input[type="text"],
    .form-group input[type="lname"],
    .form-group select {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
  
    .form-group input[type="submit"] {
      background-color: #4CAF50;
      color: #fff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
    }
  </style>
</head>
<body>
 <!-- <form action="process_form" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="ln" /></td>
			</tr>
			<tr>
				<td>Enter Score</td>
				<td><input type="number" name="score" /></td>
			</tr>
			<tr>
				<td>Enter Course</td>
				<td><input type="text" name="course" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Student Admission" /></td>
			</tr>
		</table>
	</form> -->
	
	
	<h1>Admission Form</h1>
  <div class="form-container">
    <form action="process_form.jsp" method="post">
      <div class="form-group">
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" required>
      </div>
      <div class="form-group">
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" required>
      </div>
      <div class="form-group">
        <label for="score">Score:</label>
        <input type="text" id="score" name="score" required>
      </div>
      <div class="form-group">
        <label for="course">Course : </label>
        <input type="text" id="course" name="course" required>
      </div>
      
      <div class="form-group">
        <input type="submit" value="Student Admission">
      </div>
    </form>
  </div> 

</body>
</html>