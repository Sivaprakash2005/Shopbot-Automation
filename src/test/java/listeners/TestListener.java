package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getReportObject();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        System.out.println("TEST STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("TEST PASSED");
        System.out.println("TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String path = ScreenshotUtil.captureScreenshot(BaseTest.driver,result.getName());
        try {
            test.addScreenCaptureFromPath(path);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("TEST FAILED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("EXTENT REPORT GENERATED");
    }
}