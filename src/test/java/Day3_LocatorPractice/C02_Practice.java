package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C02_Practice {
    //    Create the driver with BeforeClass and make it static inside the class.
    //   Go to http://www.google.com
    //   Type "Green Mile" in the search box and print the number of results.
    //   Type "Premonition" in the search box and print the number of results.
    //   Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    //   Close with AfterClass.

    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Before
    public void beforeEach() {
        driver.get("http://www.google.com");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public void test01() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Green Mile" + Keys.ENTER);

        WebElement results = driver.findElement(By.id("result-stats"));

        //Bulduğum elementi sout içine getText() methodunu çağırarak yazdırma işlemini yapıyorum
        System.out.println(results.getText());

    }

    //   Type "Premonition" in the search box and print the number of results.
    @Test
    public void test02() {
        WebElement search2 = driver.findElement(By.name("q"));
        search2.sendKeys("Premonition" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());
    }

    //   Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    @Test
    public void test03() {
        WebElement search3 = driver.findElement(By.name("q"));
        search3.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());

    }
}