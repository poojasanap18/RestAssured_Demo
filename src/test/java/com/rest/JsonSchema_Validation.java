package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchema_Validation {

    @BeforeClass
    public void setup(){

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://reqres.in/api").setContentType(ContentType.JSON).log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).expectStatusCode(200);

        RestAssured.responseSpecification = responseSpecBuilder.build();


    }

    @Test
    public void Register_Post_call(){
        Map<String,String> payload = new HashMap<>();
        payload.put("email","eve.holt@reqres.in");
        payload.put("password","pistol");
        given().
                body(payload).
                when().
                post("/register").
                then().
                statusCode(200).body(matchesJsonSchemaInClasspath("register.json")).
                log().all()
        ;

    }

}
