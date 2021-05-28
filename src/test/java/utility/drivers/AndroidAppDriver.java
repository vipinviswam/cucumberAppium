package utility.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.appium.AppiumServer;
import utility.extensions.ConfigFileReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AndroidAppDriver {

    private static AndroidDriver driver;
    private static ConfigFileReader jsonReader;
    private static String apkPath;
    private static String apkFileName;
    private static String platformName = System.getenv("ANDROID_PLATFORM_NAME");
    private static String platformVersion = System.getenv("ANDROID_PLATFORM_VERSION");

    public static AndroidDriver loadDriver(String avdDeviceName, String udid, int systemPort) throws Exception {
        AppiumServer.start();

//        jsonReader = new ConfigFileReader();
//        JSONObject obj = jsonReader.ReadConfigFile();
//        JSONObject config = (JSONObject) obj.get("CONFIG");
        String chromeMapping = System.getProperty("user.dir") + "/src/test/resources/localisation_files/mapping.json";
        apkPath = System.getenv("APKPATH");
        apkFileName = System.getenv("APKFILENAME");
        File file = new File(apkPath);
        File fileApp = new File(file, apkFileName); //set app filepath to /src/[name-of-apk-file]
        File chromeDriver = new File(System.getProperty("user.dir") + "/chrome");
        /**
         * ** This can be uncommented if we dont want automatic download of compatible chrome driver
         
//        File chrome = new File("chromedriver");
//        File executable = new File(chromeDriver, String.valueOf(chrome));
         */
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.setExperimentalOption("androidProcess", "com.app.show");
        chromeOpt.setExperimentalOption("w3c", false);

        DesiredCapabilities capabilities = new DesiredCapabilities();
//      capabilities.setCapability("avd", avdDeviceName);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOpt);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion",platformVersion);
        capabilities.setCapability("deviceName", avdDeviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("systemPort", systemPort);
        capabilities.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above
        /**
           ** Automatic Download of chromedrver capabilities added
        */
        capabilities.setCapability("chromedriverChromeMappingFile", chromeMapping);
        capabilities.setCapability("chromedriverExecutableDir", chromeDriver.getAbsolutePath());
        // *************
        capabilities.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        /**
        ** This can be uncommented if we need webiview log from chromedriver

//         capabilities.setCapability("showChromedriverLog", true);

         /**
         ** This can be uncommented if we dont want automatic download of compatible chrome driver
         *
       capabilities.setCapability("chromedriverExecutable",executable.getAbsolutePath());
       capabilities.setCapability("chromedriverUseSystemExecutable", false);
        */
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.app.show");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //set the AndroidDriver to an Appium session with the above DesiredCapabilities
        return driver;
    }
}

