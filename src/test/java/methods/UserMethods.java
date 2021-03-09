package methods;

import base.BaseTest;
import entity.user.LoginResponse;
import entity.user.User;
import entity.user.UserResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.log;
import static data.BaseData.USER_BASE_URL;
import static io.restassured.RestAssured.given;

public class UserMethods {

    Response response;

    public UserMethods() {

    }

    public Response createdUser(User user) {


        JSONObject requestParams = new JSONObject();
        requestParams.put("id", user.getId());
        requestParams.put("username", user.getUsername());
        requestParams.put("firstname", user.getFirstName());
        requestParams.put("lastname", user.getLastName());
        requestParams.put("email", user.getEmail());
        requestParams.put("password", user.getPassword());
        requestParams.put("phone", user.getPhone());
        requestParams.put("userStatus", user.getUserStatus());


        log.info("userRequest json: " + requestParams.toJSONString());

        Response response = given().contentType(ContentType.JSON).body(requestParams).when().post(USER_BASE_URL);
        log.info("Response statu code : " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200.");
        log.info("New entity.user is created");

        return response;
    }
}
