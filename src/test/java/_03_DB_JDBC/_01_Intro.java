package _03_DB_JDBC;

import _08_Utils.ExcelUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.testng.annotations.Test;

public class _01_Intro {

  @Test
  public void test1() throws SQLException {

    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/LoginData.xlsx",
            "LoginDB2", 3);
    for (ArrayList<String> row : data) {

      String url = row.get(2); // hostname,port,db name
      String username = row.get(0);
      String password = row.get(1);

      Connection connection = DriverManager.getConnection(url, username,
          password); // make connection to database
      Statement statement = connection.createStatement(); //sql page open like mysql to write query
      ResultSet ra = statement.executeQuery("select* from actor");

      ra.next();

      String firstname = ra.getString("first_name");
      String lastname = ra.getString("last_name");

      System.out.println(firstname + " " + lastname);

      connection.close();


    }
  }

}
