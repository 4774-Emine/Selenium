package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {


    // https://testproject.io/

    // https://blog.testproject.io/


    @Override
    public void tearDown() {

    }

    @Test
    public void newWindow() {

        // Ana sekmemizde url i ziyaret ediyoruz.
        driver.get("https://testproject.io/");

        // Yeni pencere olusturup o pencereye switch ediyoruz.
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Yeni penceremizde url imizi ziyaret ediyoruz
        driver.get("https://blog.testproject.io/");
    }

    @Test
    public void newTab() {

        // Ana sekmemizden testproject acildi
        driver.get("https://testproject.io/");

        // Yeni bir sekme olusturuldu
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

        // Yeni sekmeden amazona gidildi
        newTab.get("https://www.amazon.com/");

        //Aktif tab in title i yazdirildi -> Aktif tab imiz = yeni olusturulan tab
        System.out.println(driver.getTitle());

    }

    @Test
    public void handleWindows() {

        // Ana sekmemizde amazon aciliyor
        driver.get("https://www.amazon.com/");

        //String homePageHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        //Yeni sekmemizde amazon tr yi actik
        driver.get("https://www.amazon.com.tr/");

        //Yeni pencere olusturduk.
        driver.switchTo().newWindow(WindowType.WINDOW);

        //Yeni pencerede Google i actik
        driver.get("https://www.google.com/");


        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();

        while (i.hasNext()) {
            String currentTab = i.next();
            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());


            /* 1. yol
            if (!driver.getWindowHandle().equals(homePageHandle)){
                driver.close();
             }

             */

            /*
             2. yol


            if (!driver.getTitle().contains("Spend")){
                driver.close();
            }
            */

        }

    }

    @Test
    public void deneme() {
        driver.get("https:www.hepsiburada.com");
        String homepageId = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:www.trendyol.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:google.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https:www.ciceksepeti.com");
        String cicekId = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
        while (i.hasNext()) {
            String suandakiSayfa = i.next();
            driver.switchTo().window(suandakiSayfa);
            System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
            if (!driver.getWindowHandle().equalsIgnoreCase(cicekId)) {
                driver.close();

            }

        }
    }
}