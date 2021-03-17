import base.Service;
import com.thoughtworks.gauge.Step;
import methods.Methods;
import java.io.IOException;
public class StepImplementation {

    Methods methods;
    Service createRequest;

    public StepImplementation() {
        this.methods = new Methods();
        createRequest = new Service();
    }

    @Step("<path> endpointi ve <file> json dosyası ile servisi başlat")
    public void startService(String path,String fileName) {
        methods.startWebService(path,fileName);
    }

    @Step("<path> endpointi ile servisi başlat")
    public void startService(String path) {
        methods.startWebService("",path);
    }

    @Step("<GET|POST|PUT|DELETE> islemi yap")
    public void setHttpMethods(String requestType) throws IOException {
        methods.setMethods(requestType);
    }

    @Step("<key> keyi ve <value> degeri ile url pathi ekle")
    public void setPathParam(String key, Object value) {
        methods.setPathParam(key, value);
    }


    @Step("<parameter> parameteri ile Array Objesini oluştur")
    public void createJsonArray(String parameter) {
        methods.createJsonArray(parameter);
    }

    @Step("<parameter> parameteri ile Json Objesini oluştur")
    public void createJsonObject(String parameter) {
        methods.createJsonObject(parameter);
    }

    @Step("<parameter> parameteri ile Json List Objesini oluştur")
    public void createListObject(String parameter) {
        methods.createListObject(parameter);
    }


    @Step("<parameter> parameteresini listeye ekle")
    public void setListParameter(String parameter) {
        methods.setListObject(parameter);
    }

    @Step("<parameter> parameter Int:<value> değeri ile request oluştur")
    public void setParameterInt(String parameter, int value) {
        methods.setParameter(parameter, value);
    }

    @Step("<parameter> parameter String:<value> değeri ile request oluştur")
    public void setParameterString(String parameter, String value) {
        methods.setParameter(parameter, value);
    }

    @Step("<parameter> parameter Boolean:<value> değeri ile request oluştur")
    public void setParameterBoolean(String parameter, boolean value) {
        methods.setParameter(parameter, value);
    }

    @Step("<parameter> parameter Int:<value> değeri ile json objesi oluştur")
    public void setObjectParameterInt(String parameter, int value) {
        methods.setJsonObjectParameter(parameter, value);
    }

    @Step("<parameter> parameter String:<value> değeri ile json objesi oluştur")
    public void setObjectParameterString(String parameter, String value) {
        methods.setJsonObjectParameter(parameter, value);
    }

    @Step("<parameter> parameter Boolean:<value> değeri ile json objesi oluştur")
    public void setObjectParameterBoolean(String parameter, boolean value) {
        methods.setJsonObjectParameter(parameter, value);
    }

    /*@Step("Request body hazırlamak için işlemleri başlat")
    public void startService() {
        methods.startCreateObject();
    }*/

    @Step("Json Objesini Temizle")
    public void clearJsonObject() {
        methods.clearJsonObject();
    }

    @Step("Json List Objesini Temizle")
    public void clearListObject() {
        methods.clearListObject();
    }
}






