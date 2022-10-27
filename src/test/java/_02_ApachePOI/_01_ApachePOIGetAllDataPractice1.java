package _02_ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class _01_ApachePOIGetAllDataPractice1 {

  public static void main(String[] args) throws IOException {
    String path="src/test/java/_02_ApachePOI/Resources/ApacheExcel2.xlsx";
    FileInputStream inputStream=new FileInputStream(path);
    Workbook workbook= WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheet("Sheet1");

    // calisma sayfasındaki toplam satır sayısını veriyor.
    int rowCount=sheet.getPhysicalNumberOfRows();

    for (int i = 0; i < rowCount; i++) {
      Row row= sheet.getRow(i); // i.Satır alındı
      // bu satırdaki toplam hücre sayısı alındı.
      int cellCount = row.getPhysicalNumberOfCells();
      for (int j = 0; j < cellCount; j++) { // i.satırdaki hucre sayısı kadar dönecek
        Cell hucre = row.getCell(j);    // bu satırdaki sıradaki hücreyi aldım.
        System.out.print(hucre+" ");
      }
      System.out.println();
    }
  }
}
