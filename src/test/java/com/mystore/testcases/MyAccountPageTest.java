package com.mystore.testcases;
import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

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
    public void verifyWishlist(){
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignin();
        myAccountPage = loginPage.login(property.getProperty("username"), property.getProperty("password"));
        boolean result = myAccountPage.isWishlistDisplayed();
        Assert.assertTrue(result, "My wishlist is not displayed on the page");
    }

    @Test(groups = "Smoke")
    public void orderHistory(){
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignin();
        myAccountPage = loginPage.login(property.getProperty("username"), property.getProperty("password"));
        boolean result = myAccountPage.isOrderHistoryDisplayed();
        Assert.assertTrue(result, "Order History is not displayed on the page");
    }



}
