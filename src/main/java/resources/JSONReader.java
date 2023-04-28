package resources;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONReader {
    public static String username;
    JSONParser jsonParser = new JSONParser();
    static String dataFilePath = "src/test/resources/JSONFiles/";
    public static String readJSON(String className , String TCName ,String parameterName) {
        try {
        FileReader reader = new FileReader(dataFilePath+className+".JSON");
        JSONParser jsonParser = new JSONParser();
        Object obj =  jsonParser.parse(reader);
        JSONArray valuesArray = (JSONArray) obj;

        for (int i = 0; i < valuesArray.size(); i++) {
            JSONObject cases = (JSONObject) valuesArray.get(i);
            JSONObject caseNo = (JSONObject) cases.get(TCName);
            username = (String) caseNo.get(parameterName);
        }
            }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return username;
    }
}
