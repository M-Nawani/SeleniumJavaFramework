package com.mystore.testcases;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void teardown(){
        getDriver().quit();
    }

    @Test(dataProvider ="getCredentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
    public void verifyLogin(String username, String password){
        IndexPage indexPage = new IndexPage();
        LoginPage loginPage = indexPage.clickOnSignin();
        MyAccountPage myAccountPage = loginPage.login(username, password);
        String actualURL = myAccountPage.getCurrentUrl();
        String expectedURL="http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(actualURL, expectedURL);
    }
}
