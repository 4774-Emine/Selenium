package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Checkboxes {
//    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.

    WebDriver driver;

    @Before
    public void setup() {
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }

    @Test
    public void test() {

        // Go to URL: https://demoqa.com/

        driver.get("https://demoqa.com/");

        // Click on Elements.

        WebElement elementsButton = driver.findElement(By.xpath("//div[@class='card-up']"));
        elementsButton.click();

        //Click on Checkbox.

        WebElement CheckBox = driver.findElement(By.xpath("//span[.='Check Box']"));
        CheckBox.click();

        //Verify if Home checkbox is selected.

        WebElement checkBoxClick = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));

        if (!checkBoxClick.isSelected()) {
            checkBoxClick.click();
        }

        Assert.assertTrue(checkBoxClick.isDisplayed());

        // Verify that "You have selected" is visible.

        WebElement selected = driver.findElement(By.xpath(" //span[text()='You have selected :']"));

        Assert.assertTrue(selected.isDisplayed());

    }
}