package Day9_JSEScroll_Cookies_Files;

import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7_FileExist {

    public static void main(String[] args) {

/*
Selenium ile windows uygulamalarını test edemiyoruz.
Ama test etmek için JAVA kullanabiliriz.
Bilgisayarımızda bir dosya olup olmadığını(exist) kontrol
etmek için Java'yı kullanabiliriz
​
System.getProperty ("user.dir"); İçinde bulunulan
klasörün yolunu (path) verir.
System.getProperty ("user.home"); Bilgisayarımızda
bulunan user klasörünü verir.
Files.exists (Paths.get (filePath)); Bilgisayarınızda
dosyanın olup olmadığını kontrol eder
upload=yüklemek
 */


        System.out.println(System.getProperty("user.dir")); // projemizin rootunun yolunu verir.


        String projectRoot = System.getProperty("user.dir"); // Bulmak istedigimiz file proje icerisinde oldugundan proje yolunu aldik

        String filePath = "\\src\\test\\java\\resources\\fileExist.jpg"; // Bulmak istedigimiz dosyanin proje klasorunden sonraki yolunu aldik (Copy path from content root)

        filePath = projectRoot + filePath; //Almis oldugumuz 2 yolu birlestirip absolute path imizi elde ettik


        System.out.println(Files.exists(Paths.get(filePath))); // Bu path de bir dosya olup olmadigini dogruladik


        if (Files.exists(Paths.get(filePath))) {
            System.out.println("Dosya bulundu"); // Varsa bulundu yazdirdik
        } else {
            System.out.println("Dosya bulunamadi"); // Yoksa bulunamadi yazdirdik
        }


    }
}