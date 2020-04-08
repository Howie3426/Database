<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Watching Video</title>
</head>
<body>
	
	<a href = "watchvideo.jsp"></a>
		
	<form action = "watchvideo" method = "post">
 	<div class="container">
    <hr>
    
    <label for="search"><b>Kevin Hart: Makes Me Laugh</b></label>
    
    
    <br>
    <br>
    
    <iframe src="https://www.youtube.com/watch?v=HJmFmYYZAac" style="height:300px;width:500px;"></iframe>
    
    <br>
    <br>

    <button type="submit" class="Add">Add</button>
    
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
     
<%@ page import="java.sql.*,java.util.*" %>
<%@ page import="java.io.*" %>

<% 
     
	String video_url =request.getParameter("url");
	String video_title=request.getParameter("title");
	String video_description=request.getParameter("description");
	String video_tags=request.getParameter("tags");
	String video_id=request.getParameter("videoid");
	String video_userid=request.getParameter("userid");
	String video_comedianid=request.getParameter("comedianid");
	
	
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csc4710", "root", "pass1234");
	String queryString = "insert into video (title, description, url, videoID, userID, comedianID, tags) values(?,?,?,?,?,?,?)";
	PreparedStatement pstatement = conn.prepareStatement(queryString);
	
	pstatement.setString(1, video_title);
	pstatement.setString(2, video_description);
	pstatement.setString(3, video_url);
	pstatement.setString(4, video_id);
	pstatement.setString(5, video_userid);
	pstatement.setString(6, video_comedianid);
	pstatement.setString(7, video_tags);
	int updateQuery = 0;
	updateQuery = pstatement.executeUpdate();
	
	 System.out.println("Data is successfully inserted!");
	}
	catch(Exception e)
		{
			System.out.println("Data was not inserted");
			System.out.print(e);
			e.printStackTrace();
		}
	
%>

</div>
</form>
</body>
</html>