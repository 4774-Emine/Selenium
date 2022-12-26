package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class Task02 extends BaseTest {
//  Go to URL: https://demoqa.com/browser-windows
//  Click on the windows - "WindowButton"
//  Click on all the child windows.
//  Print the text present on all the child windows in the console.
//  Print the heading of the parent window in the console.




        @Test
        public void windowHandle() {
            driver.get("https://demoqa.com/browser-windows");
            String homePage = driver.getWindowHandle();
            driver.findElement(By.id("tabButton")).click();
            driver.findElement(By.id("windowButton")).click();
            //  driver.findElement(By.id("messageWindowButton")).click();
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> i = windows.iterator();
            while(i.hasNext()){
                driver.switchTo().window(i.next());
                if(!driver.getWindowHandle().equals(homePage)){
                    String Text = driver.findElement(By.tagName("body")).getText();
                    System.out.println(Text);
                    driver.close();
                }
            }
            driver.switchTo().window(homePage);
            System.out.println(driver.getTitle());

        }
    }


