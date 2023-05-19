package com.tutotiarlsninjs.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorial.base.BaseClass;
import com.tutorial.POM.AccountSuccessPage;
import com.tutorial.POM.HomePage;
import com.tutorial.POM.RegisterPage;
import com.tutorials.utils.Utilities;

public class RegisterTest extends BaseClass {

	public WebDriver driver;
	RegisterPage rg;
	AccountSuccessPage as;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage hm = new HomePage(driver);
		hm.clickOnMyAccount();
		 rg =hm.selectRegisterOption();

	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFiels()  {
		
		rg.enterFirstName(dataprop.getProperty("firstName"));
		rg.enterLastName(dataprop.getProperty("lastName"));
		rg.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		rg.enterTelephoneNumber(dataprop.getProperty("telephoneNumber"));
		rg.enterPassword(dataprop.getProperty("validPassword"));
		rg.enterConfirmPassword(dataprop.getProperty("passwordConfirm"));
		rg.selectPrivacyPolicy();
		as=rg.clickOnContinueButton();

	

		String actualtext = as.retriveAccountSuccessPageHeading();
		String expectedtext = dataprop.getProperty("accountScuccessText");
		Assert.assertEquals(actualtext, expectedtext, "Account is not created");

	}

	@Test(priority = 2)
	public void verifyRegisteringAnAccountWithAllFiels()  {
		
		rg.enterFirstName(dataprop.getProperty("firstName"));
		rg.enterLastName(dataprop.getProperty("lastName"));
		rg.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		rg.enterTelephoneNumber(dataprop.getProperty("telephoneNumber"));
		rg.enterPassword(dataprop.getProperty("validPassword"));
		rg.enterConfirmPassword(dataprop.getProperty("passwordConfirm"));
		rg.selectYesNewsLeterOption();
		rg.selectPrivacyPolicy();	
		as=rg.clickOnContinueButton();


		String actualtext = as.retriveAccountSuccessPageHeading();
		String expectedtext = dataprop.getProperty("accountScuccessText");
		Assert.assertEquals(actualtext, expectedtext, "Account is not created");
		
	}

	@Test(priority = 3)
	public void verifyRegiterAccountWithExistingEmailId() {

		rg.enterFirstName(dataprop.getProperty("firstName"));
		rg.enterLastName(dataprop.getProperty("lastName"));
		rg.enterEmailAddress(dataprop.getProperty("validEmail"));
		rg.enterTelephoneNumber(dataprop.getProperty("telephoneNumber"));
		rg.enterPassword(dataprop.getProperty("validPassword"));
		rg.enterConfirmPassword(dataprop.getProperty("passwordConfirm"));
		rg.selectYesNewsLeterOption();
		rg.selectPrivacyPolicy();
		rg.clickOnContinueButton();
		
		
		String actualtext = rg.retrieveDuplicateMailAddressWarning();
		String expectedtext = dataprop.getProperty("duplicateEmailAddressWarningMessage");
		Assert.assertEquals(actualtext, expectedtext, "E-mail is already registed");
	}

	@Test(priority = 4)
	public void verifyRegiterAccountWithOutEnteringAnyDetails() {

		rg.clickOnContinueButton();

		String actualpolicyText = rg.retrievePrivacyPolicyWarning();
		String expctedpolicyText = dataprop.getProperty("privacePolicyAgreeWarning");
		Assert.assertEquals(actualpolicyText, expctedpolicyText, "privacy polic text not fount");

		String actualFirstnameText = rg.retrieveFirstNameWarning();
		String expctedFirstnameText = dataprop.getProperty("firstNameWoring");
		Assert.assertEquals(actualFirstnameText, expctedFirstnameText, "firstname warning  text not fount");

		String actualLastnameText = rg.retrieveLastNameWarning();
		String expctedLastnameText = dataprop.getProperty("lastNameWorning");
		Assert.assertEquals(actualLastnameText, expctedLastnameText, "Last name warning  text not fount");

		String actualEmailText = rg.retrieveEmailAddressWarning();
		String expctedEmailText = dataprop.getProperty("emailAddressWorning");
		Assert.assertEquals(actualEmailText, expctedEmailText, " E-mail warning  text not fount");

		String actualTelephoneText = rg.retrieveTelephoneNumberWorning();
		String expctedTeliphoneText = dataprop.getProperty("telephoneWornig");
		Assert.assertEquals(actualTelephoneText, expctedTeliphoneText, " Teliphone warning  text not fount");

		String actualPasswordText = rg.retrievePasswordWorning();
		String expctedPasswordText = dataprop.getProperty("passwordWarning");
		Assert.assertEquals(actualPasswordText, expctedPasswordText, " Password warning  text not fount");

	}

}
