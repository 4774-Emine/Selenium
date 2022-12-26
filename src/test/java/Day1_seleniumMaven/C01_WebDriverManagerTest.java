package Day1_seleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {

// Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.

    public static void main(String[] args) {


        //WebDriver Manager classını kullanarak Chromedriver binary lerimizi indirdik
        WebDriverManager.chromedriver().setup();


        //Driver objemizi oluşturduk
        WebDriver driver = new ChromeDriver();

        //windowu maximize ettik
        driver.manage().window().maximize();

        //google ana sayfamızı açtık
        driver.get("https://www.google.com/");


        //title mizi aldık
        String title = driver.getTitle();

        //titlemizi doğruladık
        if (title.equals("Google")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
         //driverimizi kapattık
        driver.quit();
    }
}