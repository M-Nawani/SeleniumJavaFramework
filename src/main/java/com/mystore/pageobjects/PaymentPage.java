package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {
    ActionDriver action = new ActionDriver();
    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    private WebElement payByCheckMethod;

    public PaymentPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderSummaryPage clickOnPaymentMethod() throws Throwable {
        action.click(getDriver(), bankWireMethod);
        return new OrderSummaryPage();
    }
}
