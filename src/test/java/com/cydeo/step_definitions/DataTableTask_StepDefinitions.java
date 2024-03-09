package com.cydeo.step_definitions;

import com.cydeo.Pages.DropDownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTableTask_StepDefinitions {

    @Given("User is on the dropdown page of practice tool")
    public void user_is_on_the_dropdown_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    DropDownPage dropDownPage=new DropDownPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String>expectedMonths) {
       List<String>actualMonths= BrowserUtils.dropdownOptions_as_String(dropDownPage.MonthButton);
        Assert.assertEquals(actualMonths,expectedMonths);
    }
}
