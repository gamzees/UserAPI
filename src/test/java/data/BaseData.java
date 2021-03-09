package data;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseData {
    public static final String USER_BASE_URL = "https://petstore.swagger.io/v2/user/";
    public RequestSpecification requestSpecification;


    @BeforeMethod
    public void BeforeMethod(){
        requestSpecification  = RestAssured.given().contentType(ContentType.JSON);
    }
}


