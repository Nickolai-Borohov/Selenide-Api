package com.itacademy;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.itacademy.TestNg.LoggerTest;
import groovy.util.logging.Log4j2;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.fail;

@Log4j2
public class ProductListingPageTests{
    private static final Logger LOGGER= LogManager.getLogger(LoggerTest.class);
    @BeforeMethod
    public void setUP(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        SelenideLogger.addListener("localListener Test", new LocalListener()); // благодаря этому локально в консоли описывается все что происходит в тесте
    }
        @Test
    public void firstTest(){
            Configuration.browserSize="1920x1080";
           // Dselenide.browser=firefox;

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
            assert firstProductName.equals(productInCartName):"Something went wrong";
            LOGGER.info("");
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
            assert (productsOnMainPage.size()>productsWithMFilter.size()):"Something went wrong";
//            if (productsOnMainPage.size()>productsWithMFilter.size())
//            {
//                LOGGER.info("More products on the home page");
//            }
//            else
//            {
//                LOGGER.info("Something went wrong");
//            }

        }

        @Test
        public void qasTests(){
            open("https://qas.kuechedirekt-eshop.nobilia.aws-arvato.com/");
            $(By.xpath("//*[@title='Erstelle deine Küche']")).click();
            $(By.xpath("//*[@class='content']")).shouldHave(exactText("Erstellen Sie Ihre Küche"));
        }

}
