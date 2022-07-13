package org.example.step_def;

import io.cucumber.java.en.Then;
import org.example.driver.DriverManager;
import org.example.pages.ProductListPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class ProductListSteps extends DriverManager {
     DriverManager driverManager = new DriverManager();
     ProductListPage productListPage = new ProductListPage();

    @Then("^I should see \"([^\"]*)\" text on result page$")
    public void i_should_see_text_on_result_page(String expText) throws Throwable {
        String actualTextOnPlp=productListPage.getTextFromListPage();
        System.out.println(actualTextOnPlp);
        assertThat(actualTextOnPlp, is(equalToIgnoringCase(expText)));
    }

}
