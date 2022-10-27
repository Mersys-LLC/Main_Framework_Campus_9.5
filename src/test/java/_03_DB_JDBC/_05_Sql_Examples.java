package _03_DB_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class _05_Sql_Examples extends JDBC_Parent{

  @Test
  public void test1() throws SQLException {
    ResultSet rc = statement.executeQuery("select city_id,city,country_id from city");
    rc.last();
    System.out.println(rc.getString(1)); // city_id will return
    System.out.println(rc.getInt(1)); // city_id will return
    System.out.println(rc.getInt(2)); // city can not return coz of type needs to be String

  }





}
