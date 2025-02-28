package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GET_Request {

    @org.testng.annotations.Test
    public void test(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200)
                .body("data[0].first_name",equalTo("Michael"),
                        "data[0].last_name",equalTo("Lawson"));
    }

    @org.testng.annotations.Test
    public void test1(){
        Response res = given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        System.out.println("\n Response : "+res.asPrettyString());
        System.out.println("First Name : "+res.path("data[0].first_name"));
        JsonPath js = new JsonPath(res.asString());
        System.out.println("First Name : "+js.getString("data[0].first_name"));
        System.out.println();

    }

    @org.testng.annotations.Test
    public void test2(){
        String name = given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().path("data[0].first_name");
        System.out.println("Name : "+name);

    }

}
