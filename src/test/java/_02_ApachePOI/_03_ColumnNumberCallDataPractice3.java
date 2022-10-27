package _02_ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;

public class _03_ColumnNumberCallDataPractice3 {
  /**
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
  public static void main(String[] args) {
    System.out.print("Enter Column you need : " );
    Scanner scanner= new Scanner(System.in);
    int inputColumn= scanner.nextInt();

    String dataFindResult=findData(inputColumn);
    System.out.println("Result : " + dataFindResult);
  }

  public static String findData(int inputColumn)
  {
    String data="";

    String path="src/test/java/_02_ApachePOI/Resources/LoginData.xlsx";

    Workbook workbook=null;
    try {
      FileInputStream inputStream = new FileInputStream(path);
      workbook= WorkbookFactory.create(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Sheet sheet= workbook.getSheetAt(0);

    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
      if (sheet.getRow(i).getPhysicalNumberOfCells() > inputColumn)
        data+=sheet.getRow(i).getCell(inputColumn)+"\n";

    return data;
  }
}
