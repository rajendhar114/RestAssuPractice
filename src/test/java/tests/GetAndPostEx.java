package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostEx {

   // @Test
    public void testGet(){
        baseURI="https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[4].first_name",equalTo("George")).
        body("data.first_name",hasItems("George","Rachel"));

    }

    @Test
    public void testMap(){
 //       Map<String,Object> map= new HashMap<>() ;
//        map.put("name","morpheus");
//        map.put("map","leader");
//        System.out.println(map);

        JSONObject request=new JSONObject();
        request.put("name","morpheus");
        request.put("map","leader");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";

        given().
                //header("Content-Type","json/application").    //or
                contentType(ContentType.JSON).    // Sets Content-Type to application/json
                accept(ContentType.JSON).         // Sets Accept header to application/json
                body(request.toJSONString()).
        when().
                get("/users").
        then().
               statusCode(200).
               log().all();

    }
}
