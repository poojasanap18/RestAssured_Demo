package com.rest;
import io.restassured.config.LogConfig;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Headers {

    @Test
    public void request_response_logging(){
        Header header = new Header("Accept","*/*");

        given().baseUri("https://reqres.in/api/")
                .queryParam("page","2")
                .header(header)
                .when()
                .get("users/")
                .then()
                .log().all()
                .statusCode(200);
    }
}
