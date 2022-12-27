package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {

 /*   Go to URL: https://the-internet.herokuapp.com/upload
      Find the path of the file that you want to upload.
      Click on Upload button.
      Verify the upload message.*/

    @Test
    public void fileUpload() {


        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\user\\Desktop\\fileExist.png");

        // Upload butonuna basiyoruz
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();


   /* List <WebElement> uploadedMessage = driver.findElements(By.tagName("h8"));
    Assert.assertFalse("Element Bulunamadı",uploadedMessage.isEmpty());
    */


        // Upload edilme mesajinin goruntulendigini dogruluyoruz
        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("File Uploaded!", uploadedMessage.getText());

    }


    @Test
    public void test() {
        // Go to URL: https://www.monsterindia.com/seeker/registration
        driver.get("https://www.monsterindia.com/seeker/registration");


        // Upload file.
        WebElement file = driver.findElement(By.id("file-upload"));

        String filePath = "C:\\Users\\EFE BİLGİSAYAR\\Desktop\\robot.txt";

        file.sendKeys("C:\\Users\\EFE BİLGİSAYAR\\Desktop\\robot.txt");

        WebElement fileName = driver.findElement(By.id("registrationDetails"));
        Assert.assertEquals("robot.txt", fileName.getText());

    }
}





