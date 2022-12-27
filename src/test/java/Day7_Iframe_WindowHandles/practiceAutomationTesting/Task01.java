package Day7_Iframe_WindowHandles.practiceAutomationTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {


// 1) Open the browser
//2) Enter the URL “http://practice.automationtesting.in/”
// 3) Click on Shop Menu
//4) Now click on Home menu button
//5) Test whether the Home page has Three Sliders only
//6) The Home page must contains only three sliders


    WebDriver driver;

    @Before
    public void setup() {
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }
@Ignore
    @Test
    public void test() {
        driver.get("https://practice.automationtesting.in/");
        WebElement shop = driver.findElement(By.xpath("//li[@id='menu-item-40']"));
        shop.click();
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        //WebElement img1 = driver.findElement(By.xpath("//*[@alt='Shop Selenium Books']"));
        WebElement slider = driver.findElement(By.xpath("//*[@id='n2-ss-6-arrow-next']"));
        slider.click();
        Assert.assertTrue(slider.isDisplayed());
    }


}