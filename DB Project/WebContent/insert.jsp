<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Video</title>
</head>
<body>
		<h1>Insert Video</h1>
	
	<a href = "insert.jsp"></a>
	
	<form action = "insert" method = "post">
 	<div class="container">
    <hr>

    <label for="url"><b>URL</b></label>
    <input type="text" placeholder="Enter URL" name="url" required>

	<br>
	<br>

    <label for="title"><b>title</b></label>
    <input type="text" placeholder="Enter Title" name="title" required>
    
	<br>
	<br>
    
    <label for = "description"><b>Description</b></label>
    <input type = "text" placeholder = "Description" name = "description" required>
    
	<br>
	<br>
    
    <label for = "date"><b>Date</b></label>
    <input type = "text" placeholder = "date" name = "date" required>
    </div>
</form>
</body>
</html>