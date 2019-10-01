package utility.hooks;


import utility.appium.DriverController;
 
import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
 
public class CucumberHooks {
 
    @Before("@Pixel")
    public void beforeNexus5xOreo() throws MalformedURLException {
        DriverController.instance.startNexus5xOreo(); //start our Android driver and device when we run a test with "Nexus5xOreo" as the tag
    }
 
    @After
    public void stopAppDriver() {
        DriverController.instance.stopAppDriver(); //stop the Driver after the scenario or feature has run
    }
}
