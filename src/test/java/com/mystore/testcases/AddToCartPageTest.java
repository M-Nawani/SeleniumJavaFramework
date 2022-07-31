package com.mystore.testcases;

import com.aventstack.extentreports.Status;
import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.mystore.utilities.ExtentReportSetup.extentTest;

public class AddToCartPageTest extends BaseClass {

    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void teardown(){
        getDriver().quit();
    }

    @Test(groups = {"Regression", "Sanity"})
    public void verifyProductIsDisplayed(){
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        extentTest.log(Status.INFO, "Product found");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.increaseQuantity("2");
        addToCartPage.updateSize();
        addToCartPage.clickAddToCartButton();
        extentTest.log(Status.INFO, "Product added to cart");
        boolean result = addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
    }
}

