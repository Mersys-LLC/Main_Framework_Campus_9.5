package _02_ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;

public class _02_GetASpecificDataPractice2 {

  /**
   * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
   * yani metoda "password" kelimesi gönderilecek, dönen değer password un kendisi olacak.
   * src/test/java/ApachePOI/resources/LoginData.xlsx
   */

  public static void main(String[] args) {
    System.out.print("Enter the data title: ");
    Scanner scanner= new Scanner(System.in);
    String input= scanner.next();

    String dataFindResult=findData(input);
    System.out.println("Result : " + dataFindResult);
  }
  public static String findData(String input){
    String data="";
    String path="src/test/java/_02_ApachePOI/Resources/LoginData.xlsx";
    Workbook workbook;
    try {
      FileInputStream inputStream = new FileInputStream(path);
      workbook= WorkbookFactory.create(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Sheet sheet= workbook.getSheetAt(0); // .getSheet("Login"); get Sheet1
    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
      Row row=sheet.getRow(i);
      Cell cell=row.getCell(0);

      if (cell.toString().equalsIgnoreCase(input))
        for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
          data +=  row.getCell(j)+" ";
    }
    return data;
  }
}
