package Day12_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshots extends BaseTest {

    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

        //önce driverimizi TakesScreenshot a cast etmemiz gerekiyor
        //screenshotımızı file clasından bir objeye alıyoruz
        File kaynak = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Screenshot kopyalamanın 2. yöntemi
        //Aldığımız screen shotı istediğimiz bir yere kaydediyoruz
        FileHandler.copy(kaynak, new File("test-output\\Screenshots\\n11PageScreenShot.png"));


    }

    @Test
    public void getElementScreenshots() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com");

        //SCreenshotı alınacak elementi locate ettik
        WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));

        //Element üzerinden screenshotımızı aldık
        File logoScreenshot = logo.getScreenshotAs(OutputType.FILE);

        //SCreenshotımızın unic olması için tarih alıyoruz
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());//(bu kodu netten de bulabiliriz)

        String path = "test-output\\Screenshots\\logoScreenShot_" + date + ".png";

        //Dosyamızı kaydettik
        FileUtils.copyFile(logoScreenshot, new File(path));


    }

}
