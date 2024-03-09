package com.cydeo.step_definitions;

import com.cydeo.Pages.Walmart_purchasing;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class walmart_StepDefinitions {
   Walmart_purchasing walmart_purchasing=new Walmart_purchasing();
    @Given("user is on the Bestbuy page")
    public void userIsOnTheBestbuyPage() {

        Driver.getDriver().get("https://bestbuy.com");
    }

    @When("user should search for vacuum")
    public void user_should_search_for_vacuum() {

        BrowserUtils.sleep(2);
        walmart_purchasing.searchBox.sendKeys("vacuum");
        walmart_purchasing.searchButton.click();

    }
    @Then("user should see the bestbuy title")
    public void user_should_see_the_bestbuy_title() {

        BrowserUtils.sleep(5);
    BrowserUtils.verifyTitleContains("vacuum");

    }

}
