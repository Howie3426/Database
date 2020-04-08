<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Registration</title>
<link rel="stylesheet" type="text/css" href="LoginRegistration.css"/>
</head>
<body>

	<h1>Login Registration Page</h1>
	<p>Fill out the following fields</p>
	
	<a href = "LoginRegistration.jsp"></a>
	
	<form action = "RegistrationServlet" method = "post">
 	<div class="container">
    <hr>

    <label for="userName"><b>User Name</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

	<br>
	<br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

	<br>
	<br>

    <label for="password-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="password-repeat" required>
    
	<br>
	<br>
    
    <label for = "firstName"><b>First Name</b></label>
    <input type = "text" placeholder = "First Name" name = "firstName" required>
    
	<br>
	<br>
    
    <label for = "lastName"><b>Last Name</b></label>
    <input type = "text" placeholder = "Last Name" name = "lastName" required>
    
	<br>
	<br>
    
     <label for = "age"><b>Age</b></label>
    <input type = "text" placeholder = "age" name = "age" required>
    
	<br>
	<br>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>


</body>
</html>