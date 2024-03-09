package com.cydeo.utilities;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BrowserUtils {
    /* This method will accept int (int seconds) and
       execute Thread.sleep method for given duration
       Arg: int second.*/
    public  static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){
        //Return and store all window handles in a Set.
        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: "+Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        // Assert: Title contains “Etsy”
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals((expectedTitle),Driver.getDriver().getTitle());
    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    // wait for element matching the locator to be visible on the page
    // locator, time
    public static WebElement waitForVisibility(By locator,int time){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void swithcToWindow(String targetTitle){
        String origin=Driver.getDriver().getWindowHandle();
        for (String handle:Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }


    //move the mouse to given element
    public static void hover(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

//for return a list of string from a list of elements
    public static List<String>getElementsText(List<WebElement>list){
        List<String>elemText=new ArrayList<>();
        for (WebElement element:list) {
            elemText.add(element.getText());
        }
        return elemText;
    }

//verifies whether the element is displayed on page
    public static void verifyElementDisplayed(WebElement element){
        try {
            Assert.assertTrue("Element not visible: "+element, element.isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            Assert.fail("Element not found: "+element);
        }
    }

    /*
This method accepts WebElement target,
and waits for that WebElement not to be displayed on the page
 */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }
    /*
This method accepts String title,
and waits for that Title to contain given String value.
 */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }
    public static void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, "+ pixels +")");
    }


    public static void clickOption(String option){
        Driver.getDriver().findElement(By.linkText(option)).click();
    }
//This method just accepts drop down elements and returns a list <String> that contains all options values as String.
    public static List<String> dropdownOptions_as_String(WebElement dropdownElement) {
        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();
        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();
        //Looping through the List<WebElement>, getting all options texts and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {
            actualMonth_as_STRING.add(each.getText());
        }
        return actualMonth_as_STRING;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }
    }
}
