package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    ActionDriver action = new ActionDriver();

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement searchResult;

    public SearchResultPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductDisplayed(){
        return action.isDisplayed(getDriver(),searchResult);
    }

    public AddToCartPage clickOnProduct(){
        action.click(getDriver(),searchResult);
        return new AddToCartPage();
    }
}
