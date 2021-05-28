package utility.extensions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Objects;

public class ConfigFileReader {

//    private Properties properties;
//    private final String propertyFilePath= "configs//Configuration.properties";
//
//
//    public ConfigFileReader(){
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(propertyFilePath));
//            properties = new Properties();
//            try {
//                properties.load(reader);
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
//        }
//    }

    public String getReportConfigPath() {
        String reportConfigPath = System.getProperty("user.dir") + "\\resources\\report_config\\extent-config.xml";
        if (reportConfigPath != null) {
            return reportConfigPath;
        } else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath" + reportConfigPath);
    }

    public String GetJsonFilePath(String language) {
        String jsonFilePath = null;
        if (Objects.equals(language, "en")) {
            jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/localisation_files/en.json";
            if (jsonFilePath != null) {
                return jsonFilePath;
            } else
                throw new RuntimeException("Localisation Config Path not specified in the file for the Key:localisationPath" + jsonFilePath);
        } else if (Objects.equals(language, "sc")) {
            jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/localisation_files/sc.json";
            if (jsonFilePath != null) {
                return jsonFilePath;
            } else
                throw new RuntimeException("Localisation Config Path not specified in the file for the Key:localisationPath" + jsonFilePath);
        } else {
            jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/localisation_files/tc.json";
            if (jsonFilePath != null) {
                return jsonFilePath;
            } else
                throw new RuntimeException("Localisation Config Path not specified in the file for the Key:localisationPath" + jsonFilePath);
        }
    }

    public JSONObject ReadJsonFile(String jsonFilePath) throws Exception {
        Object obj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    public JSONObject ReadConfigFile() throws Exception{
        String configFilePath = System.getProperty("user.dir") + "/src/test/resources/config_file/config.json";
        if(configFilePath != null){
            Object obj = new JSONParser().parse(new FileReader(configFilePath));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } else
            throw new RuntimeException("Config Path not specified in the Configuration.properties file for the Key:ConfigPath" + configFilePath);
    }
}
