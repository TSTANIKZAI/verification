package com.cydeo.step_definitions;

import com.cydeo.Pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Bing_StepDefinitions {

    BingSearchPage bingSearchPage = new BingSearchPage();

    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {

        Driver.getDriver().get("https://www.bing.com");

    }
    @When("user enters orange in the Bing search box")
    public void user_enters_orange_in_the_bing_search_box() {
        BrowserUtils.sleep(2);
        bingSearchPage.searchBox.sendKeys("orange" + Keys.ENTER);
    }

    @Then("user should see orange in the title")
    public void userShouldSeeOrangeInTheTitle() {
    BrowserUtils.verifyTitleContains("orange - Search");

    }

    @When("user enters {string} in the Bing search box")
    public void userEntersInTheBingSearchBox(String searchText) {
     bingSearchPage.searchButton.sendKeys(searchText);
     bingSearchPage.searchBox.sendKeys(Keys.ENTER);

    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitleContains(expectedTitle);
    }
}