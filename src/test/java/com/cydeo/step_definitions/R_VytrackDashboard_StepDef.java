package com.cydeo.step_definitions;

import com.cydeo.Pages.R_VytrackDashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class R_VytrackDashboard_StepDef {
    R_VytrackDashboardPage r_vytrackDashboardPage=new R_VytrackDashboardPage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String>expectedTopModules) {
     List<String>actualTopModules=new ArrayList<>();
        for (WebElement eachTopModule:r_vytrackDashboardPage.allTopModules) {
            actualTopModules.add(eachTopModule.getText());
        }
        Assert.assertEquals(expectedTopModules,actualTopModules);
    }
}
