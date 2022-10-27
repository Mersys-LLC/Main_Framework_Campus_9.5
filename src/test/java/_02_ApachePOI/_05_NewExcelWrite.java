package _02_ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class _05_NewExcelWrite {

  public static void main(String[] args) throws IOException {
    // hafızada  yeni workbook oluştur, sonra sheet oluştur, sonra row oluştur, sonra cell oluştur.
    XSSFWorkbook workbook=new XSSFWorkbook();
    XSSFSheet sheet=workbook.createSheet("Sheet1");

    // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
    Row row= sheet.createRow(0); // satır oluşturuldu 0.yerde
    Cell cell= row.createCell(0); // yeni satırda ilk hucre oluşturuldu
    cell.setCellValue("Hi World"); // bilgi yazıldı.

    for (int i = 1; i < 10 ; i++) {
      row.createCell(i).setCellValue(i);
    }
    // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
    String newExcelPath="src/test/java/_02_ApachePOI/Resources/NewExcel.xlsx";
    FileOutputStream outputStream=new FileOutputStream(newExcelPath);
    workbook.write(outputStream);
    workbook.close();  // hafıza boşaltıldı
    outputStream.close();
    System.out.println("Process completed");
  }
 }

