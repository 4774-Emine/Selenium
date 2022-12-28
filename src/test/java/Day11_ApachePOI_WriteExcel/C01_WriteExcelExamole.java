package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExamole {
    @Test
    public void writeExcel() throws IOException {
/*
        Store the path of the file as string and open the file.
        Open the workbook.
        Open the first worksheet.
        Go to the first row.
        Create a cell on the 3rd column (2nd index) on the first row.
        Write “POPULATION” on that cell.
        Create a cell on the 2nd row 3rd cell(index2), and write data.
        Create a cell on the 3rd row 3rd cell(index2), and write data.
        Create a cell on the 4th row 3rd cell(index2), and write data.
        Write and save the workbook.
        Close the file.
        Close the workbook.
        */

        // Dosyamizin pathini belirttik
        String path = "src\\test\\java\\resources\\excelData.xlsx";


        // Dosyamizi aciyoruz
        FileInputStream fis = new FileInputStream(path);

        //Dosyamizi bir workbook haline getiriyoruz
        Workbook workbook = WorkbookFactory.create(fis);

        // Sheet imizi olusturduk
        Sheet sheet2 = workbook.getSheetAt(1);

        // Ilk satirimiza gittik
        Row row1 = sheet2.getRow(0);

        // Ilk satirimizin 3. hucresini olusturduk
        Cell row1cell3 = row1.createCell(2);

        // Hucremize deger atadik
        row1cell3.setCellValue("POPULATION");

        // Method chain ile data ekleme/degistirme metodu
        sheet2.getRow(1).createCell(2).setCellValue("Rusya nin populasyonu");
        sheet2.getRow(2).createCell(2).setCellValue("Cin in populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD nin populasyonu");

        //Excel dosyamiza yazma islemini yapiyoruz
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        // dosyalarimizi kapattik
        fis.close();
        fos.close();

        // workbook umuzu kapattik
        workbook.close();


    }


}