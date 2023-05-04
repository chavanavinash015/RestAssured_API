package com.bridgelabz.jsonserver;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonBDDMethod {

    @Test
    public void getJsonDetails() {

        String body = given().
                when().
                get("http://localhost:3000/posts").asPrettyString();

        System.out.println("Body: " + body);
    }

    @Test
    public void postJsonTest() {
        JSONObject json = new JSONObject();
        json.put("id", 6);
        json.put("title", "Friend");
        json.put("authar", "Ram");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().post("http://localhost:3000/posts/").
                then().statusCode(201);
    }
    @Test
    public void putJsonTest(){

        JSONObject json = new JSONObject();
//        json.put("id", 1);
        json.put("title", "Friend");
        json.put("authar", "Tushar");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().put(" http://localhost:3000/posts/1").
                then().statusCode(200);
    }

    @Test
    public void deleteJsonTest(){
        given().header("Content-Type", "application/json").
                when().put(" http://localhost:3000/posts/5").
                then().statusCode(200);
    }
}
