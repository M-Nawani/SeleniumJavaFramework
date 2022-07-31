package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessage;

    public OrderConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateConfirmMessage() {
        String confirmMsg=confirmMessage.getText();
        return confirmMsg;
    }

}
