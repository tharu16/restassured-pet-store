package petTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    final static Logger logger = Logger.getLogger(Class.class);
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;
    public static ExtentReports extent;

    @BeforeSuite
    public void setUpSuite(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUpMethod(Method method){
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = extent.createTest(descriptiveTestName);
    }

    @AfterMethod
    public void getResult(ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + "Test case passed", ExtentColor.GREEN));
        } else {
            test.skip(MarkupHelper.createLabel(result.getName() + "Test case Skipped", ExtentColor.AMBER));
        }
    }

    @AfterSuite
    public void tearDwonSuite(){
        extent.flush();
    }
}
