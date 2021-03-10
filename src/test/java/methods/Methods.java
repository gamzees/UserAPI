package methods;

import base.Services;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Methods {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
    public Services services;


    public Methods() {
        services = new Services();
    }

    public void setRequest(String paramater, String value) {
        services.requestParams.put(paramater, value);
    }


    public void setHttpMethods(String httpMethods) {
        switch (httpMethods) {
            case "GET":
               services.get();
                break;
            case "POST":
                services.post();
                break;
            case "PUT":
                services.put();
                break;
            case "DELETE":
               services.delete();
                break;
        }
    }

    public void asserIt(String parameter, String value){
        services.asserIt(parameter,value);
    }


}