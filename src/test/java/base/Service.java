package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Service {

    private Response response;
    private String requestBody;
    private String baseURL = "https://petstore.swagger.io/v2/";
    private RequestSpecBuilder reqSpecBuilder;


    public void startWebServices(String path) {

        reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder.setBasePath(path);
    }

    public void requestSpecBuilder(String body){

        //requestBody = requestPayload;
        reqSpecBuilder
                .setBaseUri(baseURL)
                .setBody(body)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);

    }

    public void pathParam(String key, Object value) {
        reqSpecBuilder.addPathParam(key, value);
    }

    public void get(){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .get()
                .then()
                .extract().response();

    }

    public void post(){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .post()
                .then()
                .extract().response();

    }

    public Response getResponse(){
        return  response;
    }

    public void delete(){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .delete()
                .then()
                .extract().response();

    }

    public void put(/*String key, Object value*/){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .put()
                .then()
                .extract().response();

    }
}