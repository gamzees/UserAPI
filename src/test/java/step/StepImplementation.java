package step;

import com.thoughtworks.gauge.Step;
import methods.UserMethods;

public class StepImplementation {


    UserMethods methods;

    public StepImplementation() //constructor
    {
        methods = new UserMethods();
    }
    @Step("<item> bilgisi gir")
    public void implementation1(String key) {
        methods.createdUser();

    }
}

