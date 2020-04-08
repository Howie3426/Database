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


@WebServlet("/ReviewDAO")
public class ReviewDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public ReviewDAO() {

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
    
    public List<Review> listAllReview() throws SQLException {
        List<Review> listReview = new ArrayList<Review>();        
        String sql = "SELECT * FROM review";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
     
		while (resultSet.next()) {
            String url = resultSet.getString("url");
            String review = resultSet.getString("review");
            String description = resultSet.getString("description");
             
            Review Review = new Review(url,review, description);
            listReview.add(Review);
        }      
		
        resultSet.close();
        statement.close();         
        disconnect();        
        return listReview;
    }
	
	 protected void disconnect() throws SQLException {
	        if (connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
    
    public Review getReview(String url) throws SQLException {
    	Review Review = null;
        String sql = "SELECT * FROM review WHERE url = ?";
         
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, url);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String review = resultSet.getString("review");
            String description = resultSet.getString("description");
             
            Review = new Review(url, review, description);
        }
         
        resultSet.close();
        statement.close();
         
        return Review;
    }


    
}