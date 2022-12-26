package Day4_LocatorPractice;

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

public class C01_Practice {
    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.

    WebDriver driver;

    @Before
    public void setup() {
        //Driver ile ilgili her türlü initial(baslangıç işlemi) burada yapılır
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //test sonrasında driver kapatmak ve raporlama dosyaları için kullanılır
        //driver.quit();
    }

    @Test
    public void test() {
        driver.get(" https://testpages.herokuapp.com/styled/index.html");
        WebElement alertsLink = driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();

        //şimdiki url yazdırıldı
        String alertsUrl = driver.getCurrentUrl();
        System.out.println("alertsUrl = " + alertsUrl);

        //1 sayfa geri gelindi
        driver.navigate().back();

        String homeUrl = driver.getCurrentUrl();
        System.out.println(homeUrl);

        WebElement basicAjaxLink = driver.findElement(By.id("basicajax"));
        basicAjaxLink.click();
        String basicUrl = driver.getCurrentUrl();
        System.out.println(basicUrl);


        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);

        //Submitted values  görüntüleniyor mu ona bakacağız
        WebElement submittedValuesText=driver.findElement(By.xpath("//p[.='Submitted Values']"));
        Assert.assertTrue(submittedValuesText.isDisplayed());


    }

}
