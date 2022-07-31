package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logoIcon;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public IndexPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnSignin(){
        action.click(getDriver(),signInButton);
        return new LoginPage();
    }

    public boolean isLogoDisplayed(){
        return action.isDisplayed(getDriver(),logoIcon);
    }
    public String getPageTitle(){
        return action.getTitle(getDriver());
     }

     public SearchResultPage searchProduct(String productName){
        action.type(searchField,productName);
        action.click(getDriver(),searchButton);
        return new SearchResultPage();
     }






}
