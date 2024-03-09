package com.cydeo.step_definitions;

import com.cydeo.Pages.LoginLibraryPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class LoginLibrary_StepDefinitions {
    LoginLibraryPage loginLibraryPage=new LoginLibraryPage();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
    //loginLibraryPage.inputEmail.sendKeys(ConfigurationReader.getProperty("lib22_user")+ Keys.TAB);
    //loginLibraryPage.inputPassword.sendKeys(ConfigurationReader.getProperty("lib22_pass")+Keys.TAB);
    //loginLibraryPage.loginButton.click();
        loginLibraryPage.login("lib22_user","lib22_pass");
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        BrowserUtils.waitForTitleContains("Library");
        BrowserUtils.verifyTitle("Library");

    }
    @When("I login as a student")
    public void i_login_as_a_student() {
    loginLibraryPage.login("student55_user","student55_pass");
    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {

    }
}