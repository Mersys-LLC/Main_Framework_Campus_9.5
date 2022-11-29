package _03_DB_JDBC;

import _08_Utils.ExcelUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _02_BeforeAfter {

  private static Connection connection;
  private static Statement statement;

  @BeforeTest
  public void  DBConnectionOpen(){
    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/LoginData.xlsx",
            "LoginDB2", 3);
    for (ArrayList<String> row : data) {

      String url = row.get(2); // hostname,port,db name
      String username = row.get(0);
      String password = row.get(1);
    try {
      connection = DriverManager.getConnection(url,username,password);
      statement=connection.createStatement(); //sql page open like mysql to write query
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
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
    System.out.println("******************");

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
