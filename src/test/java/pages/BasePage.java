package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static utility.appium.Driver.appDriver;

import java.util.List;

public class BasePage extends Page {

	public AndroidDriver driver = appDriver();

	private static Logger log = LogManager.getLogger(BasePage.class.getName());

	private String getPageSource() {
		return driver.getPageSource();
	}

	@AndroidFindBy(id = "com.reddit.frontpage:id/welcome_message")
	private AndroidElement welcomeMessage;
	@AndroidFindBy(id = "com.reddit.frontpage:id/skip_text")
	private AndroidElement skipForNowButton;

	public void appFullyLaunched() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
		log.info("==================== Found welcome message ==================");
		wait.until(ExpectedConditions.visibilityOf(skipForNowButton));
		log.info("==================== Found Skip Button ==================");
	}
	
	public void clickSkipForNowButton(){
		skipForNowButton.click();
		log.info("==================== Click Skip Button ==================");
	}
	

//	public void validatePageSource(String expectedPageSource) {
//		Assert.assertTrue(getPageSource().contains(expectedPageSource));
//		log.info(":: The text " + expectedPageSource + " is present in the app screen's source.");
//	}
//
//	public void validateMultipleInPageSource(List<String> table) {
//		for (String row : table) {
//			Assert.assertTrue(getPageSource().contains(row));
//			log.info("The text " + row + " is in the app screen's source.");
//		}
//	}
	
	

}
