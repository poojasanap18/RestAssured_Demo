package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Request_Response_Logging {

    @Test
    public void request_response_logging(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .log().all()
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void request_response_logging1(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .log().headers()
                .when()
                .get("users/")
                .then()
                .log().headers()
                .statusCode(200);
    }


    @Test
    public void request_response_logging2(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .log().body()
                .when()
                .get("users/")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void request_response_logging3(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .log().cookies()
                .when()
                .get("users/")
                .then()
                .log().cookies()
                .statusCode(200);
    }

    @Test
    public void request_response_logging4(){
        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .log().parameters()
                .when()
                .get("users/")
                .then()
                .log().everything()
                .statusCode(200);
    }

}
