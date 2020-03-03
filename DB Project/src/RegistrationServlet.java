import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/db";
    String DB_USERNAME = "john";
    String DB_PASSWORD = "pass1234";
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException
    	{
    		String userName = request.getParameter("userName");
    		String password = request.getParameter("password");
    		String firstName = request.getParameter("firstName");
    		String lastName = request.getParameter("lastName");
    		String age = request.getParameter("age");

    
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
    	
    	PreparedStatement ps = con.prepareStatement("insert into user(userName, password, firstName, lastName, age) values(?,?,?,?,?)");
    	ps.setString(1, userName);
    	ps.setString(2, password);
    	ps.setString(3, firstName);
    	ps.setString(4, lastName);
    	ps.setString(5, age);
    	
    	int results = ps.executeUpdate();
    	
    	if(results == 1)
    	{
    		response.sendRedirect("success.html");
    	}
    	else
    	{
    		response.sendRedirect("error.html");
    	}
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
}     
}