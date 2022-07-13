package org.example;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.driver.DriverManager;

public class Hooks extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() throws IllegalAccessException {
       driverManager.runOnLocalBrowser();
//        driverManager.runInHeadlessBrowser();
        driverManager.goToUrl();
        driverManager.maxBrowser();
        driverManager.applyImlicitWait();

    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            driverManager.takeScreenshot(scenario);
        }
        driverManager.closeBrowser();
    }

}
