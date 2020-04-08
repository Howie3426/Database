<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Favorite Comedians</h1>
	
	<a href = "favComedian.jsp"></a>
	
	<form action = "favComedian" method = "post">
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
    
     <label for = "ID"><b>ID</b></label>
    <input type = "text" placeholder = "ID" name = "ID" required>
    
    <br>
    <br>
    
    <button type="submit" class="add">Add</button>
    <button type="submit" class="delete">Delete</button>
    
    
     <sql:setDataSource
        var="Database Project"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/Database Project"
        user="john" password="pass1234"
    />
     
    <sql:query var="listUsers"   dataSource="${Database Project}">
        SELECT * FROM favoritecomedian;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of comedians</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
            <c:forEach var="user" items="${listfavoritecomedian.rows}">
                <tr>
                    <td><c:out value="${favoritecomedian.id}" /></td>
                    <td><c:out value="${user.userName}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    
</div>
</form>
</body>
</html>