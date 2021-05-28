package utility.extensions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.utils.ExceptionUtil;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
//import  com.vimalselvam.cucumber.listener.Reporter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static utility.appium.Driver.appDriver;

public class Verify {


    protected Verify() {
        // hide constructor
    }

    static public void verifyTrue(boolean condition, String message,ExtentTest logInfo) {
        try{
            Assert.assertTrue(condition, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyTrue(boolean condition, ExtentTest logInfo) {
        try{
            Assert.assertTrue(condition);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyFalse(boolean condition, String message,ExtentTest logInfo) {
        try{
            Assert.assertFalse(condition, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyFalse(boolean condition,ExtentTest logInfo) {
        try{
            Assert.assertFalse(condition);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void fail(String message, ExtentTest logInfo,Throwable realCause) {
        try{
            Assert.fail(message, realCause);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void fail(String message,ExtentTest logInfo) {
        try{
            Assert.fail(message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void fail(ExtentTest logInfo) {
        try{
            Assert.fail();
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Object actual, Object expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Object actual, Object expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(String actual, String expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }

    }

    static public void verifyEquals(String actual, String expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(double actual, double expected, double delta, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, delta, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(double actual, double expected, double delta,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, delta);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(float actual, float expected, float delta, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, delta, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(float actual, float expected, float delta,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, delta);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(long actual, long expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(long actual, long expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(boolean actual, boolean expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(boolean actual, boolean expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(byte actual, byte expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(byte actual, byte expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(char actual, char expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(char actual, char expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(short actual, short expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(short actual, short expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(int actual,  int expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(int actual, int expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotNull(Object object,ExtentTest logInfo) {
        try{
            Assert.assertNotNull(object);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotNull(Object object, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotNull(object,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNull(Object object,ExtentTest logInfo) {
        try{
            Assert.assertNull(object);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNull(Object object, String message,ExtentTest logInfo) {
        try{
            Assert.assertNull(object,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifySame(Object actual, Object expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertSame(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifySame(Object actual, Object expected,ExtentTest logInfo) {
        try{
            Assert.assertSame(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotSame(Object actual, Object expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotSame(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotSame(Object actual, Object expected,ExtentTest logInfo) {
        try{
            Assert.assertNotSame(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Collection<?> actual, Collection<?> expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Collection<?> actual, Collection<?> expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Iterator<?> actual, Iterator<?> expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Iterator<?> actual, Iterator<?> expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Iterable<?> actual, Iterable<?> expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Iterable<?> actual, Iterable<?> expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Object[] actual, Object[] expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEqualsNoOrder(Object[] actual, Object[] expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEqualsNoOrder(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Object[] actual, Object[] expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEqualsNoOrder(Object[] actual, Object[] expected,ExtentTest logInfo) {
        try{
            Assert.assertEqualsNoOrder(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(final byte[] actual, final byte[] expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(final byte[] actual, final byte[] expected, final String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Set<?> actual, Set<?> expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Set<?> actual, Set<?> expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyEquals(Map<?, ?> actual, Map<?, ?> expected,ExtentTest logInfo) {
        try{
            Assert.assertEquals(actual,expected);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    public static void verifyNotEquals(Object actual1, Object expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    public static void verifyNotEquals(Object actual1, Object actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(String actual1, String actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(String actual1, String actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(long actual1, long actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(long actual1, long actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(boolean actual1, boolean actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(boolean actual1, boolean actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(byte actual1, byte actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(byte actual1, byte actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(char actual1, char actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(char actual1, char actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(short actual1, short actual2, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(short actual1, short actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(int actual1, int expected, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,expected,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static void verifyNotEquals(int actual1, int actual2,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotEquals(float actual1, float actual2, float delta, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,delta,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotEquals(float actual1, float actual2, float delta,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,delta);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotEquals(double actual1, double actual2, double delta, String message,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,delta,message);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    static public void verifyNotEquals(double actual1, double actual2, double delta,ExtentTest logInfo) {
        try{
            Assert.assertNotEquals(actual1,actual2,delta);
        }catch(AssertionError e){
            addToErrorBuffer(e,logInfo);
        }
    }

    private static void addToErrorBuffer(AssertionError e, ExtentTest logInfo){
         AndroidDriver driver = appDriver();
//        try{
//
//            MobileElementExtensions screenCapture = new MobileElementExtensions();
//            String image = screenCapture.getScreenCapture();
//
//
////            Reporter.addScenarioLog( "--------" + ExceptionUtil.getStackTrace(e));
////            Reporter.addScreenCaptureFromPath(image);
//
//        }catch(NullPointerException | IOException ex){
//            ex.printStackTrace();
//
//        }

        ExtentReportListener.testStepHandle("FAIL",driver,logInfo,e);

    }
}
