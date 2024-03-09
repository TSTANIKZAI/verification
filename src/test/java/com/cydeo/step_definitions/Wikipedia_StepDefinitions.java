package com.cydeo.step_definitions;

import com.cydeo.Pages.WikiResultPage;
import com.cydeo.Pages.WikiSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class Wikipedia_StepDefinitions {
        WikiSearchPage wikiSearchPage = new WikiSearchPage();
        WikiResultPage wikiResultPage=new WikiResultPage();

        @Given("User is on Wikipedia home page")
        public void userIsOnWikipediaHomePage() {
                Driver.getDriver().get("https://www.wikipedia.org");
        }

        @When("User types {string} in the wiki search box")
        public void userTypesInTheWikiSearchBox(String searchValue) {
                wikiSearchPage.searchBox.sendKeys(searchValue);
        }

        @And("User clicks wiki search button")
        public void user_Clicks_Wiki_SearchButton() {
                wikiSearchPage.searchButton.click();
        }

        @Then("User sees {string} is in the wiki title")
        public void userSeesIsInTheWikiTitle(String expectedInTitle) {
                BrowserUtils.verifyTitleContains(expectedInTitle);
        }

        @Then("User sees {string} is in the main header")
        public void userSeesIsInTheMainHeader(String expectedText) {

                String actualHeaderText=wikiResultPage.mainHeader.getText();
                Assert.assertEquals(actualHeaderText,expectedText);
        }

        @Then("User sees {string} is in the image header")
        public void userSeesIsInTheImageHeader(String expectedText) {
               // String actualText=wikiResultPage.imageHeader.getText();
              //  Assert.assertEquals(actualText,expectedText);
                //or we use all in one line as below
               Assert.assertEquals(wikiResultPage.imageHeader.getText(),expectedText);
        }
}
