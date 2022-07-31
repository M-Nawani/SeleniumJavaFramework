package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBy(id = "group_1")
    private WebElement productSize;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void increaseQuantity(String noofproducts){
        action.type(productQuantity,"2");
    }

    public void updateSize(){
        action.selectByValue(productSize,"2");
    }

    public void clickAddToCartButton(){
        action.click(getDriver(),addToCartButton);
    }

    public boolean validateAddtoCart(){
        action.fluentWait(getDriver(),addToCartMessage, 10);
        return action.isDisplayed(getDriver(), addToCartMessage);
    }

    public OrderPage clickOnCheckOut(){
        action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
        action.JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderPage();
    }


}
