import javax.servlet.annotation.WebServlet;
//import com.luv2code.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RootServlet")

public class RootServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
private Connection con = null;
private Statement statement = null;
private PreparedStatement preparedStatement = null;
private ResultSet resultSet = null;

   


public boolean initializeDb() throws SQLException{

Connection connect_sql = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/comedian_register=root&password=adrian123");
        System.out.println(connect_sql);
        System.out.println("IT WORKED!!");

String sql_del_1 = "DROP TABLE IF EXISTS user";

String sql_create1 = "CREATE TABLE `user` (" +
" username varchar(50) NOT NULL," +
 "password varchar(45) DEFAULT NULL," +
"first_name varchar(45) NOT NULL," +
 "last_name varchar(45) NOT NULL, " +
 "birthday date NOT NULL, " +
" PRIMARY KEY (`username`), " +
" UNIQUE KEY username_UNIQUE " ;



// drop the table then recreate them
try {
statement =  (Statement)connect_sql.createStatement();
statement.executeUpdate(sql_del_1);

statement.executeUpdate(sql_create1);

}
catch(Exception e) {
System.out.println("Initialize failed: " + e);
}

System.out.println("tables created.");

RootServlet test = new RootServlet();
// initialize user table

String sql_insert1 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password123', 'Scott', 'Lanz', 20);";
String sql_insert2 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1234', 'Scott', 'Lanz', 20);";
String sql_insert3 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1235', 'Scott', 'Lanz', 20);";
String sql_insert4 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1236', 'Scott', 'Lanz', 20);";
String sql_insert5 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1237', 'Scott', 'Lanz', 20);";
String sql_insert6 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1238', 'Scott', 'Lanz', 20);";
String sql_insert7 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1239', 'Scott', 'Lanz', 20);";
String sql_insert8 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('hello', 'password1231', 'Scott', 'Lanz', 20);";
String sql_insert9 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('trial', 'password1237','trial', 'Lun', 20);";
String sql_insert10 = "INSERT INTO user(userName, password,firstName, lastName, age) VALUES('scotty@hotmail.com', 'password1235', 'Scotty', 'Nick', 50);";

try {
statement =  (Statement)connect_sql.createStatement();
statement.executeUpdate(sql_insert1);
statement.executeUpdate(sql_insert2);
statement.executeUpdate(sql_insert3);
statement.executeUpdate(sql_insert4);
statement.executeUpdate(sql_insert5);
statement.executeUpdate(sql_insert6);
statement.executeUpdate(sql_insert7);
statement.executeUpdate(sql_insert8);
statement.executeUpdate(sql_insert9);
statement.executeUpdate(sql_insert10);

}
catch(Exception e) {
System.out.println("Initialize failed: " + e);
}


   
       return true;

 }


}