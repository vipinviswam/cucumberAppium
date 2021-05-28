package utility.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.extensions.ConfigFileReader;

import java.io.File;
import java.io.IOException;


public class AppiumServer {

//    private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildService
//            (new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new File("C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/main.js"))
//                    .withIPAddress("127.0.0.1").usingPort(4723));

//    private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();


//    public static void start() {
//        appiumServer.start();
//    }
//
//    public static void stop() {
//        appiumServer.stop();
//    }

    private static AppiumDriverLocalService service;
    private static ConfigFileReader jsonReader;
    private static String nodePath;
    private static String appiumJSPath;
    private static String appiumIPAdress;
    private static int appiumPort;

    public static void start() throws Exception {
//        jsonReader = new ConfigFileReader();
//        JSONObject obj = jsonReader.ReadConfigFile();
//        JSONObject config = (JSONObject) obj.get("CONFIG");
//        nodePath = (String) config.get("NODEPATH");
//        appiumJSPath = (String) config.get("APPIUMJSPATH");
//        appiumIPAdress = (String) config.get("APPIUMIPADDRESS");
//        appiumPort = ((Long) config.get("APPIUMPORT")).intValue();
        nodePath = System.getenv("NODEPATH");
        appiumJSPath = System.getenv("APPIUMJSPATH");
        appiumIPAdress = System.getenv("APPIUMIPADDRESS");
        appiumPort = Integer.parseInt(System.getenv("APPIUMPORT"));
        String chromeDriver = System.getProperty("user.dir") + "/chrome";


        if (checkIfServerIsRunning()) {
            return;
        }

        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File(nodePath))
                .withAppiumJS(new File(appiumJSPath));
        builder.withIPAddress(appiumIPAdress).usingPort(appiumPort);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");
        //*******
//        builder.withArgument(() -> "--chromedriver-executable", chromeDriver);
        builder.withArgument(() -> "--allow-insecure","chromedriver_autodownload");
        //**********
        //Start the server with the builder if not already running
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    static void stop() {
        service.stop();
    }

    //Check if Appium server is running
    private static boolean checkIfServerIsRunning() {
        return service != null;
    }


}
