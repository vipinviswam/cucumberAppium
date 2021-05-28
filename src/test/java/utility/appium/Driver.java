package utility.appium;

import io.appium.java_client.android.AndroidDriver;

public class Driver {

    public static AndroidDriver appDriver() {
        return DriverController.instance.androidDriver;
    }
}
