<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Menu</title>
</head>
<body>
			<h1>User Menu</h1>
	
	<a href = "insert.jsp"></a>
	
	<form action = "insert" method = "post">
 	<div class="container">
    <hr>

    <label for="search"><b>URL</b></label>
    <input type="text" placeholder="URL" name="URL">

	<br>
	<br>
	
	
    <label for="Title"><b>Title</b></label>
    <input type="text" placeholder="Title" name="Title">

	<br>
	<br>
	
	<label for="Description"><b>Description</b></label>
    <input type="text" placeholder="Description" name="Description">

	<br>
	<br>
	
	<label for="Tags"><b>Tags</b></label>
    <input type="text" placeholder="Tags" name="Tags">
	
	<br>
	<br>
	
	 <button type="submit" class="Submit">Submit</button>
    
   </div>
   </form>
    
</body>
</html>
