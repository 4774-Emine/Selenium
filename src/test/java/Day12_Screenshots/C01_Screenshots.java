package Day12_Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class C01_Screenshots {//fullpageScreenshotta firefox kunnacağımız için chromla çalışan BaseTest clasını extend etmedik

    @Test
    public void fullPageScreenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();


        driver.get("https://www.amazon.com.tr/");


        //fullpage screenshot alacağımız için driverimizi firefox drivera cast ediyoruz
        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);//return type file olacak
        //screenshot ımızı aldık source değişkenine atadık

        //source daki screenshotı dosyaya kopyalamamız gerekiyor.Bunun 2 farklı yöntemi var
        //1.Yöntem
        FileUtils.copyFile(source, new File("test-output\\Screenshots\\amazonFullScreenshot.png"));
        //Burada screen shotı nereye kopyalayacağını belirtiyoruz
        //test-output->Screenshots->screenshot.png(Pathimiz bu şekilde olsun)


    }
}
