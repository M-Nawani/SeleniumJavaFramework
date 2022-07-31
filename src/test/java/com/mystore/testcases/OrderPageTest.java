package com.mystore.testcases;
import com.mystore.baseclass.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {
    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression")
    public void verifyTotalPrice(){
        index= new IndexPage();
        searchResultPage=index.searchProduct("t-shirt");
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.increaseQuantity("2");
        addToCartPage.updateSize();
        addToCartPage.clickAddToCartButton();
        orderPage=addToCartPage.clickOnCheckOut();
        Double unitPrice=orderPage.getUnitPrice();
        Double totalPrice=orderPage.getTotalPrice();
        Double totalExpectedPrice=(unitPrice*(Double.parseDouble("2")))+2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }
}
