package org.example.step_def;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.Registration;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class RegistrationSteps extends DriverManager {
    Registration registration = new Registration();
    List<Map<String, String>> data;

    @When("^I select gender \"([^\"]*)\"$")
    public void i_select_gender(String gender) throws Throwable {
        switch (gender){
            case "Male":
                 registration.selectMale();
                break;
            case "Female":
                registration.selectFemale();
                break;
            default:
                throw new IllegalAccessException("Unexpected gender");
        }
    }

    @When("^I enter following details to register$")
    public void i_enter_following_details_to_register(DataTable dataTable) throws Throwable {
        data =  dataTable.asMaps(String.class, String.class);
        System.out.println(data);
       registration.enterRegistrationDetails(
               data.get(0).get("firstName"),
               data.get(0).get("lastName") ,
               data.get(0).get("email"),
               data.get(0).get("password"),
               data.get(0).get("confirmPassword")
       );

    }

    @When("^I click on the \"([^\"]*)\" on registration page$")
    public void i_click_on_the_on_registration_page(String regSubmitButton) throws Throwable {
         registration.clickOnRegistrationButton();
    }

    @Then("^I should see \"([^\"]*)\" text on registration page$")
    public void i_should_see_text_on_registration_page(String expText) throws Throwable {
      String actualRegiSuccessText  =registration.getTextFromRegistrationResult();
        assertThat(actualRegiSuccessText,is(equalToIgnoringCase(expText)));
    }
}
