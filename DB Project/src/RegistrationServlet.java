import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Driver;
 
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
//@SuppressWarnings("unused")
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    String dbURL ="jdbc:mysql://localhost:3306/database_project";
    String usernameDB = "john";
    String passwordDB = "pass1234";
    user user = new user();
    
    public void init() {
        userDAO = new userDAO(); 
    }
    
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    	String reg = request.getServletPath();
    	System.out.print(reg);
    	System.out.print("Registration Attempt");
    	attemptReg(request, response);

    }
        
   
	 private void attemptReg(HttpServletRequest request, HttpServletResponse response)
	 	throws ServletException, IOException
	 {
        	System.out.println("User obtained");
        	String user = null;
        	user = request.getParameter(user);
        	
        	if(request.getParameter("userName") == null)
        	{
        		String noUsername = "Enter a username";
        		request.setAttribute("No username", noUsername);
        	}
        	else if(request.getParameter("password") == null)
        	{
        		String noPass = "Enter password";
        		request.setAttribute("No password", noPass);
        	}
        	else if(request.getParameter("password-repeat") != request.getParameter("password"))
        	{
        		String wPass = "Not the same password";
        		request.setAttribute("Not the same password", wPass);
        	}
        	else if(request.getParameter("firstName") == null)
        	{
        		String fName = "Enter first name";
        		request.setAttribute("Enter first name", fName);
        	}
        	else if(request.getParameter("lastName") == null)
        	{
        		String lName = "Enter last name";
        		request.setAttribute("Enter last name", lName);
        	}
        	else if(request.getParameter("age") == null)
        	{
        		String age = "Enter age";
        		request.setAttribute("Enter age", age);
        	}
        	 else
 	        {
 	         	RequestDispatcher dispatcher = request.getRequestDispatcher("LoginRegistration.jsp");
 	        	dispatcher.forward(request,response);
 	        }
		
        	    		
    try
    {
     	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection(dbURL, usernameDB, passwordDB);
    	
    	PreparedStatement ps = con.prepareStatement("INSERT INTO user(userName, password,"
    			+ " firstName, lastName, age) VALUES(?,?,?,?,?)");
    	
     	String userName = null;
    	String password = null;
    	String firstName = null;
    	String lastName = null;
    	int age = 0;
    	
    	ps.setString(1, userName);
    	ps.setString(2, password);
    	ps.setString(3, firstName);
    	ps.setString(4, lastName);
    	ps.setInt(5, age);
    	
	    	int results = ps.executeUpdate();
	    	
	    	if(results == 1)
	    	{
	    		response.sendRedirect("success.html");
	    	}
	    	else
	    	{
	    		response.sendRedirect("error.html");
	    	}
    	
    } catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
    }
}
