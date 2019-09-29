package utility.appium;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.appium.AppiumServer;
import utility.drivers.AndroidAppDriver;
import java.net.MalformedURLException;
 
public class DriverController {
 
    public static DriverController instance = new DriverController();
 
    AndroidDriver androidDriver;
 
    private static Logger log = LogManager.getLogger(DriverController.class);
 
    public void startNexus5xOreo() throws MalformedURLException {
        if (instance.androidDriver != null) return;
        instance.androidDriver = AndroidAppDriver.loadNexus5xOreo();
    }
 
    public void stopAppDriver() {
        if (instance.androidDriver == null) return;
 
        try {
            instance.androidDriver.quit();
        } catch (Exception e) {
            log.error(e + ":: AndroidDriver stop error");
        }
 
        AppiumServer.stop();
        instance.androidDriver = null;
        log.debug(":: AndroidDriver stopped");
    }
}
