package com.cydeo.Pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLibraryPage {

    public LoginLibraryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="inputEmail")
    public WebElement inputEmail;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement buttonSign;

    public void login(String username, String password){
        inputEmail.sendKeys(ConfigurationReader.getProperty(username));
        inputPassword.sendKeys(ConfigurationReader.getProperty(password));
        buttonSign.click();
    }
    public void loginFromFeature(String username, String password){
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSign.click();
    }
}
