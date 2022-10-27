package _03_DB_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class JDBC_Parent {
  private static Connection connection;
  protected static Statement statement;

  @BeforeTest
  public void  DBConnectionOpen(){

    String url= "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port,db name
    String username= "root";
    String password= "'\"-LhCB'.%k[4S]z";

    try {
      connection = DriverManager.getConnection(url,username,password);
      statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //sql page open like mysql to write query
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
}
