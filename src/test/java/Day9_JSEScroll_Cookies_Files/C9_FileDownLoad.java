package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C9_FileDownLoad extends BaseTest {
/*
    Go to URL: https://opensource-demo.orangehrmlive.com/
    Login page valid credentials.
    Download sample CSV file.
    Verify if the file downloaded successfully.*/

    @Test
    public void fileDownLoad() throws InterruptedException {


        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Sisteme giris yapiyoruz
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Indirilecek dosyaya gitmek icin gerekli adimlar
        WebElement PIM = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        PIM.click();

        WebElement configurationTab = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        configurationTab.click();

        WebElement dataImport = driver.findElement(By.linkText("Data Import"));
        dataImport.click();

        WebElement downloadLink = driver.findElement(By.className("download-link"));
        downloadLink.click();

        Thread.sleep(5000); // Ne olur ne olmaz dosyanin inmesi icin bekliyoruz

        // Indirilen dosyamizin path i
        String downloadPath = "C:\\Users\\user\\Downloads\\importData.csv";

        // Dosyanin indirildigini kontrol ediyoruz
        Assert.assertTrue("Indirilen dosya bulunamadi", Files.exists(Paths.get(downloadPath)));

    }


    @Test
    public void test() throws InterruptedException {


        // Go to https://the-internet.herokuapp.com/download
        driver.get(" https://the-internet.herokuapp.com/download");

        //  Download sample.png file
        WebElement sample = driver.findElement(By.linkText("sample-zip-file.zip"));
        sample.click();

        Thread.sleep(3000);

        //  Then verify if the file downloaded successfully
        String filePath = "C:\\Users\\EFE BİLGİSAYAR\\Downloads\\Untitled.txt";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
