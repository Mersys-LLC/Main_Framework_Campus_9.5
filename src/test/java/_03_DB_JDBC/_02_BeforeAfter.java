package _03_DB_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _02_BeforeAfter {

  private static Connection connection;
  private static Statement statement;

  @BeforeTest
  public void  DBConnectionOpen(){

    String url= "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port,db name
    String username= "root";
    String password= "'\"-LhCB'.%k[4S]z";

    try {
      connection = DriverManager.getConnection(url,username,password);
      statement=connection.createStatement(); //sql page open like mysql to write query
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @AfterTest
  public void DBConnectionClose(){
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void test1() throws SQLException {
    ResultSet lr= statement.executeQuery("select* from language");

    lr.next();
    System.out.println(lr.getString("name"));
    System.out.println("******************");
    lr.next();
    System.out.println(lr.getString("name"));
    System.out.println("******************");
    lr.next();
    System.out.println(lr.getString("name"));

  }

  @Test
  public void test2() throws SQLException {

    ResultSet lr= statement.executeQuery("select* from language");

    lr.next();
    System.out.println(lr.getString(2));
    System.out.println("******************");
    lr.next();
    System.out.println(lr.getString(2));
    System.out.println("******************");
    lr.previous();
    System.out.println(lr.getString(2));


  }

}
