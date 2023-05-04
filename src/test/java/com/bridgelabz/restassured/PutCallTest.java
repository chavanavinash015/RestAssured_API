package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutCallTest {

    @Test
    public void modifyPetDetails() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", 100);
        json.put("name", "Tushar");
        json.put("status", "sold");

        request.body(json.toJSONString());

        Response response = request.put("https://petstore.swagger.io/v2/pet/");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

    }


    }
