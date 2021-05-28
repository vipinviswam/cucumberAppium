package utility.appium;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.drivers.AndroidAppDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class DriverController {

    public static DriverController instance = new DriverController();

    AndroidDriver androidDriver;

    private static Logger log = LogManager.getLogger(DriverController.class);

//    public void startNexus5xOreo() throws MalformedURLException {
//        if (instance.androidDriver != null) return;
//        instance.androidDriver = AndroidAppDriver.loadNexus5xOreo();
//    }

    public void startAppDriver(String avdDeviceName, String udid, int systemPort) throws Exception {
        if (instance.androidDriver != null) return;
        instance.androidDriver = AndroidAppDriver.loadDriver(avdDeviceName, udid, systemPort);
    }

    public void stopAppDriver() {
        if (instance.androidDriver == null) return;

        try {
//            instance.androidDriver.removeApp("com.cncbi.directbank.dev.mvp1");
            instance.androidDriver.quit();
        } catch (Exception e) {
            log.error(e + ":: AndroidDriver stop error");
        }

        try {
            AppiumServer.stop();
        } catch (Exception e) {
            log.error(e + ":: AppiumServer stop error");
        }

        instance.androidDriver = null;
        log.debug(":: AndroidDriver stopped");
    }
}
