package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "phone")
    private WebElement phoneTxt;

    @FindBy(name = "userName")
    private WebElement emailTxt;

    @FindBy(name = "email")
    private WebElement userNameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName, String phone, String email) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
        this.phoneTxt.sendKeys(phone);
        this.emailTxt.sendKeys(email);
    }

    public void enterLoginDetails(String userName, String password){
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void clickSubmit(){
        this.submitBtn.click();
    }
}
