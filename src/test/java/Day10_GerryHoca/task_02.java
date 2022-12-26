package Day10_GerryHoca;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class task_02 extends BaseTest {
    @Override
    public void tearDown() {

    }
 /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir method oluşturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
    ● Bir method oluşturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" içermediğini test edin.
    ● Bir method oluşturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.
 */

    @Test
    public void acceptAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();

        driver.switchTo().alert().accept();//alert i onaylamak istersek accept kullanıyoruz

        WebElement result = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        Assert.assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm.click();

        driver.switchTo().alert().dismiss();//alerti iptal etmek istersek dismiss kullanıyoruz

        WebElement result = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));

        Assert.assertFalse("Sonuç text successfuly içermiyor", result.getText().contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement prompt=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        prompt.click();

        driver.switchTo().alert().sendKeys("Emine");
        driver.switchTo().alert().accept();

        WebElement result=driver.findElement(By.xpath("//p[text()='You entered: Emine']"));

        Assert.assertTrue(result.getText().contains("Emine"));

    }
}