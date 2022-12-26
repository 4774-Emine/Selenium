package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {
    //vatan bilgisayar a git 6H6Q6EA model no fiyatını yazdır
    // Macbook Pro MK1H3TU/A M1 modelin satış fiyatını yazdırın
//Asus Zenbook Pro Duo Oled satış fiyatını yazdırın
    //Msi Ge77 Raider 12.Nesil Core i9 satış fiyatını yazdırın


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void hp() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.findElement(By.id("navbar-search-input")).sendKeys("6H6Q6EA" + Keys.ENTER);
        System.out.println("fiyatı : " + driver.findElement(By.xpath("//*[@class='product-list__price']")).getText());

    }

    @Test

    public void mac() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.findElement(By.xpath("//*[@class='search__input']")).sendKeys("Macbook Pro MK1H3TU/A M1" + Keys.ENTER);
        ////*[@class='product-list__price']
        System.out.println("Fiyatı= " + driver.findElement(By.xpath("//*[@class='product-list__price']")).getText());
    }

}


















