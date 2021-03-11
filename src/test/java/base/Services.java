package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;

public class Services {
    public static final String baseURL = "https://petstore.swagger.io/v2/";
    public RequestSpecification requestSpecification;
    private Response response;
    public JSONObject requestParams = new JSONObject();
    public JSONObject requestObject = new JSONObject();
    private static String fileDirectoryPath = System.getProperty("user.dir");
    private String webServiceRequest;
    private String endpoint;



    public static String readJson(String file) throws IOException {

        fileDirectoryPath = "/src/test/resources/" + file + ".json";
        String serviceRequest = new String(Files.readAllBytes(Paths.get(fileDirectoryPath)));
        return serviceRequest;

    }

    private RequestSpecBuilder requestSpecBuilder() {
        RequestSpecBuilder reqSpecBuilder;
        webServiceRequest = webServiceRequest.isEmpty() ? requestObject.toString() : webServiceRequest;
        reqSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(baseURL + endpoint)
                .setBody(webServiceRequest)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);
        return reqSpecBuilder;
    }

    public void startWebServices(String endpoint, String jsonFile) throws IOException {
        webServiceRequest = readJson(jsonFile);
        this.endpoint = endpoint;
        requestSpecBuilder();
    }

    public void post() {
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .post(baseURL).then().extract().response();
    }

    public void asserIt(String parameter,String value){
        Assert.assertEquals(response.jsonPath().getString(parameter),value);
    }

    public void get() {
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .get(baseURL).then().extract().response();
    }

    public void delete() {
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .delete(baseURL).then().extract().response();
    }

    public void put() {
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .put(baseURL).then().extract().response();;
    }

    public Response response(){
        return  response;
    }
}