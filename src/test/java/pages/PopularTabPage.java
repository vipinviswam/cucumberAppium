package pages;

import static utility.appium.Driver.appDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopularTabPage extends BasePage {
	
	
	private static Logger log = LogManager.getLogger(BasePage.class.getName());

	public AndroidDriver driver = appDriver();
	private String getPageSource() {
		return driver.getPageSource();
	}
	
	@AndroidFindBy(id = "com.reddit.frontpage:id/nav_icon")
	AndroidElement navIcon;
	public void popularLandingPage(){
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(navIcon));
		
	}

}
