package org.example.step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.ContactUs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactUsSteps extends DriverManager {
    ContactUs contactUs = new ContactUs();

    @Then("^I should see \"([^\"]*)\" on contact us page$")
    public void i_should_see_on_contact_us_page(String expText) throws Throwable {
        String getContactUsText= contactUs.getContactUsText();
        System.out.println(getContactUsText);
        assertThat(getContactUsText, is(equalToIgnoringCase(expText)));
    }


    @When("^I enter name \"([^\"]*)\" email \"([^\"]*)\" and enquiry \"([^\"]*)\"$")
    public void i_enter_name_email_and_enquiry(String name, String email, String enquiry) throws Throwable {
        contactUs.enterNameEmailAndEnquiry(name, email, enquiry);
    }

    @When("^I click on submit on Contact Us page$")
    public void i_click_on_submit_on_Contact_Us_page() throws Throwable {
        contactUs.clickOnSubmitBtn();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void i_should_see_message(String expText) throws Throwable {
        String actualSubmitText= contactUs.getSubmitBtnText();
        System.out.println(actualSubmitText);
        System.out.println(expText);
        assertThat(actualSubmitText, is(equalToIgnoringCase(expText)));
    }
}
