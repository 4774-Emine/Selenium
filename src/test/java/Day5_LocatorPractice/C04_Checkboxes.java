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
import java.util.List;

public class C04_Checkboxes {


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

    @Test
    public void checkboxes() {

//    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.
//    Then click on checkbox 2 if box is not selected.
//    Then that checkbox 1 and checkbox 2 are checked.


        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //Checkbox lar locate edildi
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);

        // Checkbox 1 secili degilse tikliyoruz
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // Checkbox 2 secili degilse tikliyoruz
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }


        // Checkbox larin secili oldugunun kontrolu gerceklestirildi
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());


    }


}