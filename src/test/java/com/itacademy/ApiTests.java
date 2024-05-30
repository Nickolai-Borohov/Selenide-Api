package com.itacademy;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @BeforeMethod
    public void setUP(){
        RestAssured.baseURI="https://reqres.in";

    }

    @Test
    public  void getTestIt() {
        given().log().all()
                .when().get("https://reqres.in/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void updateUserIt() {
       // given().log().all().contentType(ContentType.JSON).body()
        File file = new File("src/test/resources/json/jsonFileUpdate");
                Map<String,String> bodyInfo = new HashMap<>();
        bodyInfo.put("name", "new name");
        bodyInfo.put("name", "new name");
        given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/1")
                .then().log().body().statusCode(200);
    }

    @Test
    public void deleteUserIT(){
        given().log().uri()
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }


    @Test
    public  void getTestIt2() {
        Response response = given().log().all()
                .when().get("https://reqres.in/")
                .then().extract().response();
    }

    @Test
    public void validateXML() {
        Response response = given()
                .get("https://mocktarget.apigee.net/xml")
                .then().statusCode(200).log().all().contentType(ContentType.XML).extract().response();
        System.out.println(response.xmlPath().getString("root.city"));
        XmlPath xmlPath = new XmlPath(response.asString());
    }

    @Test
    public void testJsonSchemaIT() {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all()
                .when().get("/api/users/2")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json")); // тут валидируем что наш джейсон соответствует джейсон схеме

    }

//____________________________________________________#2

    String token ;
    @Test
    public void login (){
        Response response = given().contentType(ContentType.JSON).body("{\"username\":\"emilys\",\"password\":\"emilyspass\",  \"expiresInMins\": 30}")
                .when().post("https://dummyjson.com/auth/login")
                .then().log().body().statusCode(200).extract().response();
        token= response.jsonPath().getString("token");
        //expiresInMins": 30 - время которое ты можешь быть в сети, обычно такое разрабы делают/дают
    }


    @Test
    public void getUSer(){//dependsOnMethods={"login"}
        given().header("Authorization", "Bearer"+ token)
                .when().get("'https://dummyjson.com/auth/me")
                .then().statusCode(200);
    }
}
//есть несколько видов аутенцификации oauth, ouath2... но это нужно брать из документации
