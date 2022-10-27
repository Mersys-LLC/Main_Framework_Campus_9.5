package _03_DB_JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class _06_GetRowAllColumn extends JDBC_Parent{

  @Test
  public void test1() throws SQLException {

    ResultSet rl = statement.executeQuery("select* from language");

    ResultSetMetaData rsmd=rl.getMetaData(); //meta info like column,type,name etc.

    System.out.println(rsmd.getColumnCount());

    for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
      String columnName=rsmd.getColumnName(i);
      String columnType=rsmd.getColumnTypeName(i);
      System.out.println(columnName+" "+columnType);

    }

  }

  @Test
  public void test2() throws SQLException { // we want to print exactly same look like Mysql excel

    ResultSet rl = statement.executeQuery("select* from language");

    ResultSetMetaData rsmd=rl.getMetaData(); //meta info like column,type,name etc.

    for (int i = 1; i <= rsmd.getColumnCount() ; i++)
      System.out.printf("%-15s",rsmd.getColumnName(i)); //printf means make this format (-) make it on the left corner
      System.out.println();

      while (rl.next()){
      for (int i = 1; i <= rsmd.getColumnCount(); i++)
        System.out.printf("%-15s",rl.getString(i)); //"%20d" when you want integer
        System.out.println();

    }
  }

  @Test
  public void test3() throws SQLException {
    // print all column form actor table and use a method for this

    getActorTable("select * from actor");
  }
    public void getActorTable(String sqlQuery) throws SQLException {
      ResultSet rl = statement.executeQuery(sqlQuery);

      ResultSetMetaData rsmd=rl.getMetaData(); //meta info like column,type,name etc.

      for (int i = 1; i <= rsmd.getColumnCount() ; i++)
        System.out.printf("%-15s",rsmd.getColumnName(i)); //printf means make this format (-) make it on the left corner
      System.out.println();

      int count=0;
      while (rl.next()){
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
          System.out.printf("%-15s",rl.getString(i)); //"%20d" when you want integer
        System.out.println();
        count++;

      }
      System.out.println("total: "+ count);
  }
}
