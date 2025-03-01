package com.rest;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpec_alt_implementation {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setup(){
        requestSpecification = given().
                baseUri("https://reqres.in/api/").
                queryParam("page","2");
    }

    @Test
    public void request_specification(){

        given(requestSpecification)
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200);
    }

}
