package Day4_LocatorPractice;

import com.github.javafaker.Faker;
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

public class Task01 {
    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Faker faker=new Faker();
    }

    @After
    public void kapat() {
        // driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://id.heroku.com/login");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='email']"));
        searchButton.sendKeys("haticehifa.@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12345");
        WebElement button = driver.findElement(By.xpath("//button[@name='commit']"));
        button.click();

        String message = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        if (message.equals("There was a problem with your login.")) {
            System.out.println("Kayıt Yapılamadı");

        } else {
            System.out.println("Kayıt yapıldı");
        }

    }
}
