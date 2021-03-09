package step;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import entity.user.User;
import io.restassured.response.Response;
import methods.UserMethods;
import org.testng.annotations.BeforeMethod;

public class StepImplementation {


    private UserMethods methods;
    private User user;

    public StepImplementation() { //constructor
        user = new User();
        methods = new UserMethods();
    }

    @Step("User bilgisi olustur")
    public void createUser() {
       createUser();
    }

    @Step("Get User login")
    public void implementation1() {
        //  user.setUsername(username); //düzelteceğim
        //  user.setPassword(password); // bunu da
        Response response = methods.createdUser(user);
    }

  
}


