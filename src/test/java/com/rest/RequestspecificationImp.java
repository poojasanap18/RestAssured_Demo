package com.rest;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestspecificationImp {


    @Test
    public void request_specification(){
    RequestSpecification requestSpecification = given().
            baseUri("https://reqres.in/api/").
            queryParam("page","2");


        given(requestSpecification)
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void request_specification2(){
        RequestSpecification requestSpecification = given().
                baseUri("https://reqres.in/api/").
                queryParam("page","2");


        given().spec(requestSpecification)
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200);
    }

}
