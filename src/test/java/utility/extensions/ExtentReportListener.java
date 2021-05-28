package utility.extensions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import static utility.appium.Driver.appDriver;

public class ExtentReportListener {

    public AndroidDriver driver = appDriver();
    public static ExtentHtmlReporter report = null;
    public static ExtentReports extent = null;
    public static ExtentTest test = null;
   public static MobileElementExtensions screenCapture = new MobileElementExtensions();

    public static ExtentReports setUp() {
        String reportLocation = "./target/cucumber-reports/Extent_Report.html";
        report = new ExtentHtmlReporter(reportLocation);
        report.config().setDocumentTitle("Automation Test Report");
        report.config().setReportName("Automation Test Report");
        report.config().setTheme(Theme.STANDARD);
        System.out.println("Extent Report location initialized . . .");
        report.start();
        extent = new ExtentReports();
        extent.attachReporter(report);
//        extent.setSystemInfo("Application", "InMotionLab");
//        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        System.out.println("System Info. set in Extent Report");
        return extent;
    }

    public static void testStepHandle(String teststatus, AndroidDriver driver,ExtentTest extenttest,Throwable throwable) {
        switch (teststatus) {
            case "FAIL":
                extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
                extenttest.error(throwable.fillInStackTrace());

                try {
                    String image = screenCapture.getScreenCapture();
                    extenttest.addScreenCaptureFromPath(image);
                } catch ( IOException e) {
                    e.printStackTrace();
                }

                break;

            case "PASS":
                extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
                break;

            default:
                break;
        }
    }
}
