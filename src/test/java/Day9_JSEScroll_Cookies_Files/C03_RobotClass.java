package Day9_JSEScroll_Cookies_Files;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class C03_RobotClass extends BaseTest {


    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        //driver.quit();
    }

    @Test
    public void test() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\EFE BİLGİSAYAR\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);//key press tuşa basılı tutar,ctrl ye bastık
        robot.keyPress(KeyEvent.VK_S);//s tuşuna bastık
        Thread.sleep(3000);

        robot.keyRelease(KeyEvent.VK_CONTROL);//keyRelease tusu serbet bırakır
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);//enter tusuna bastık
        robot.keyRelease(KeyEvent.VK_ENTER);//enter tusunu bıraktık

        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_LEFT);//sol ok
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }



  /* https://api.jquery.com/ sitesine gidelim
    arama alanina json yazalim
    Enter islemini robot class kullanrak yapalim*/

    @Test
    public void odevRobot() throws AWTException {
        driver.get("https://api.jquery.com/");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='ds-input']"));
        aramaKutusu.sendKeys("json");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }


}















