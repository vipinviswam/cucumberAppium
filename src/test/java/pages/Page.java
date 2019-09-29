package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
 
import static utility.appium.Driver.appDriver;
 
public class Page {
 
    public static <T extends BasePage> T instanceOf(Class<T> clazz) {
        return initElements(appDriver(), clazz); //return our own custom initElements() method instead of one provided by Selenium
    }
 
    private static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), page);
        return page;
    }
 
    private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException var3) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException var4) {
            throw new RuntimeException(var4);
        }
    }
}
