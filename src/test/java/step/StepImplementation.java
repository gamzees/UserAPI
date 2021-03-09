package step;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import entity.user.User;
import io.restassured.response.Response;
import methods.UserMethods;
import org.testng.annotations.BeforeMethod;
import utility.log;

public class StepImplementation {


    private UserMethods methods;
    private User user;

    @BeforeMethod
    public void BeforeMethod(){
        user = new User();
        methods = new UserMethods();
    }


    @Step("Get User login")
    public void implementation1() {
        user.setUsername(username); //düzelteceğim
        user.setPassword(password); // bunu da
        Response response = methods.createdUser(user);
        log.info("Response statu code : " + response.getStatusCode());
        log.info("Response login success");
    }

    }
}

