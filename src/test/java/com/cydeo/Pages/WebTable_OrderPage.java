package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTable_OrderPage extends Base_webtablePage {
    public WebTable_OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;
    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement mastercardRadioButton;
    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioButton;
    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement AmericanExpressRadioButton;




    //for selecting a payment option through argument we need to create an object of String List
    //here we will select a common value the option for locating the webelements

    @FindBy(name = "card")
    public List<WebElement>cardTypes;
    //This is a special approach
    //and from here we need to go to utility class and create a method there



    @FindBy(xpath = "//option[@value='Familybea']")
    public WebElement familybea;
    @FindBy(xpath = "//option[@value='MoneyCog']")
    public WebElement moneycog;
    @FindBy(xpath = "//option[@value='Screenable']")
    public WebElement screenable;
    @FindBy(name = "quantity")
    public WebElement quantity;
    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculate;
    @FindBy(xpath = "//input[@placeholder='Full name of the customer']")
    public WebElement customername;
    @FindBy(name = "city")
    public WebElement city;
    @FindBy(name = "street")
    public WebElement streetname;
    @FindBy(name = "state")
    public WebElement state;
    @FindBy(name = "zip")
    public WebElement zip;
    @FindBy(name = "cardNo")
    public WebElement cardno;
    @FindBy(name = "cardExp")
    public WebElement expirydate;
    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processButton;


}
