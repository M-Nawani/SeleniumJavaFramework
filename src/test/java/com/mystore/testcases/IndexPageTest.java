package com.mystore.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.mystore.utilities.ExtentReportSetup.extentTest;

public class IndexPageTest extends BaseClass {
    private IndexPage indexPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void teardown(){
        getDriver().quit();
    }
    
    @Test(groups = "Smoke")
    public void verifyLogo(){
        extentTest.log(Status.INFO, "User on login page");
        indexPage= new IndexPage();
        boolean result = indexPage.isLogoDisplayed();
        Assert.assertTrue(result, "Logo is not displayed");
    }
    
    @Test(groups = "Smoke")
    public void verifyPageTitle(){
        String actualTitle = indexPage.getPageTitle();
        extentTest.log(Status.INFO, "User on login page");
        Assert.assertEquals(actualTitle, "My Store");

    }
}
