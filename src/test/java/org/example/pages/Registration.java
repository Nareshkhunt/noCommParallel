package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @FindBy(id = "gender-male")
    private WebElement maleCheckBox;

    @FindBy(id = "gender-female")
    private WebElement femaleCheckBox;

    @FindBy(id = "register-button")
    private WebElement registrationButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameInputBox;

    @FindBy(id = "LastName")
    private WebElement lastNameInputBox;

    @FindBy(id = "Email")
    private WebElement emailInputBox;

    @FindBy(id = "Password")
    private WebElement passwordInputBox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInputBox;

    @FindBy(css = "div[class='result']")
    private WebElement registrationSuccessText;

    public void selectMale(){
        maleCheckBox.click();
    }

    public void selectFemale(){
        femaleCheckBox.click();
    }

    public void clickOnRegistrationButton() {
        registrationButton.click();
    }

    public String getTextFromRegistrationResult() {
        return registrationSuccessText.getText();
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email, String password, String confirmPassword) {
      firstNameInputBox.clear();
      firstNameInputBox.sendKeys(firstName);
      lastNameInputBox.clear();
      lastNameInputBox.sendKeys(lastName);
      emailInputBox.clear();
      int myRandomNumber = driverManager.generateRandomNumber();
      emailInputBox.sendKeys(myRandomNumber+email);
      passwordInputBox.clear();
      passwordInputBox.sendKeys(password);
      confirmPasswordInputBox.clear();
      confirmPasswordInputBox.sendKeys(confirmPassword);
    }


}
