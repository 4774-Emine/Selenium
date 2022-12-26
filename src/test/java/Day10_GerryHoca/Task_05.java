package Day10_GerryHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task_05 extends BaseTest {

    /*
    1- https://html.com/tags/iframe/ sayfasına gidelim.
    2- Video'yu görecek kadar aşağı inin.
    3- Videoyu izlemek için Play tuşuna basın.
    4- Videoyu çalıştırdığınızı test edin.
*/

    @Override
    public void tearDown() {

    }

    @Test
    public void test() {
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframe=driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iframe);

        WebElement video=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        actions.click(video).perform();//video.click de diyebiliriz

        Assert.assertFalse(video.isDisplayed());


    }
}
