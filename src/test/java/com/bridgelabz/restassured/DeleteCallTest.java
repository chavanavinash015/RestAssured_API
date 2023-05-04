package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCallTest {

    @Test
    public void deletePetDetails() {
        Response response = RestAssured.delete("https://petstore.swagger.io/v2/pet/101");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
