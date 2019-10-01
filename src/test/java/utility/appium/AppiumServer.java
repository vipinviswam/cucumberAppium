package utility.appium;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	// private static AppiumDriverLocalService appiumServer =
	// AppiumDriverLocalService.buildDefaultService();

	private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildService
			(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")).withAppiumJS(new File("/usr/local/bin/appium"))
					.withIPAddress("127.0.0.1").usingPort(4723));

	public static void start() {
		appiumServer.start();
	}

	public static void stop() {
		appiumServer.stop();
	}
}
