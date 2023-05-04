package com.bridgelabz.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDDMethodTest {
    /*
    * given() ---
    * when() ----
    * then() --
    *
    * */

    @Test
    public void getPetTest(){

       String getbody = given().
               when().
                get("https://petstore.swagger.io/v2/pet/100").asPrettyString();

        System.out.println(getbody);
    }

    @Test
    public void postPetTest(){
        JSONObject json = new JSONObject();
        json.put("id", 100);
        json.put("name", "teddy");
        json.put("status", "sending");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().post("https://petstore.swagger.io/v2/pet/").
                then().statusCode(200);
    }

    @Test
    public void putPetTest(){

        JSONObject json = new JSONObject();
        json.put("id", 101);
        json.put("name", "teddybear");
        json.put("status", "sended");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().put("https://petstore.swagger.io/v2/pet/").
                then().statusCode(200);
    }

    @Test
    public void deletePetTest(){
        given().when().delete("https://petstore.swagger.io/v2/pet/101").then().assertThat().statusCode(200);
    }

}
