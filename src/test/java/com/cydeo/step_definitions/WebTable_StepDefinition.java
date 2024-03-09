package com.cydeo.step_definitions;

import com.cydeo.Pages.Base_webtablePage;
import com.cydeo.Pages.WebTableLoginPage;
import com.cydeo.Pages.WebTableViewOrder_Page;
import com.cydeo.Pages.WebTable_OrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.google.common.collect.Table;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class WebTable_StepDefinition {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("User is on the Web Table app login page")
    public void User_is_on_the_Web_Table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    @When("User Enter username: Test")
    public void User_enter_username_test() {
        webTableLoginPage.userName.sendKeys("Test" + Keys.TAB);
    }

    //Parameterized only Username and Password
    @When("User Enter username {string}")
    public void userEnterUsername(String userName) {

        webTableLoginPage.userName.sendKeys(userName + Keys.TAB);
    }

    @And("User Enter password {string}")
    public void userEnterPassword(String password) {

        webTableLoginPage.password.sendKeys(password + Keys.TAB);
    }

    @And("User Enter password: Tester")
    public void User_enter_password_tester() {

        webTableLoginPage.password.sendKeys("Tester" + Keys.TAB);
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {

        webTableLoginPage.LoginButton.click();
    }

    @Then("Verify URL:")
    public void verify_url() {
        BrowserUtils.sleep(1);
        String expectedUrl = "https://web-table-2.cydeo.com/orders";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Given("user is already logged in to The Web table app")
    public void userIsAlreadyLoggedInToTheWebTableApp() {
    Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    //then call the login method from WebtableLoginpage
    webTableLoginPage.login();
    }
    //we called the object here because we need to refference for to steps
    WebTable_OrderPage webTable_orderPage=new WebTable_OrderPage();
    @When("user is on the Order page")
    public void userIsOnTheOrderPage() {
        webTable_orderPage.ordersButton.click();
    }

    @Then("user sees below options under product dropdown")
    public void userSeesBelowOptionsUnderProductDropdown(List<String>expectedOptions) {
        List<String> actualOptions=BrowserUtils.dropdownOptions_as_String(webTable_orderPage.productDropdown);
        Assert.assertEquals(actualOptions,expectedOptions);
    }


    @Then("user sees Mastercard as enabled payment option")
    public void userSeesMastercardAsEnabledPaymentOption() {
    webTable_orderPage.mastercardRadioButton.click();
    }

    @Then("user sees Visa as enabled payment option")
    public void userSeesVisaAsEnabledPaymentOption() {
    webTable_orderPage.visaRadioButton.click();
    }

    @Then("user sees American Express as enabled payment option")
    public void userSeesAmericanExpressAsEnabledPaymentOption() {
        webTable_orderPage.AmericanExpressRadioButton.click();

    }

    @Then("user select the Quantity {string}")
    public void userSelectTheQuantity(String Quantity) {
        webTable_orderPage.quantity.clear();
        webTable_orderPage.quantity.sendKeys(Quantity);
    }

    @Then("user calculate the total amount")
    public void userCalculateTheTotalAmount() {
        webTable_orderPage.calculate.click();
    }

    @Then("user enters Customer name {string}")
    public void userEntersCustomerName(String customername) {
        webTable_orderPage.customername.sendKeys(customername);

    }

    @Then("user enter the Street {string} City {string} State {string} Zipcode {string}")
    public void userEnterTheStreetCityStateZipcode(String street, String city, String state, String zip) {
        webTable_orderPage.streetname.sendKeys(street);
        webTable_orderPage.city.sendKeys(city);
        webTable_orderPage.state.sendKeys(state);
        webTable_orderPage.zip.sendKeys(zip);

    }

    @Then("user select the Payment option {string} and Card No {string}")
    public void userSelectThePaymentOptionAndCardNo(String expectedCardType, String cardno) {
        webTable_orderPage.mastercardRadioButton.click();
        BrowserUtils.clickRadioButton(webTable_orderPage.cardTypes,expectedCardType);
        webTable_orderPage.cardno.sendKeys(cardno);
    }

    @Then("user enters Expire date {string} of the card")
    public void userEntersExpireDateOfTheCard(String expiredate) {
        webTable_orderPage.expirydate.sendKeys(expiredate);
    }

    @Then("user clicks to Process Order")
    public void userClicksToProcessOrder() {
        webTable_orderPage.processButton.click();
    }

    @Then("user is see a new order {string} in the table on view all orders page")
    public void userIsSeeANewOrderInTheTableOnViewAllOrdersPage(String expectedName) {
        WebTableViewOrder_Page webTableViewOrderPage=new WebTableViewOrder_Page();
        String actualName=webTableViewOrderPage.newCustomerCell.getText();
        Assert.assertEquals(actualName,expectedName);
    }

}
