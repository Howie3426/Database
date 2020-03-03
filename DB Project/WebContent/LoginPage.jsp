<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="LoginPage.css"/>
</head>
<body>

	<h1>Login Page.</h1>
	<p>Please enter email and password.</p>
	<a href = "LoginPage.jsp">Login</a>
	
<form action = "LoginServlet" method = "post">
	<div class = "box1"> 
		<div class = "box2">
			<label for = "userName"><b>User Name</b></label>
			<input type = "text" placeholder = "Enter Username" name = "userName" required>
			<b></b>
			<label for = "password"><b>Password</b></label>
			<input type = "text" placeholder = "Enter Password" name = "password" required>
			
			<div class = "button">
				<button type = "Submit" class = "sumbmit">Submit</button>
				<span class = "psw">Forgot <a href = "#">password?</a></span>
			</div>
		</div>
	</div>
</form>

</body>
</html>