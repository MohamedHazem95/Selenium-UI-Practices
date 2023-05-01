package Utils.Listeners;

import static Utils.ExtentReports.ExtentManager.getExtentReports;
import static Utils.ExtentReports.ExtentTestManager.getTest;

import Utils.ExtentReports.ExtentManager;
import Utils.ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Tests.TestBase;

public class TestListener extends TestBase implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentManager.getExtentReports().flush();
    }

    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result){

            System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
            ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public void onTestFailedWithTimeout(ITestResult result) throws AssertionError{

        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
    }

}
