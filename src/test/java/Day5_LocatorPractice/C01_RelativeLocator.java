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
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {
    // Go to http://www.bestbuy.com
// Verify that the page title contains "Best" Also, using Relative Locator.
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed.

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
    public void relativeLocator() {
        // Go to http://www.bestbuy.com
        driver.get("http://www.bestbuy.com");
        Assert.assertTrue(driver.getTitle().contains("Best"));

        //Logo locate ediliyor
        By logolocator = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!']"));
        WebElement logo = driver.findElement(logolocator);
        Assert.assertTrue(logo.isDisplayed());

        //Mexicp link locate edilip kontrol ediliyor
        By mexico= RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[@lang='en']//a[@class='us-link']"));
        WebElement mexicoLink=driver.findElement(mexico);
        Assert.assertTrue(mexicoLink.isDisplayed());

    }


}
