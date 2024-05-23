package com.itacademy;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductListingPage {

    public void openURL (){open("https://react-shopping-cart-67954.firebaseapp.com/");}
    public void addToCart() {$(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-0 jCsgpZ']")).shouldBe(visible).click();}

    public SelenideElement produstIncartName () {return $(By.xpath("//*[@class='sc-11uohgb-0 hDmOrM'] //*[@class='sc-11uohgb-2 elbkhN']"));}

    public void filterM (){$(By.xpath("//*[@class='sc-bj2vay-0 DCKcC'] //*[text()='M']")).click();}

//    public void getProducts(){
//        $$(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']"));
//        //return null;
//    }
}
