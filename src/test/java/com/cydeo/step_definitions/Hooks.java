package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*in this class we will be able to create a pre- and post-conditions for all the scenarios
 and even steps.*/
public class Hooks {

    @Before
    public void setup(){
        System.out.println("---->@Before: RUNNING BEFORE EACH SCENARIO");
        BrowserUtils.sleep(1);
}
@After
    public void tearDownMethod(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    System.out.println("----> @After: RUNNING AFTER EACH SENARIO");
    BrowserUtils.sleep(2);
    Driver.closeDriver();
}
//
    public void setupStep(){
   // System.out.println("-----> @BeforeStep: Running before each step!");
}
}
