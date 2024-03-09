package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTable_StepDefinitions {
    @Then("User should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {
        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);//to get all List of String
        System.out.println("fruitsAndVegetables.get(3) = " + fruitsAndVegetables.get(3));//to get a specific
        //fruit throw its index number.
    }

    @Then("officer is able to see any data he wants")
    public void officer_Is_Able_To_SeeAnyDataHeWants(Map<String,String>DriverInfo) {
        System.out.println("Driver Info = " + DriverInfo);
        System.out.println("DriverInfo.get(\"name\") = " + DriverInfo.get("name"));
        System.out.println("DriverInfo.get(\"phone\") = " + DriverInfo.get("phone"));

    }
}
