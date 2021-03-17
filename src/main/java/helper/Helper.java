package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    private static String fileDirectoryPath = System.getProperty("user.dir");

    public static String readJsonFile(String jsonFileName) throws IOException {

        fileDirectoryPath = fileDirectoryPath + "/src/main/resources/" + jsonFileName + ".json";
        String serviceRequest = new String(Files.readAllBytes(Paths.get(fileDirectoryPath)));
        return serviceRequest;
    }

}
