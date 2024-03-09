package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Walmart_purchasing {
    public Walmart_purchasing(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(id = "gh-search-input")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

}
