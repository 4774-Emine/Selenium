package practiceAutomationTesting;

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

public class FormDoldur {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void kapat() {
        //  driver.close();

    }

    @Test
    public void formDoldur() {
        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common/home");

//ik locatorı text() metodu ile x path yaparak aldım
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        //buaradaki locator yukardaki gibi alındı
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Css ile locate aldık
        String firstName = "Emine";
        WebElement first = driver.findElement(By.cssSelector("#input-firstname"));
        first.sendKeys(firstName);

        //Css ile aldık
        String soyad = "Dişçeken";
        WebElement lastname = driver.findElement(By.cssSelector("[placeholder='Last Name']"));
        lastname.sendKeys(soyad);

        //By.name ile aldık
        String mail = "edisceken12345@gmail.com";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(mail);

        //xpath kullandık fakat class birden fazla olduğu için 'and kullanarak id yi de ekledik.'
        String telefon = "012485233";
        WebElement telNo = driver.findElement(By.xpath("//input[@class='form-control' and @id='input-telephone']"));
        telNo.sendKeys(telefon);

        //css kullanarak #id yi aldık
        String pass = "emine12";
        WebElement passs = driver.findElement(By.cssSelector("#input-password"));
        passs.sendKeys(pass);

        //By.name

        WebElement confirmm = driver.findElement(By.name("confirm"));
        confirmm.sendKeys(pass);

        //By.name
        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();

        //css ile içiçe iki classtan input içinde olanı aldık
        WebElement button = driver.findElement(By.cssSelector("input.btn-primary"));
        button.click();
        String beklenenmesaj = "Your Account Has Been Created!";
        Assert.assertEquals(beklenenmesaj, driver.getTitle());
        System.out.println("Kaydınız başarıyla oluşturuldu");
    }
}
