package com.bridgelabz.tweeterTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TweeterTest {
    String API_KEY = "VcGInBrM7yx2kue8bZrJxp4IB";
    String API_SECRET_KEY = "xt6O00EcscBOGKuTneIIMNlGq7fP3EEW0invBHlU6wfDpNF5Bi";
    String ACCESS_TOKEN = "1228944808569262080-Rb16JA5PUshDXMbnUfGcBuQ7OhwdaN";
    String ACCESS_SECRET_TOKEN = "qN1vSS2v0fqUI1WoYzxGnJeBbr9Wtwhs4BRALAPVzAQWl";

//    String API_KEY = "mErlcTEUCPrOP5y0SuBWuyQJV";
//    String API_SECRET_KEY = "cnfRcUezMSKR5gKrG7aPM7tt5Ei9ON7GyrX3AwDpFPSv60tByQ";
//    String ACCESS_TOKEN = "4003503614-Kewo5cPjq0SokbPrjpd8E7vq5p6Q2t4CY2OnjCp";
//    String ACCESS_SECRET_TOKEN = "WnRlWOtPshGMvJMVtNbZZDi73T1AgtX1kGvbtZnj25Q86";
    String id;

    @Test
    public void CreateTweetTest() {
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/update.json";
        Response response = given().auth().oauth(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_SECRET_TOKEN).
                queryParam("status", "This is My First Tweet").
                when().post("update.json").then().extract().response();

        String res = response.asString();
        JsonPath js = new JsonPath(res);
  /*      id = js.get("id").toString();
        System.out.println("Tweet ID is :" + id);  */
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }

    @Test
    public void DeleteTweetTest() {
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/destroy/1651788639226183680.json");

        System.out.println("Status Code "+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }
    @Test
    public void UndoRetweetTest() {

        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/unretweet/1651789041162162177.json");

        System.out.println("Status Code "+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }
    @Test
    public void RetweetTest(){

        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/retweet/1651788639226183680.json");

        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
    @Test
    public void GetLatestTweet(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
        Response response=given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).queryParam("count", "1").
                when().get("/home_timeline.json").then().extract().response();
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
    @Test
    public void Retweetlookup(){
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                get("https://api.twitter.com/1.1/retweeters/id.json");

        String res =response.asString();
        System.out.println(res);
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
}
