package _03_DB_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class _03_AbsoluteRelative extends JDBC_Parent{

  @Test
  private void test1() throws SQLException { // CAN NOT be public coz private and CAN NOT be private in JDBC_Parents coz need to be protected

    ResultSet rf= statement.executeQuery("select* from film");

    rf.absolute(10); // go to 10th row
    System.out.println(rf.getString("title"));
    System.out.println("******************");

    rf.absolute(15); // go to 5th row from last
    System.out.println(rf.getString("title"));
    System.out.println("******************");

    rf.absolute(-15); // go to 5th row from last
    System.out.println(rf.getString("title"));
    System.out.println("******************");

    rf.relative(5); // go to 5th row from last place(en son bulundugun yerden 5 satir ileri)
    System.out.println(rf.getString("title"));
    System.out.println("******************");

    rf.relative(-5); // go to 5th row from last place(en son bulundugun yerden 5 satir ileri)
    System.out.println(rf.getString("title"));


  }

}
