package com.tutorial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	@FindBy(xpath  = "//input[@placeholder='Search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//div[@id=\"search\"]/descendant::button")
	private WebElement searchButton;
	
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	public LoginPage selectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);

	}
	public RegisterPage selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
				
	}
	public void enterproductNameToSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
}
