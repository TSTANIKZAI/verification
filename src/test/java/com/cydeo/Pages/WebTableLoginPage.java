package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement LoginButton;



    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropDown;


    //This method will log in below  credential
    //@username=Test  @Password: Tester
    public void login() {
        this.userName.sendKeys("Test");
        this.password.sendKeys("Tester");
        this.LoginButton.click();
    }
    //This method will log in with credentials that are provided in the method at the time of calling it
    //@parameter  user
    //@parameter  password

    public void login(String user, String password) {
        this.userName.sendKeys(user);
        this.password.sendKeys(password);
        this.LoginButton.click();
    }
}