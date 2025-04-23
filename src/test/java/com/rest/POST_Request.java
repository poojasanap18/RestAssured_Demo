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

public class POST_Request {

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
                    statusCode(200);

    }

    @Test
    public void Register_Post_call_negative_sceanrio(){
        Map<String,String> payload = new HashMap<>();
        payload.put("email","eve.holt@reqres.in");
        payload.put("password","pistoll");
        given().
                body(payload).
                when().
                post("/register").
                then().
                statusCode(200);

    }

    @Test
    public void Register_Post_call_negative_sceanrio1(){
        Map<String,String> payload = new HashMap<>();
        payload.put("email","eve.holt@reqres.in");
        payload.put("password","pistollll");
        given().
                body(payload).
                when().
                post("/register").
                then().
                statusCode(200);

    }

    @Test
    public void Register_Post_call_logall(){
        Map<String,String> payload = new HashMap<>();
        payload.put("email","eve.holt@reqres.in");
        payload.put("password","pistol");
        given().
                body(payload).
                when().
                post("/register").
                then().
                statusCode(200).log().all();

    }

}
