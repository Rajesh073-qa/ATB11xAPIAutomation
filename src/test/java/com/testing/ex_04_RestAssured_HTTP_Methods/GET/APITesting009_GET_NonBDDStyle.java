package com.testing.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_GET_NonBDD() {
        String pincode = "577201";
        //Given
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://api.zippopotam.us");
        requestSpecification.basePath("/IN/" + pincode);
        //When
        response = requestSpecification.log().all().get();
        System.out.println(response.asString());
        //then
        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
    @Test
    public void test_GET_NonBDD_Negative(){
        String pincode="deck@@#";
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://api.zippopotam.us");
        requestSpecification.basePath("/IN/" + pincode);

        response=requestSpecification.when().log().all().get();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(404);

    }
}
