package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {

    @FindBy(css = ".page-title")
    private WebElement welcomeSignInText;

    @FindBy(id = "Email")
    private WebElement emailInputText;

    @FindBy(id = "Password")
    private WebElement passwordInputText;

    @FindBy(css = ".login-button")
    private WebElement logInSubmitButton;

    @FindBy(css = ".ico-logout")
    private WebElement logOutButton;

    public String getWelcomeSignInText(){
       return welcomeSignInText.getText();
    }

    public void enterEmailAndPassword(String email, String password) {
          emailInputText.clear();
          emailInputText.sendKeys(email);
          passwordInputText.clear();
          passwordInputText.sendKeys(password);
    }

    public void clickOnLoginSubmitButton(){
        logInSubmitButton.click();
    }

    public boolean checkLogOutButtonIsDisplayed(){
        return logOutButton.isDisplayed();
    }
}
