package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ResponseSpecImp {

    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setup(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in/api/");
        requestSpecBuilder.addQueryParam("page","2");
        RestAssured.requestSpecification = requestSpecBuilder.build();
        responseSpecification = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void request_specification(){
        Response response = given(RestAssured.requestSpecification)
                .get("users/")
                .then().extract().response();
       // assertThat(response.statusCode(), is(equalTo(200)));
    }

}
