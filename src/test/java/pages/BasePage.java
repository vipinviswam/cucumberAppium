package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import static utility.appium.Driver.appDriver;
 
public class BasePage extends Page {
    
    public AndroidDriver driver = appDriver();
 
    private static Logger log = LogManager.getLogger(BasePage.class.getName());
}
