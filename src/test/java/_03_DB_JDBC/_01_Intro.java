package _03_DB_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class _01_Intro {

  @Test
  public void test1() throws SQLException {

    String url= "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port,db name
    String username= "root";
    String password= "'\"-LhCB'.%k[4S]z";

    Connection connection= DriverManager.getConnection(url,username,password); // make connection to database
    Statement statement=connection.createStatement(); //sql page open like mysql to write query
    ResultSet ra= statement.executeQuery("select* from actor");

    ra.next();

    String firstname= ra.getString("first_name");
    String lastname= ra.getString("last_name");

    System.out.println(firstname+" "+lastname);

    connection.close();


  }

}
