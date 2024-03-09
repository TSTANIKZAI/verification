package com.cydeo.step_definitions;

import com.cydeo.Pages.GoogleSearch_ApplePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {
    GoogleSearch_ApplePage googleSearch_applePage=new GoogleSearch_ApplePage();
    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
    String actualTitle=Driver.getDriver().getTitle();
    String expectedTitle="Google";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("user search for apple")
    public void user_search_for_apple() {
        googleSearch_applePage.searchBox.sendKeys("apple"+Keys.ENTER);

    }
    @Then("user should see the {word} in the title")
    public void user_should_see_the_title(String expectedTitle) {

        BrowserUtils.verifyTitle(expectedTitle+" - Google Search");
    }

    @When("user search for {string}")
    public void user_search_for(String string) {
        googleSearch_applePage.searchBox.sendKeys(string);
        googleSearch_applePage.searchBox.sendKeys(Keys.ENTER);
    }
}
