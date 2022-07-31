package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(id="cgv")
    private WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public ShippingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void checkTheTerms(){
        action.click(getDriver(), terms);
    }

    public PaymentPage clickOnProceedToCheckOut() {
        action.click(getDriver(), proceedToCheckOutBtn);
        return new PaymentPage();
    }
}
