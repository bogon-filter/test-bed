package org.personal.testbed;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateXLSXFile {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Testing Excel files");
        // TODO Auto-generated method stub
        Workbook wb = new XSSFWorkbook();
        FileOutputStream fos = new FileOutputStream("sample.xlsx");
        Sheet sh = wb.createSheet("new sheet 1");
        for (int k = 0; k < 70000; k++) {
            Row row = sh.createRow(k);
            for (int i = 0; i < 5; i++) {
                Cell cell = row.createCell((short) i);
                cell.setCellValue("hi world : )");
            }
        }
        wb.write(fos);
        fos.close();
    }

}
