package com.tutorial.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;

	@FindBy(xpath = "//input[@type=\"button\"]/following-sibling::p")
	private WebElement noProductMessage;

	public boolean displayStatusOfHpValidProduct() {
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
	}

	public String retrieveNoProductMessage() {
		String text = noProductMessage.getText();
		return text;
	}
}
