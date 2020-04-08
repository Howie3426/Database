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


@WebServlet("/favComedianDAO")
public class favComedianDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public favComedianDAO() {

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
    
    public List<favComedian> listAllfavComedian() throws SQLException {
        List<favComedian> listfavComedian = new ArrayList<favComedian>();        
        String sql = "SELECT * FROM favoriteComedian";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
     
		while (resultSet.next()) {
            String favComedianF = resultSet.getString("favComedianF");
            String favComedianL = resultSet.getString("favComedianL");
            int favComedianID = resultSet.getInt("favComedianID");
             
            favComedian favComedian = new favComedian(favComedianF,favComedianL, favComedianID);
            listfavComedian.add(favComedian);
        }      
		
        resultSet.close();
        statement.close();         
        disconnect();        
        return listfavComedian;
    }
	
	 protected void disconnect() throws SQLException {
	        if (connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
    
    public favComedian getfavComedian(int ID) throws SQLException {
    	favComedian favComedian = null;
        String sql = "SELECT * FROM favComedian WHERE ID = ?";
         
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String favComedianF = resultSet.getString("favComedianF");
            String favComedianL = resultSet.getString("favComedianL");
            int favComedianID = resultSet.getInt("favComedianID");
             
            favComedian = new favComedian(favComedianF, favComedianL, favComedianID);
        }
         
        resultSet.close();
        statement.close();
         
        return favComedian;
    }

	public static void removefavComedian(String username, int comedianID)
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/Database Project";
	    String uname = "john";
	    String password = "pass1234";
		String sql = "delete from employee where emp_id=?";
	    try (Connection conn = DriverManager.getConnection(jdbcUrl, uname, password); 
	        PreparedStatement stmt = conn.prepareStatement(sql)) {
	      
	      stmt.setInt(1, 2);
	      stmt.executeUpdate();
	      
	      System.out.println("Record deleted successfully");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	

	public static void createFavorite(String username, int comedianID)
	{
				
	}




}