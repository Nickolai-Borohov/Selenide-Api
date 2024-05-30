package com.itacademy;
import com.codeborne.selenide.*;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.crypto.Data;
import java.util.Date;


public class BaseTest {
//    @BeforeTest
//    Configuration.remote="http://192.168.0.102:4444";

//    public void littleSettings (){
//        @BeforeTest
//        Configuration.remote="http://192.168.0.102:4444";
//        Configuration.browserSize="1920x1080";
//
//    }

//    @BeforeTest
//    public void littleSettings (){
//        RestAssured.remote="http://192.168.0.102:4444";
//        RestAssured.browserSize="1920x1080";
//    }
    @BeforeMethod
    public void before(){
        Configuration.remote="http://192.168.0.102:4444";
        //SelenideDriver selenideDriver = new SelenideDriver();

    }

    @Test
    public void faker () {
        Faker faker = new Faker();
        System.out.println(faker.name());
        System.out.println(faker.animal().name());
    }
    @Test
    public void fakeData () {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd YYYY");
        System.out.println(simpleDateFormat.format(date));
        date.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK,2);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-YYYY");
        System.out.println(simpleDateFormat1.format(calendar.getTime()));
    }


    @Test
    public void mytest(){
//        User user = new User(); // нужно было создать класс Юзер
//        user.setName("pojo");
//        user.setJob("pojo");
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
//        System.out.println(json);
//
//
//        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/pojo.json"), user);
//        User user2 = objectMapper.readValue(json, User.class);
//        System.out.println(user2.getName());
    }
}
