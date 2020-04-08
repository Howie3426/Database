
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/comedianDAO")
public class comedianDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public comedianDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/Database Project?"
  			          + "user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public List<comedian> listcomedian() throws SQLException {
        List<comedian> listcomedian = new ArrayList<comedian>();        
        String sql = "SELECT * FROM comedian";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
     
		while (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int date = resultSet.getInt("date");
            int id = resultSet.getInt("id");
             
            comedian comedian = new comedian(firstName,lastName, date, id);
            listcomedian.add(comedian);
        }      
		
        resultSet.close();
        statement.close();         
        disconnect();        
        return listcomedian;
    }
	
	 protected void disconnect() throws SQLException {
	        if (connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
    
    public comedian getcomedian(int ID) throws SQLException {
    	comedian comedian = null;
        String sql = "SELECT * FROM comedian WHERE ID = ?";
         
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int date = resultSet.getInt("date");
            int id = resultSet.getInt("id");
             
            comedian = new comedian(firstName, lastName, date, id);
        }
         
        resultSet.close();
        statement.close();
         
        return comedian;
    }
    
}