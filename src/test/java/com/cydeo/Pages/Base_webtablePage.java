package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base_webtablePage {
    public Base_webtablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.='Order']")
    public WebElement ordersButton;
    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement ViewAllOrders;
    @FindBy(xpath = "//button[.='View all products']")
    public WebElement ViewAllProducts;
    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logoutButton;
}
