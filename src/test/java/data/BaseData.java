package data;

import helper.Helper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseData {
    public static final String USER_BASE_URL = "https://petstore.swagger.io/v2/user/";
    public RequestSpecification requestSpecification;
    private Response response;
    public JSONObject requestBody;
    private String endpoint;

    @BeforeMethod
    public void BeforeMethod(){
        requestSpecification  = RestAssured.given().contentType(ContentType.JSON);
    }

    public void startWebServices(String jsonFile,String endpoint) throws IOException {
        requestBody = Helper.readJson(jsonFile);
        this.endpoint = endpoint;
    }
}






