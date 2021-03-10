package base;

import helper.Helper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Services {
    public static final String USER_BASE_URL = "https://petstore.swagger.io/v2/user/";
    public RequestSpecification requestSpecification;
    private Response response;
    public JSONObject requestParams = new JSONObject();


     /*  @BeforeMethod
    public void BeforeMethod(){
        requestSpecification  = RestAssured.given().contentType(ContentType.JSON);
    }*/

    public void startWebServices(String jsonFile,String endpoint) throws IOException {
        requestParams = Helper.readJson(jsonFile);
    }


    public void post() {
        response = given().contentType(ContentType.JSON).body(requestParams).when().post(USER_BASE_URL);
    }

    public void asserIt(String parameter,String value){
        Assert.assertEquals(response.jsonPath().getString(parameter),value);
    }

    public void get() {
        response = given().contentType(ContentType.JSON).body(requestParams).when().get(USER_BASE_URL);
    }

    public void delete() {
        response = given().contentType(ContentType.JSON).body(requestParams).when().delete(USER_BASE_URL);
    }

    public void put() {
        response = given().contentType(ContentType.JSON).body(requestParams).when().put(USER_BASE_URL);
    }

    public Response response(){
        return  response;
    }
}






