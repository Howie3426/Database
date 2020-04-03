import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.util.Scanner;
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
//@SuppressWarnings("unused")
@WebServlet("/LoginServlet")
public class usermenu extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    String dbURL ="jdbc:mysql://localhost:3306/database_project";
    String username = "john";
    String password = "pass1234";
    Scanner input = new Scanner(System.in);
    
    
    public void init() 
    {
        userDAO = new userDAO(); 
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    	String login = request.getServletPath();
    	System.out.print(login);
    	System.out.print("Login Attempt");
    	attemptLogin(request, response);

    }
        
   
	 private void attemptLogin(HttpServletRequest request, HttpServletResponse response)
	 	throws ServletException, IOException
	 {
        	System.out.println("User obtained");
        	String user = null;
        	user = request.getParameter(username);
        	
        	String url;
        	String description;
        	String title;
      
			if(user == null)
        	{
        		String LoginFailed = "Not Logged in.";
	        	request.setAttribute("loginFailed", LoginFailed);
	        }
			else
			{
				System.out.print("Enter URL: ");
				url = input.next();
				System.out.print("Enter title: ");
				title = input.nextLine();
				System.out.print("Enter description: ");
				description = input.nextLine();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
				System.out.println(dtf.format(now));  
			}
        
   }
        
}