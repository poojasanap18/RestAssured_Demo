package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseSpecImp {

    @BeforeClass
    public void setup(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in/api/");
        requestSpecBuilder.addQueryParam("page","2");
        RestAssured.requestSpecification = requestSpecBuilder.build();
       // responseSpecification = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON);
        RestAssured.responseSpecification= responseSpecBuilder.build();
    }

    @Test
    public void request_specification(){
        Response response = given(RestAssured.requestSpecification)
                .get("users/")
                .then().extract().response();
       // assertThat(response.statusCode(), is(equalTo(200)));


    }

}
