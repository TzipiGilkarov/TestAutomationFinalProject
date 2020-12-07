package Helpers;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class temp
{
    String url="http://localhost:3030/";


//    @Test
//    public void testing()
//    {
//
//        params.put("name","TzipiTeam");
//        params.put("email","tzipi@gmail.com");
//
//        RestAssured.baseURI=url;
//        httpRequest=RestAssured.given().auth().preemptive().basic("admin","admin");
//        httpRequest.header("Content-Type","application/json");
//
//        httpRequest.body(params.toJSONString());
//        //response=httpRequest.put("/api/teams/1");
//        //response=httpRequest.post("/api/teams");
//        //response=httpRequest.get("/api/teams/search?perpage=50&page=1");
//        response=httpRequest.delete("/api/teams/1");
//        System.out.println(response.prettyPrint());
//
//
//
//
//    }
}
