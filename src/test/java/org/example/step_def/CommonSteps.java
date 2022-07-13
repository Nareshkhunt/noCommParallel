package org.example.step_def;

import io.cucumber.java.en.Then;
import org.example.driver.DriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CommonSteps extends DriverManager {

    DriverManager driverManager = new DriverManager();

    @Then("^the url should contain with \"([^\"]*)\"$")
    public void the_url_should_contain_with(String expUrl) throws Throwable {
        String actualUrl= driverManager.getUrl();
        assertThat(actualUrl, containsString(expUrl));

    }
}
