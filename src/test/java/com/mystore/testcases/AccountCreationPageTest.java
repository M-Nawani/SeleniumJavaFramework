package com.mystore.testcases;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private AccountCreationPage accountCreationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void teardown(){
        getDriver().quit();
    }

    @Test(groups= "Sanity")
    public void verifyCreateAccountPageHeader(){
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignin();
        accountCreationPage = loginPage.createNewAccount("abcde@gco.com");
        boolean result = accountCreationPage.isPageHeaderDisplayed();
        Assert.assertTrue(result, "My account info header is not displayed");


    }
}


