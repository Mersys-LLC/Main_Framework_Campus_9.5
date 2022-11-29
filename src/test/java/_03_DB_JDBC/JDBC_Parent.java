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

public class JDBC_Parent {
  private static Connection connection;
  protected static Statement statement;

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
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY); //sql page open like mysql to write query
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
}
