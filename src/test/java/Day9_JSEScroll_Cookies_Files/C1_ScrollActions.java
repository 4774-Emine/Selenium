package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C1_ScrollActions extends BaseTest {
    @Test
    public void scrollPageUpDown() throws InterruptedException {
        //sayfa boyunca aşağı yukarı yapıyor
        driver.get("https://amazon.com");
        Actions act=new Actions(driver);
        Thread.sleep(2000);//her halukarda bekler,implicitliy gibi devam etmez

        act.sendKeys(Keys.PAGE_DOWN).perform();//sayfada aşağı gider
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_UP).perform();//sayfada yukarı çıkar
        Thread.sleep(2000);
        act.sendKeys(Keys.PAGE_UP).perform();

    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        //Klavyedeki aşağı yukarı oklarını kullanıyoruz sadece bir tık hareket ediyor
        driver.get("https://amazon.com");
        Actions act=new Actions(driver);
        Thread.sleep(2000);//her halukarda bekler,implicitliy gibi devam etmez

        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);
        act.sendKeys(Keys.ARROW_UP);
        Thread.sleep(2000);








    }
}
