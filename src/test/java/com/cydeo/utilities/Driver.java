package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //create a private constructor to remove access to this object
    private Driver(){}
    /*we make the webdriver private, because we want to close access from outside the class to the object.
     * we are making it static, because we will use it in a static method.*/
   // private static WebDriver driver;// defualt value is null here ==null
    private static InheritableThreadLocal<WebDriver>driverpool=new InheritableThreadLocal<>();

    /*Create a re-usable utitlity method which will return the same driver instance once we call it.
     * if an instance doesnt exist, it will create first, and then it will always return same instance.*/
    public static WebDriver getDriver(){
        if(driverpool.get()==null){
            //we will read our browser type from configuration .properties file....
            //this way, we control which browser is opened from outside our code.
            String browserType=ConfigurationReader.getProperty("browser");
            //Depending on the browser type returned from the configuration properties....
            //switch statement will determine the "case", and open the matching browser.
            switch (browserType){
                case"chrome":
                    //WebDriverManager.Chromedriver().setup();
                    driverpool.set(new ChromeDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverpool.set(new FirefoxDriver());
                    driverpool.get().manage().window().maximize();
                    driverpool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverpool.get();
    }/*
    Create a new Driver.closeDriver(); it will use .quit() method to quit browser and then
    set the driver value back to null*/
    public static void closeDriver(){
        if(driverpool.get()!=null){
            /*This line will terminate the currently existing driver completly. it
             * will not exist going forward.*/
            driverpool.get().quit();
            //we assign the value back to "null" so that my "Singleton" can create a newer one if needed.
            driverpool.remove();
        }
    }
}
