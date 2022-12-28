package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
 /*
 Go to URL: http://demo.guru99.com/test/web-table-element.php
To find third row of table
To get 3rd row's 3nd column data
Get all the values of a Dynamic Table
    */



    @Test
    public void webTableExample() {


        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //Tablomuzu locate ettik
        WebElement table = driver.findElement(By.className("dataTable"));

        /*Eger tabloda birden fazla satırı locate etmemiz gerekiyorsa bütün satırları findElements
        metoduyla alıp sonra istediğimiz indexi çekebiliyoruz*/

        //Biz tek tek locate edeceğiz.3.satır locate edildi
        WebElement row3 = table.findElement(By.xpath("(.//tr)[3]"));//. koyarsak belirttiğimiz elemetin altında arar.// ise tüm sayfada arar

        //System.out.println(row3.getText());

        //3.satır 3.sütun(hücre) locate edildi
        WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));//row 3 ü yukarda locate etmiştik burada .// diyerek rowun altındaki elemeti getirir

        // System.out.println(row3cell3.getText());


        //satır sayımızı bulduk
        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        System.out.println(satirSayisi);

        //Sütun sayısını bulduk
        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
        System.out.println(sutunSayisi);

        // For donguleri ile tum hucreleri geziyoruz
        for (int i = 1; i <= satirSayisi; i++) {
            //her bir satir


            for (int j = 1; j <= sutunSayisi; j++) {
                // her satirin sutunu
                By locator = By.xpath(".//tr[" + i + "]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);

                System.out.print(tableData.getText() + " ");
            }

            System.out.println();

        }
    }
}
