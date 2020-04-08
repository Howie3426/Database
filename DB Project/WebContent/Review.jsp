<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>
</head>
<body>
<h1>Review Page</h1>

<a href = "Review.jsp"></a>

	<form action = "Review" method = "post">
 	<div class="container">
    <hr>
    
    <label for = "firstName"><b>First Name</b></label>
    <input type = "text" placeholder = "First Name" name = "firstName" required>
    
	<br>
	<br>
    
    <label for = "lastName"><b>Last Name</b></label>
    <input type = "text" placeholder = "Last Name" name = "lastName" required>
    
    <br>
    <br>
    
     <label for = "URL"><b>URL</b></label>
    <input type = "text" placeholder = "URL" name = "URL" required>
    
    <br>
    <br>
    
     <label for = "Title"><b>Title</b></label>
    <input type = "text" placeholder = "Title" name = "Title" required>
    
    <br>
    <br>
    
    <b>Review:</b>
    <select name = "Review">
    <option>Excellent</option>
    <option>Good</option>
    <option>Fair</option>
    <option>Poor</option>
    </select>
    
    <br>
    <br>
    
    <b>Description:</b>
    <div class = "description">
     <textarea name="paragraph_text" cols="50" rows="10"></textarea>
     </div>
     
     <br>

     <button type="submit" class="Submit">Submit</button>
    
    
</div>
</form>

</body>
</html>