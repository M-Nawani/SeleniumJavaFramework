package com.mystore.utilities;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.baseclass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerImplementation extends ExtentReportSetup implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case " + methodName + " PASSED";
            Markup mark = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            extentTest.log(Status.PASS, mark);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case " + methodName + " FAILED";
            Markup mark = MarkupHelper.createLabel(logText, ExtentColor.RED);
            extentTest.log(Status.FAIL, mark);
            extentTest.log(Status.FAIL, result.getThrowable());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = new Date();
            String actualDate = format.format(date);
            String screenshotPath = System.getProperty("user.dir")+ "/test-results/Screenshots/Screenshot_"+actualDate+".jpeg";
            File srcFile = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile =new File(screenshotPath);
            try {
                FileUtils.copyFile(srcFile,destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                extentTest.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if(result.getStatus()==ITestResult.SKIP){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case " +methodName + " SKIPPED";
            Markup mark = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
            extentTest.log(Status.SKIP, mark);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportSetup.setupReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportSetup.closeReport();
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryManager.class);
    }
}
