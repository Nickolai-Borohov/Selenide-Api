package com.itacademy;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MyApiTests {

    @Test
    public void myGetTestSecond(){
        given().log().all().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts")
                .then().log().all().statusCode(200);
    }

    @Test
    public void myPostTestSecond(){
        File filePut = new File("src/test/resources/json/TestFile");
        given().log().all().contentType(ContentType.JSON)
                .body(filePut)
                .when().post("https://jsonplaceholder.typicode.com/posts").then().log().body().statusCode(201);

    }

    @Test
    public void myApiTestPutSecond(){
        File filePut = new File("src/test/resources/json/jsonFile");
        HashMap<String,String> map = new HashMap<>();
        map.put("userId","88");
        map.put("id","7");
        map.put("title","Test title");
        map.put("body","Somebody once told me");
        given().log().all().contentType(ContentType.JSON)
                .body(map)
                .when().put("https://jsonplaceholder.typicode.com/posts/1")
                .then().log().all().statusCode(200);
    }

    @Test
    public void myTestDeleteSecond(){
        given().log().uri().contentType(ContentType.JSON)
                .when().delete("https://jsonplaceholder.typicode.com/posts/1")
                .then().statusCode(200);
    }
    @Test
    public void myApiTestGet(){
        given().log().all().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/unknown")
                .then().log().all().statusCode(200);
    }

    @Test
    public void myApiTestPost(){
        File file = new File("src/test/resources/json/jsonFileUpdate");
        given().log().all().contentType(ContentType.JSON)//("https://reqres.in/api/users")
                .body(file)
                .when().post("https://reqres.in/api/users").then().log().all().statusCode(201);
    }

    @Test
    public void myApiTestPut(){
        File filePut = new File("src/test/resources/json/jsonFileUpdate");
        HashMap<String,String> updateFile = new HashMap<>();
        updateFile.put("name","Nick");
        updateFile.put("job","Naher job");
        given().log().all().contentType(ContentType.JSON)
                .body(updateFile)
                .when().put("https://reqres.in/api/users/2")
                .then().log().body().statusCode(200);

    }

    @Test
    public void myApiTestDelete(){

        given().log().all().contentType(ContentType.JSON)
                .when().delete("https://reqres.in/api/users/2")
                .then().log().all().statusCode(204);
    }
    // .then()- что проверь
    // .log()- напичатй и дальше после . нужно выбрать что напечатать



}
