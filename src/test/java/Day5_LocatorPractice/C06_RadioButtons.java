package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtons {


//    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Click 'Kadin'
//    Click 'Erkek'
//      Validate 'Kadin' is not selected and 'Erkek' is selected.
WebDriver driver;

@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
@After
    public void kapa(){
    driver.quit();
}

@Test
    public void test(){
    driver.get("https://www.facebook.com/");

}
}
