package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(xpath = "//a[contains(@title,'My wishlists')]")
    private WebElement myWishlistsButton;

    @FindBy(xpath = "//a[contains(@title, 'Orders')]" )
    private WebElement orderHistoryButton;

    public MyAccountPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isWishlistDisplayed(){
        return action.isDisplayed(getDriver(),myWishlistsButton);
    }

    public boolean isOrderHistoryDisplayed(){
        return action.isDisplayed(getDriver(), orderHistoryButton);
    }

    public String getCurrentUrl(){
        return action.getCurrentURL(getDriver());
    }

}
