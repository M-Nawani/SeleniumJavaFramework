package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    ActionDriver action= new ActionDriver();

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShippingPage clickOnCheckOut() throws Throwable {
        action.click(getDriver(), proceedToCheckOut);
        return new ShippingPage();
    }
}
