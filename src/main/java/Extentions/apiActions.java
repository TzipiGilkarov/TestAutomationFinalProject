package Extentions;

import Utilities.CommonOps;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends CommonOps
{
    @Step("get Data from server")
    public static Response get(String paramValues)
    {
        response=httpRequest.get(paramValues);
        System.out.println(response.prettyPrint());
        return response;
    }
    @Step("Extract value from json format")
    public static String extractFromJson(Response response,String path)
    {
        jp=response.jsonPath();
       return jp.get(path).toString();

    }

    @Step("Post Data to server")
    public static void post(JSONObject param, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response=httpRequest.post(resource);
        System.out.println(response.prettyPrint());

    }

    @Step("Update Data in server")
    public static void put(JSONObject param, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response=httpRequest.put(resource);
        System.out.println(response.prettyPrint());

    }

    @Step("Delete Data to server")
    public static void delete(String id)
    {

        response=httpRequest.delete("/api/teams/"+id);
        System.out.println(response.prettyPrint());

    }
}

