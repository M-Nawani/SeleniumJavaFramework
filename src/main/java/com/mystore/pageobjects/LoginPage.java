package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    ActionDriver action = new ActionDriver();

    @FindBy(id = "email")
    private WebElement regsiteredEmail;

    @FindBy(id = "passwd")
    private WebElement registeredPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement siginButton;

    @FindBy(id = "email_create")
    private WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[contains(@title,'Recover your')]")
    private WebElement forgotPasswordLink;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MyAccountPage login(String username, String password){
        action.type(regsiteredEmail,username);
        action.type(registeredPassword, password);
        action.click(getDriver(), siginButton);
        return new MyAccountPage();
    }

    public AddressPage loginAtCheckout(String username, String password){
        action.type(regsiteredEmail,username);
        action.type(registeredPassword, password);
        action.click(getDriver(), siginButton);
        return new AddressPage();
    }

    public AccountCreationPage createNewAccount(String emailid){
        action.type(createEmail,emailid);
        action.click(getDriver(),createAccountButton);
        return new AccountCreationPage();
    }

}
