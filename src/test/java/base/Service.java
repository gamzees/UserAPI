package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Service {

    private Response response;
    private RequestSpecification requestSpecification;
    private JSONObject requestPayload = new JSONObject();
    private String requestBody;
    private String baseURL = "https://petstore.swagger.io/v2/";
    private RequestSpecBuilder reqSpecBuilder;


    public void startWebServices(String filePath,String path) {

        reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder.setBasePath(path);
    }

    private void requestSpecBuilder(){

        //requestBody = requestPayload;
        reqSpecBuilder
                .setBaseUri(baseURL)
                .setBody(requestPayload)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);

    }

    public void setMethods(String requestType) {
        requestSpecBuilder();

        switch (requestType) {

            case "GET":
                get();
                break;
            case "POST":
                post();
                getResponse().prettyPrint();
                break;
            case "PUT":
                put();
                getResponse().prettyPrint();
                break;
            case "DELETE":
                delete();
                break;

        }
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