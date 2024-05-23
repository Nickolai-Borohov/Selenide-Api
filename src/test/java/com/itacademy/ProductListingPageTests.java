package com.itacademy;
import com.codeborne.selenide.*;
import com.itacademy.TestNg.LoggerTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class ProductListingPageTests{
    private static final Logger LOGGER= LogManager.getLogger(LoggerTest.class);
        @Test
    public void firstTest(){
            Configuration.browserSize="1920x1080";
           // Configuration.browser="firefox";
            ProductListingPage productListingPage = new ProductListingPage();
            productListingPage.openURL();
            SelenideElement firstProductElement= $(By.xpath("//*[@class='sc-124al1g-2 dwOYCh'] //*[@class='sc-124al1g-4 eeXMBo']"));
            String firstProductName = firstProductElement.getText();
            LOGGER.info(firstProductName);
            productListingPage.addToCart();
            Configuration.timeout=10000;
            //Configuration.browser="firefox";
            productListingPage.produstIncartName();
            SelenideElement productInCartElement = productListingPage.produstIncartName();
            String productInCartName=productInCartElement.getText();
            if (firstProductName.equals(productInCartName))
            {
                LOGGER.info("Good");
            }
            else
                LOGGER.info("Something went wrong");
            //if (firstProductName.equals())

            //Configuration.timeout=10000;
        }

        @Test
    public void test2(){


            ProductListingPage productListingPage = new ProductListingPage();
            productListingPage.openURL();
            List<String> productsOnMainPage= $$(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']")).shouldHave(size(16)).texts();
            LOGGER.info(productsOnMainPage);
            productListingPage.filterM();
            Selenide.Wait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']")));
            List<String> productsWithMFilter= $$(By.xpath("//*[@class='sc-124al1g-4 eeXMBo']")).shouldHave(size(1)).texts();  ////*[@class='sc-124al1g-2 keuquD']
            LOGGER.info(productsWithMFilter);
            productListingPage.openURL();
            if (productsOnMainPage.size()>productsWithMFilter.size())
            {
                LOGGER.info("More products on the home page");
            }
            else
            {
                LOGGER.info("Something went wrong");
            }

        }

}
