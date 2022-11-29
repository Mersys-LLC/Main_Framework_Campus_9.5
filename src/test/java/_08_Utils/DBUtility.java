package _08_Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

  private static Connection connection;
  protected static Statement statement;

  protected static void DBConnectionOpen() { // we change this static coz we will call this method in static

    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/LoginData.xlsx",
            "LoginDB", 3);
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

  private static void DBConnectionClose() { // must be static and it's ok when its private coz its used only inside this class
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static List<List<String>> getListData(String sqlQuery) {
    List<List<String>> table = new ArrayList<>();
    //db den bütün satırları ve sütunları okuyup bu liste atıcam

    // db bağlantıyı aç
    DBConnectionOpen();
    try {
      //1- sorguyu çalıştır
      ResultSet rs = statement.executeQuery(sqlQuery);
      //2- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
      int columnCount = rs.getMetaData().getColumnCount();

      while (rs.next()) {
        List<String> row = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
          row.add(rs.getString(i));
        }

        table.add(row);
      }
    } catch (Exception ex) {
      System.out.println("ex.getMessage() = " + ex.getMessage());
    }

    DBConnectionClose();
    //db bağlantısı kapat
    return table;
  }
  public static void main(String[] args) { // this is for testing can we get the list or not

    List<List<String>> table = getListData("select * from nation");

    for (List<String> row : table) // tes için kontrol , veriler geldi mi, liste atıldı mı
      System.out.println("row = " + row);
  }
}