<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Registration</title>
<link href = "/css/LoginRegistration.css" rel = "stylesheet" type ="type/css">
</head>
<body>

	<h1>Login Registration Page</h1>
	<p>Fill out the following fields</p>
	
	<a href = "LoginPage.jsp">Login</a>
	
	<form action = "LoginServlet" method = "post">
 	<div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="userName"><b>User Name</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="password-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="password-repeat" required>
    
    <label for = "firstName"><b>First Name</b></label>
    <input type = "text" placeholder = "First Name" name = "firstName" required>
    
    <label for = "lastName"><b>Last Name</b></label>
    <input type = "text" placeholder = "Last Name" name = "lastName" required>
    
     <label for = "age"><b>Age</b></label>
    <input type = "text" placeholder = "age" name = "age" required>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>


</body>
</html>