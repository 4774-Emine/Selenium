package Day10_GerryHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import javax.swing.*;

public class odev_Amazon extends BaseTest {
/*
    o https://www.amazon.com.tr/ sitesi açılır.
    o Ana sayfanın açıldığı kontrol edilir.
    o Çerez tercihlerinden Çerezleri kabul et seçilir.
    o Siteye login olunur.
    o Login işlemi kontrol edilir.
    o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    o Bilgisayar kategorisi seçildiği kontrol edilir.
    o Arama alanına MSI yazılır ve arama yapılır.
    o Arama yapıldığı kontrol edilir.
    o Arama sonuçları sayfasından 2. sayfa açılır.
    o 2. sayfanın açıldığı kontrol edilir.
    o Sayfadaki 2. ürün favorilere eklenir.
    o 2. Ürünün favorilere eklendiği kontrol edilir.
    o Hesabım > Favori Listem sayfasına gidilir.
    o “Favori Listem” sayfası açıldığı kontrol edilir.
    o Eklenen ürün favorilerden silinir.
    o Silme işleminin gerçekleştiği kontrol edilir.
    o Üye çıkış işlemi yapılır.
    o Çıkış işleminin yapıldığı kontrol edilir. */

    @Override
    public void tearDown() {

    }

    @Test
    public void test() {
        driver.get("https://www.amazon.com.tr/");


        //Ana sayfanın açıldığı kontrol edilir.
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr/");

        //  o Çerez tercihlerinden Çerezleri kabul et seçilir
        WebElement cerezKabul = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cerezKabul.click();


        //Siteye login olunur.
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(login);

        WebElement giris = driver.findElement(By.linkText("Giriş yap"));
        giris.click();


        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("haticehifa.2018@gmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        WebElement sifre = driver.findElement(By.id("ap_password"));
        sifre.sendKeys("Adnan46." + Keys.ENTER);


        // Login işlemi kontrol edilir.
        Assert.assertTrue(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains("Emine"));


        // Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement searchDropDownBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropDownBox);
        select.selectByVisibleText("Bilgisayarlar");

        //  Bilgisayar kategorisi seçildiği kontrol edilir.
        // Assert.assertEquals(select.getFirstSelectedOption().getText(),"Bilgisayarlar");

        //  o Arama alanına MSI yazılır ve arama yapılır.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("MSI" + Keys.ENTER);

        // o Arama yapıldığı kontrol edilir.

        Assert.assertTrue(driver.getTitle().contains("MSI"));

        // o Arama sonuçları sayfasından 2. sayfa açılır.
        WebElement ikincisayfa = driver.findElement(By.linkText("2"));
        ikincisayfa.click();

        // o 2. sayfanın açıldığı kontrol edilir.
        // Assert.assertTrue(ikincisayfa.isDisplayed());


        //  o Sayfadaki 2. ürün favorilere eklenir.

        WebElement tv = driver.findElement(By.xpath("//img[@class='s-image' and @data-image-index='26']"));
        tv.click();

        WebElement listeyeEkle = driver.findElement(By.xpath("//input[@value='Listeye Ekle']"));
        listeyeEkle.click();
        WebElement listeoluştur = driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));
        listeoluştur.click();

        // o 2. Ürünün favorilere eklendiği kontrol edilir.


    }
}
