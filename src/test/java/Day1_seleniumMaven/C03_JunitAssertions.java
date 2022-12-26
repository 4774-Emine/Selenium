package Day1_seleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {

    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        //driver.quit();

    }

    @Test
    public void assertionTest() {
        driver.get("https://www.amazon.com/");
        String currentUrl = driver.getCurrentUrl();
        //Url amazon kelimesini içeriyor mu kontol sağlanıyor
        Assert.assertTrue(currentUrl.contains("amazon"));//burada false olması durumunda neden belirten  mesaj da yazılabiliyor
    }

    @Test
    public void titleTest() {
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook"));
    }

    //sol üst köşede Amazon logosu görünüyor mu testi
@Test
public void logoVarMı(){
        driver.get("https://www.amazon.com/");

    WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
    logo.isDisplayed();
    System.out.println("Amazon logosu sol üst köşede görünüyor testi PASSED");
}

}
