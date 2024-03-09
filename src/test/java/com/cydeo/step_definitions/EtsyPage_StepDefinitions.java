package com.cydeo.step_definitions;

import com.cydeo.Pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyPage_StepDefinitions {
    EtsySearchPage etsySearchPage=new EtsySearchPage();
    @Given("User is on the etsy home page")
    public void userIsOnTheEtsyHomePage() {
        Driver.getDriver().get("https://www.etsy.com/");
    }
    @Then("User sees title is as expected.")
    public void user_sees_title_is_as_expected() {
        BrowserUtils.sleep(1);
       String ExpectedTitle="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
       String ActualTitle=Driver.getDriver().getTitle();
    }

    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        BrowserUtils.sleep(1);
    etsySearchPage.searchText.sendKeys("Wooden Spoon");
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        etsySearchPage.clickButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {
        String expectedTitle="Wooden spoon - Etsy";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String searchValue) {
      etsySearchPage.searchText.sendKeys(searchValue);
    }
    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String expectedInTitle) {
    BrowserUtils.verifyTitleContains(expectedInTitle);
    }
}
