import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/insert")
public class insert extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    String dbURL ="jdbc:mysql://localhost:3306/database_project";
    String username = "john";
    String password = "pass1234";
    
    
    public void init() {
        userDAO = new userDAO(); 
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    	String insert = request.getServletPath();
    	System.out.print(insert);
    	System.out.print("Attemt to upload");
    	attemptUpload(request, response);
    }
          
   	 private void attemptUpload(HttpServletRequest request, HttpServletResponse response)
	 	throws ServletException, IOException
	 {
   		 
	 }
}