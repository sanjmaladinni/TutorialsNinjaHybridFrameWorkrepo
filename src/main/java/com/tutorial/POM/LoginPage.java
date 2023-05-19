package com.tutorial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="input-email" )
	private WebElement emailAddressField;
	
	@FindBy(id ="input-password" )
	private WebElement passwordField;
	
	@FindBy(xpath  ="//input[@value='Login']" )
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,\"alert-dismissible\")]")
	private WebElement emailPasswordNotMatchingWarring;
	
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPasswordAddress(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String retriveEmailPasswordNotMatchingWarningMessageText() {
	String warningText	= emailPasswordNotMatchingWarring.getText();
	return warningText;
	}
	
}
