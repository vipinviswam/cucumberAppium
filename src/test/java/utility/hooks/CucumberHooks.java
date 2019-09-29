package utility.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.appium.DriverController;
 
import java.net.MalformedURLException;
 
public class CucumberHooks {
 
    @Before("@Nexus5xOreo")
    public void beforeNexus5xOreo() throws MalformedURLException {
        DriverController.instance.startNexus5xOreo(); //start our Android driver and device when we run a test with "Nexus5xOreo" as the tag
    }
 
    @After
    public void stopAppDriver() {
        DriverController.instance.stopAppDriver(); //stop the Driver after the scenario or feature has run
    }
}
