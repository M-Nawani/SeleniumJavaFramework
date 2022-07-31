package com.mystore.testcases;

import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;

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
    public void verifyProductIsDisplayed(){
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("T-shirt");
        boolean result = searchResultPage.isProductDisplayed();
        Assert.assertTrue(result, "Search produced no results or product is not visible on the Page");

    }
}
