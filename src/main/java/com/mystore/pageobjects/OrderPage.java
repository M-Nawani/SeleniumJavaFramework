package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    ActionDriver action = new ActionDriver();

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    private WebElement unitPriceText;

    @FindBy(xpath = "//span[@id= 'total_price']")
    private WebElement totalPriceText;

   @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
   private WebElement proceedToCheckoutButton;

   public OrderPage(){
       PageFactory.initElements(getDriver(), this);
   }

   public double getUnitPrice(){
       String unitprice = unitPriceText.getText();
       String formatted_unitprice = unitprice.replaceAll("[^a-zA-Z0-9]","");
       double unit_price = Double.parseDouble(formatted_unitprice);
       return unit_price/100;
   }

   public double getTotalPrice(){
       String totalprice = totalPriceText.getText();
       String formatted_totalprice = totalprice.replaceAll("[^a-zA-Z0-9]","");
       double total_price = Double.parseDouble(formatted_totalprice);
       return total_price/100;
   }

   public LoginPage clickOnCheckoutButton(){
       action.click(getDriver(),proceedToCheckoutButton);
       return new LoginPage();
   }
}
