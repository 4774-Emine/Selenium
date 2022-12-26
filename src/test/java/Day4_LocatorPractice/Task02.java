package Day4_LocatorPractice;

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

public class Task02 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void kapa() {
        //driver.quit();

    }


    @Test
    public void Test() {
        //Navigate to https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");


        WebElement calculate = driver.findElement(By.xpath("//a[@href='calculator']"));
        calculate.click();


        WebElement number1 = driver.findElement(By.xpath("//input[@name='number1']"));
        number1.sendKeys("10");


        WebElement number2 = driver.findElement(By.xpath("//input[@name='number2']"));
        number2.sendKeys("50");


        WebElement calculator = driver.findElement(By.xpath("//input[@class='styled-click-button']"));
        calculator.click();


        WebElement result = driver.findElement(By.xpath("//p[text()='Answer : ']"));


        System.out.println(result.getText());


    }
}