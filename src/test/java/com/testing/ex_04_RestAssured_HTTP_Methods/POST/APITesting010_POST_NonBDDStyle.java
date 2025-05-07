package com.testing.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDDStyle {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST_NonBDDStyle_Create_Token() {
        // URL, Method, Payload/ body / headers
        // Auth?
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        System.out.println(" ----    Part 2 ---- ");

        // Making HTTP Request -> Part 2
        response = requestSpecification.when().log().all().post();

        System.out.println(" ----    Part 3 ---- ");

        // Verification Part -> Part 3
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}