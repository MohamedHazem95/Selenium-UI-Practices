package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {
    static String classLocation = "/src/main/java/data/";
    static String fileExtension = ".properties";
    static String projectLocation = "user.dir";

    public static String getValueFromPropertiesFile(String value, String fileName) {
        Properties properties = new Properties();
        FileInputStream file;
        try {
            file = new FileInputStream(System.getProperty(projectLocation) + classLocation + fileName + fileExtension);
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: [" + fileName + "].", e);
        }
        return properties.getProperty(value);
    }

    public static String updateValueInPropertiesFile(String key, String value, String fileName) {
        Properties properties = new Properties();
        FileInputStream fileIn;
        FileOutputStream fileOut;
        try {
            fileIn = new FileInputStream(System.getProperty(projectLocation) + classLocation + fileName + fileExtension);
            properties.load(fileIn);
            fileOut = new FileOutputStream(System.getProperty(projectLocation) + classLocation + fileName + fileExtension);
            properties.setProperty(key, value);
            properties.store(fileOut, "updated successfully");
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: [" + fileName + "].", e);
        }
        return properties.getProperty(value);
    }
}
