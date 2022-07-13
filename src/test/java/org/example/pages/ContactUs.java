package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends DriverManager {

    @FindBy(xpath ="//div[@class='page-title']/h1")
    private WebElement pageTitle;

    @FindBy(id = "FullName")
    private WebElement yourName;

    @FindBy(id = "Email")
    private WebElement yourEmail;

    @FindBy(id = "Enquiry")
    private WebElement yourEnquiry;

    @FindBy(xpath = "//*[@name='send-email']")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@class='result']")
    private WebElement submitBtnText;


    public String getContactUsText(){

        return pageTitle.getText();}

    public void enterNameEmailAndEnquiry(String name,String email, String enquiry) {
        yourName.sendKeys(name);
        yourEmail.sendKeys(email);
        yourEnquiry.sendKeys(enquiry);


    }
    public void clickOnSubmitBtn(){
        submitBtn.click();
    }
    public String getSubmitBtnText(){
        return submitBtnText.getText();
    }

}
