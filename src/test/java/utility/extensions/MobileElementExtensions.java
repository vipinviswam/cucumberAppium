package utility.extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.appium.DriverController;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static utility.appium.Driver.appDriver;

//import org.openqa.selenium.interactions.touch.TouchActions;

public class MobileElementExtensions {

    private final String USER_DIR = System.getProperty("user.dir");
    public AndroidDriver driver = appDriver();

    private static Logger log = LogManager.getLogger(DriverController.class);
    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT;
    }

    /*
     * meWaitforSeconds will wait for 20 seconds
     * */

    public static WebDriverWait meWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(appDriver(), 300);
        return wait;
    }

    /*
    * Will check that a given MobileElement is displayed, after waiting the specified
    amount of time from the weWaitForSeconds() method.
    *  */
    public static boolean meElementIsDisplayed(MobileElement element) {
        meWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /*
     * Will check that a given MobileElement is clickable, after waiting the
     * specified amount of time from the meWaitForSeconds() method.
     *  */

    public static boolean meElementToBeClickable(MobileElement element) {
        meWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    /*
     * Will hide the keyboard
     *  */

    public static void mehideKeyBoard(){
        appDriver().hideKeyboard();
    }

    /*
     *  wait for a given MobileElement to be clickable/tappable, highlight the
     * clickable/tappable MobileElement, and then tap the MobileElement (this is better
     * than simply clicking as on mobile the more realistic action would actually be tapping)
     * */

    public static void meTapWithWait(MobileElement mobileElement) throws InterruptedException {
//       mobileElement meElementToBeClickable(mobileElement);
//        new TouchAction(appDriver()).tap(TapOptions.tapOptions().withElement(element(mobileElement))).perform();
//        touchAction.tap(tapOptions().withElement(element(mobileElement))).perform();
        boolean flag = true;
        Thread.sleep(500);
        while(flag) {
            try {
                flag = appDriver().findElementByClassName("android.app.Dialog").isDisplayed();
            } catch (Exception e) {
                mobileElement.click();
                flag = false;
                System.out.println(e);
            }

        }

    }

    public static void meWaitForPageload() {
        boolean flag = true;
        while(flag) {
            try {
                Thread.sleep(500);
                flag = appDriver().findElementByClassName("goose-toast--unclickable").isDisplayed();
            } catch (Exception e) {
                flag = false;
                System.out.println(e);
            }

        }

    }

    public static void meWaitForPageClose() throws InterruptedException {
        boolean flag = true;
        int count = 0;
        while(flag && count < 50){
            Thread.sleep(500);
            if(appDriver().getWindowHandles().size() > 1){
                flag = true;
            } else{
                flag = false;
                count += count;
            }
        }

    }

    public static void meWaitForNewPage() throws InterruptedException {
        boolean flag = true;
        while(flag){
            Thread.sleep(500);
            if(appDriver().getWindowHandles().size() > 2){
                flag = false;
            } else{
                flag = true;
            }
        }

    }


    public static void meTap(MobileElement mobileElement){
        meElementToBeClickable(mobileElement);
            mobileElement.click();
    }

    /*
     *  long pressing on a Mobile element for two seconds, and then releasing your finger from it.
     * */
    public static void meLongPress(MobileElement mobileElement) {
        meElementToBeClickable(mobileElement);
        new TouchAction(appDriver()).longPress(longPressOptions().withElement(element(mobileElement))
                .withDuration(ofSeconds(2))).release().perform();
    }

    /*
     *  This method will do Swipe actions UP,DOWN, RIGHT & LEFT
     * @params - Directions(Up,DOWN,LEFT,RIGHT)
     * @Params - duration in Millis
     * */
    public static void meSwipe(DIRECTION direction, long duration) {
        Dimension size = appDriver().manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                new TouchAction(appDriver())
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                new TouchAction(appDriver())
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(appDriver())
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;

            case DOWN:
                startY = (int) (size.height * 0.70);
                endY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                new TouchAction(appDriver())
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;
        }
    }

    /*
     *  This method will help to do Swipe actions UP,DOWN, RIGHT & LEFT
     * @Params - MobileElement
     * @params - Direction(UP,DOWN,LEFT,RIGHT)
     * */
    public static void meSwipeElement(AndroidElement startMobileElement, AndroidElement offsetMobileElement){
            Point startLocation = startMobileElement.getCenter();
            Point endLocation = offsetMobileElement.getCenter();
            int xOffset = endLocation.getX();
            int yOffset = endLocation.getY();

            meElementToBeClickable(startMobileElement);

//            new TouchAction(appDriver()).press(element(startMobileElement))
//                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
//                    .moveTo(PointOption.point(location))
//                    .release().perform();

            new TouchAction(appDriver()).press(PointOption.point(startLocation))
                    .waitAction(WaitOptions.waitOptions(ofMillis(500)))
                    .moveTo(PointOption.point(xOffset+100,yOffset))
                    .release().perform();

    }

    /*
     *  This method will help to do Element Swipe actions LEFT
     * @Params - MobileElement
     * */
    public static void meSwipeElementLeft(AndroidElement startMobileElement) {
        Dimension size = appDriver().manage().window().getSize();
        Point startLocation = startMobileElement.getLocation();
        int endLocation = (int) ((startLocation.getX()) * 0.10);
//        int xOffset = endLocation.getX();
        int yOffset = startLocation.getY();
        meElementToBeClickable(startMobileElement);
        
        try {
            new TouchAction(appDriver()).press(PointOption.point(startLocation.x + 400, startLocation.y))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1500)))
                    .moveTo(PointOption.point(endLocation,yOffset))
                    .release().perform();
        } catch(Exception e){
            System.out.println(e);
        }


    }

    /*
     *  This method will help to do Scroll to End
     *  Uses FlingToEnd method and set the max swipes as 20
     * */

    public static void meScrollToEnd(){
//        appDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+elementId+"\"))").click();
       try {
           appDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToEnd(20);");
       } catch(Exception e){
           log.info(e);
       }
//          ".scrollIntoView(new UiObject2().findObject(BySelector.textContains('I have read, understood and agreed to the above statement. ')))
    }

    public static void meScrollToStart(){
        try {
            appDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToBeginning (10);");
        } catch(Exception e){
            log.info(e);
        }
    }




    /*
     * This method will wait for a given textfield MobileElement to be displayed, clear the textfield
     * if necessary (if ‘clearFirst’ is true), and then input a given String into the textfield.
     * */
    public static void meSendKeys(MobileElement element, String text, boolean clearFirst) {
        meElementIsDisplayed(element);
        if (clearFirst) meTap(element);
        element.sendKeys(text);
    }

    public static void meTapCalculatorButtons(char[] numberAsString, ArrayList<AndroidElement> calculatorView) {
//        List<MobileElement> buttons = calculatorView.findElementsByClassName("android.widget.Button");
        for (char ch :
                numberAsString) {
            inner: for (MobileElement element :
                    calculatorView) {
                char buttonName = element.getText().trim().charAt(0);
                if (Objects.equals(ch, buttonName)) {
                    meTap(element);
                    System.out.println("==========================>>>>>>>>> " + ch + " <<<<<<<<<<<=======================");
                    break inner;
                }
            }
        }
    }

    public static void mePressEnterButton(){
        appDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void mepressTabButton(){
        appDriver().pressKey(new KeyEvent(AndroidKey.TAB));
    }



    public String getScreenCapture() throws IOException {

        File srcFile = ((TakesScreenshot)appDriver()).getScreenshotAs(OutputType.FILE);
        String Destination = USER_DIR + "/target/cucumber-reports/screenshots/" + (System.currentTimeMillis()+".png");
        File destFile = new File(Destination);
        FileUtils.copyFile(srcFile,destFile);
        return Destination;

    }
}
