package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(className = "page-heading")
    private WebElement pageHeader;

    public AccountCreationPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isPageHeaderDisplayed(){
        return action.isDisplayed(getDriver(),pageHeader);
    }
}
