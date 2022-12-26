package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_Actions extends BaseTest {

    /*
    Go to URL: https://demoqa.com/buttons
    Run the buttons on the page using the Actions Class.Actions Class'ı kullanarak sayfadaki düğmeleri çalıştırın.
    Verify the texts that appear after the buttons are operated.Düğmeler çalıştırıldıktan sonra
    görünen metinleri doğrulayın
     */


    @Override
    public void tearDown() {

    }

    @Test
    public void doubleClick(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.xpath("//div[@id='doubleClickBtn']"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickBtn).perform();


        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());


    }

    @Test
    public void rightClick(){

        driver.get("https://demoqa.com/buttons");

        //rightClickBtn
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);

        actions.contextClick(rightClickBtn).build().perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));

        Assert.assertTrue(rightClickMessage.isDisplayed());
    }

    @Test
    public void click(){

        driver.get("https://demoqa.com/buttons");

        WebElement clickBtn = driver.findElement(By.xpath("//div[last()]/button"));
        Actions actions = new Actions(driver);

        actions.click(clickBtn).build().perform();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());


    }


}


