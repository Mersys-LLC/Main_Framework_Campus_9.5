package _03_DB_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class _04_AllDataPrint extends JDBC_Parent {

  @Test
  public void test1() throws SQLException {
    ResultSet rc= statement.executeQuery("select* from city");

    int count=0;
    while(rc.next()){
      System.out.print(" "+rc.getString(1)+" ");
      System.out.print(rc.getString(2)+" ");
      System.out.println(rc.getString(3));
      count++;
    }
    System.out.println("total: "+count);
  }

  @Test
  public void test2() throws SQLException {
    ResultSet rc= statement.executeQuery("select* from city");

    int count=1;
    while(rc.absolute(count)){ // it goes always from the next one like step by step
      System.out.print(" "+rc.getString(1)+" ");
      System.out.print(rc.getString(2)+" ");
      System.out.println(rc.getString(3));
      count++;
    }
    System.out.println("total: "+(count-1)); // coz it starts from 1
  }
  @Test
  public void test3() throws SQLException {
    ResultSet rc= statement.executeQuery("select* from city");

    int count=0;
    while(rc.relative(1)){ // it continues from the last one
      System.out.print(" "+rc.getString(1)+" ");
      System.out.print(rc.getString(2)+" ");
      System.out.println(rc.getString(3));
      count++;
    }
    System.out.println("total: "+count);
  }
}
