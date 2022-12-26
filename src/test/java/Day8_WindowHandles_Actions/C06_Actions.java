package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C06_Actions extends BaseTest {
    @Test
    public void keyboardActions() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement input = driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"));
        //You are Exceptional

        Actions actions=new Actions(driver);
        actions.click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("ou are ")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .perform();
    }
}
