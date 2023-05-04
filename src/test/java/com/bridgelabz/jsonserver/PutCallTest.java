package com.bridgelabz.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutCallTest {

    @Test
    public void modifyDetails() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.put("http://localhost:3000/posts/3");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

    }
}
