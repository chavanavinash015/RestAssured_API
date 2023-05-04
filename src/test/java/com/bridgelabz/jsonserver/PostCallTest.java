package com.bridgelabz.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostCallTest {


    @Test
    public void addJsonTest() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("title", "RestAssured");
        json.put("auther", "Avinash");

        request.body(json.toJSONString());

        Response response = request.post("http://localhost:3000/posts");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 201);

    }
}
