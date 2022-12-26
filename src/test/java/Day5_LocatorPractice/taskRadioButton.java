package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class taskRadioButton {

//Go to URL: https://demoqa.com/radio-button
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.


    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {

        //  driver.quit();
    }

    @Test
    public void radioButton() {

        driver.get("https://demoqa.com/radio-button");


        WebElement yes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yes.click();
        Assert.assertTrue(!yes.isSelected());
        WebElement text = driver.findElement(By.className("mt-3"));
        System.out.println(text.getText());

        WebElement no = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        no.click();
        Assert.assertFalse(no.isSelected());
        WebElement text1 = driver.findElement(By.className("mt-3"));
        System.out.println(text.getText());

        WebElement impressive = driver.findElement(By.xpath("//label[@for='noRadio']"));
        impressive.click();
        Assert.assertFalse(!impressive.isSelected());
        WebElement text2 = driver.findElement(By.className("mt-3"));
        System.out.println(text.getText());

    }


}




