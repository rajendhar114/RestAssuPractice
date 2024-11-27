package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExampl {
    @Test
    public void testPut(){

        JSONObject request=new JSONObject();
        request.put("name","Raj");
        request.put("email","qa11@gmail.com");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";

        given().
                //header("Content-Type","json/application").    //or
                contentType(ContentType.JSON).    // Sets Content-Type to application/json
                accept(ContentType.JSON).         // Sets Accept header to application/json
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();

    }
    @Test
    public void testPatch(){

        JSONObject request=new JSONObject();
        request.put("name","Raj");
        request.put("email","qa11@gmail.com");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";

        given().
                //header("Content-Type","json/application").    //or
                        contentType(ContentType.JSON).    // Sets Content-Type to application/json
                accept(ContentType.JSON).         // Sets Accept header to application/json
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();

    }
    @Test
    public void testDelete(){


        baseURI="https://reqres.in/api";

                when().
                delete("/users/2").
                then().
                statusCode(204).
                log().all();

    }
}
