package utility.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.appium.AppiumServer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidAppDriver {

	 private static AndroidDriver driver;
	 
	    public static AndroidDriver loadNexus5xOreo() throws MalformedURLException {
	        AppiumServer.start();
	 
	        File file = new File("src");
	        File fileApp = new File(file, "xxxxxxxxxxxxxxxxxxxxxxxxx"); //set app filepath to /src/[name-of-apk-file]
	 
	        DesiredCapabilities capibilities = new DesiredCapabilities();
	        capibilities.setCapability("avd", "Nexus5xOreo"); //set the AVD (Android Virtual Device) to be launched
	        capibilities.setCapability("deviceName", "Nexus5xOreo"); //set the name of the device to be launched (should be same as AVD)
	        capibilities.setCapability("app", fileApp.getAbsolutePath()); //set the app to install and use as the one in the filepath specified above
	 
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capibilities); //set the AndroidDriver to an Appium session with the above DesiredCapabilities
	        return driver;
	    }
}
