package com.testing.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

@Test
public class APITesting008_GET_BDDStyle {
        public void test_GET_POSITIVE(){
            String pincode="577201";
            RestAssured
                    .given()
                          .baseUri("https://api.zippopotam.us")
                           .basePath("/IN/" + pincode)
                    .when()
                          .log().all()
                          .get()
                    .then()
                          .log().all()
                          .statusCode(200);

        }
}
