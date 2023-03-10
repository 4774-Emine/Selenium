package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev02 {
//   - https://demoqa.com/select-menu sitesine gidin
//   - Multiple select yapabileceginiz <select> elementini locate edin
// Birden fazla secim yapip secimlerinizi DOGRULAyin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void kapa() {
        driver.quit();
    }
//   - https://demoqa.com/select-menu sitesine gidin
//   - Multiple select yapabileceginiz <select> elementini locate edin
// Birden fazla secim yapip secimlerinizi DOGRULAyin

    @Test
    public void test() {
        driver.get("https://demoqa.com/select-menu");

        WebElement selectButton = driver.findElement(By.xpath("//*[@id='cars']"));
        Select option = new Select(selectButton);
        System.out.println(option.isMultiple());
        option.selectByVisibleText("Volvo");
        option.selectByIndex(1);
        option.selectByVisibleText("Opel");
        option.selectByIndex(3);
        Assert.assertTrue(!selectButton.isSelected());

    }

    }
