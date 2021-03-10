package step;

import com.thoughtworks.gauge.Step;
import methods.Methods;

public class StepImplementation {


    private Methods methods;

    public StepImplementation() { //constructor

        methods = new Methods();
    }

    @Step("<Post|Put|Get|Delete> methodunu gerceklestir.")
    public void setHttpMethods(String httpMethod) {
        methods.setHttpMethods(httpMethod);
    }

    @Step("<Parameter> paramatersini <Value> değerini ile json olarak ekle")
    public void setRequest(String paramater, String value){
        methods.setRequest(paramater, value);
    }

    @Step("<Parameter> parametresini <Value> değeri ile karsilastir.")
    public void assertIt(String parameter, String value){
        methods.asserIt(parameter,value);
    }

}




