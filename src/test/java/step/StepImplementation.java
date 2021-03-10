package step;

import com.thoughtworks.gauge.Step;
import data.BaseData;
import entity.user.User;
import io.restassured.response.Response;
import lombok.Data;
import methods.Methods;

import java.io.IOException;

public class StepImplementation {


    private Methods methods;
    private User user;

    public StepImplementation() { //constructor
        user = new User();
        methods = new Methods();
    }

    @Step("User bilgisi olustur")
    public void createUser() {
       methods.createdUser(user);
    }

    @Step("Get User login")
    public void getUser() {
        methods.getUser(user);
    }

}


