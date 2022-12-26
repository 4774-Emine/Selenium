package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    //Faker değerler üretmek için Faker Class'ından bir obj üretilir ve varolan metotları kullanırız

  @Test
  public void fakerExample(){
      //Faker obj sini oluşturuyoruz
      Faker faker=new Faker();


      System.out.println("faker.name().firstName() = " + faker.name().firstName());
      System.out.println("faker.name().lastName() = " + faker.name().lastName());
      System.out.println(faker.address().fullAddress());
     //her defasında farklı isim ve adresler veriyor:)



  }


}
