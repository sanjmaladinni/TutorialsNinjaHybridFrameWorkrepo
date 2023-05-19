package com.tutorial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	


	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder=\"E-Mail\"]")
	private WebElement email;
	
	@FindBy(xpath = "//input[@placeholder=\"Telephone\"]")
	private WebElement telephone;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@placeholder=\"Password Confirm\"]")
	private WebElement passwordConfirm;
	
	@FindBy(xpath = "//input[@name=\"agree\"]")
	private WebElement agree;
	
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	private WebElement Continue;
	
	@FindBy(xpath = "//label/input[@name=\"newsletter\"][@value=\"0\"]")
	private WebElement yesNewLatterOption;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement duplicateEmailAddressWarningMasg;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id=\"input-firstname\"]/following-sibling::div[@class=\"text-danger\"]")
	private WebElement firstNameWorning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div[@class='text-danger']")
	private WebElement lastNameWorning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div[@class='text-danger']")
	private WebElement emailAddressWorning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div[@class='text-danger']")
	private WebElement telephoneNumberWorning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div[@class='text-danger'] ")
	private WebElement passwordWorning;
	
	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}
	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}
	public void enterEmailAddress(String Email) {
		email.sendKeys(Email);
	}
	public void enterTelephoneNumber(String Telephone) {
		telephone.sendKeys(Telephone);
	}
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}
	public void enterConfirmPassword(String ConfirmPassword) {
		passwordConfirm.sendKeys(ConfirmPassword);
	}
	public void selectPrivacyPolicy() {
		agree.click();
	}
	public AccountSuccessPage clickOnContinueButton() {
		Continue.click();
		return new AccountSuccessPage(driver);
	}
	public void selectYesNewsLeterOption() {
		yesNewLatterOption.click();
	}
	public String retrieveDuplicateMailAddressWarning() {
	String duplicateEmailWarningText  =	duplicateEmailAddressWarningMasg.getText();
	return duplicateEmailWarningText;
	}
	public String retrievePrivacyPolicyWarning() {
		String PrivacyPolicyWarningText  =	privacyPolicyWarning.getText();
		return PrivacyPolicyWarningText;
		}
	public String retrieveFirstNameWarning() {
		String firstNameWarningText  =	firstNameWorning.getText();
		return firstNameWarningText;
		}
	public String retrieveLastNameWarning() {
		String lastNameWarningText  =	lastNameWorning.getText();
		return lastNameWarningText;
		}
	public String retrieveEmailAddressWarning() {
		String EmailAddressWarningText  =	emailAddressWorning.getText();
		return EmailAddressWarningText;
		}
	public String retrieveTelephoneNumberWorning() {
		String telephoneNumberWorningWarningText  =	telephoneNumberWorning.getText();
		return telephoneNumberWorningWarningText;
		}
	public String retrievePasswordWorning() {
		String passwordWorningWarningText  =	passwordWorning.getText();
		return passwordWorningWarningText;
		}
	
}
