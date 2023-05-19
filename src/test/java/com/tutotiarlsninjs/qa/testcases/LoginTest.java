package com.tutotiarlsninjs.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Tutorial.base.BaseClass;
import com.tutorial.POM.AccountPage;
import com.tutorial.POM.HomePage;
import com.tutorial.POM.LoginPage;
import com.tutorials.utils.Utilities;

public class LoginTest extends BaseClass {
	public WebDriver driver;
	LoginPage lp;
	AccountPage ap;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage hm = new HomePage(driver);
		hm.clickOnMyAccount();
		lp = hm.selectLoginOption();
	}

	@Test(priority = 1, dataProvider = "validCredentialSupplier")
	public void verifyLoginWithValidCredentials(String Email, String Password) {

		lp.enterEmailAddress(Email);
		lp.enterPasswordAddress(Password);
		ap=lp.clickOnLoginButton();

	

		Assert.assertTrue(ap.EditYourAccountInformation(), "Edit your account information");
	}

	@DataProvider(name = "validCredentialSupplier")
	public Object[][] suppydata() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		;
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {

		lp.enterEmailAddress("devil1211ninja@" + Utilities.generateEmailWithTimeStamp() + "gmail.com");
		lp.enterPasswordAddress(prop.getProperty("validPassword"));

		lp.clickOnLoginButton();

		String expectedwarningtext = dataprop.getProperty("verifyLoginWithInValidCredentials");
		String actualwarningtext = lp.retriveEmailPasswordNotMatchingWarningMessageText();

		Assert.assertEquals(actualwarningtext, expectedwarningtext);

	}

	@Test(priority = 3)
	public void verifyLoginWithInValidEmailAndValidPassword() {

		lp.enterEmailAddress("devil1211ninja@" + Utilities.generateEmailWithTimeStamp() + "gmail.com");
		lp.enterPasswordAddress(prop.getProperty("validPassword"));
		lp.clickOnLoginButton();

		String expectedwarningtext = dataprop.getProperty("verifyLoginWithInValidCredentials");
		String actualwarningtext = lp.retriveEmailPasswordNotMatchingWarningMessageText();

		Assert.assertEquals(actualwarningtext, expectedwarningtext);

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInValidPassword() {

		lp.enterEmailAddress(prop.getProperty("validEmail"));
		lp.enterPasswordAddress(dataprop.getProperty("invalidPssword"));
		lp.clickOnLoginButton();

		String expectedwarningtext = dataprop.getProperty("verifyLoginWithInValidCredentials");
		String actualwarningtext = lp.retriveEmailPasswordNotMatchingWarningMessageText();

		Assert.assertEquals(actualwarningtext, expectedwarningtext);

	}

	@Test(priority = 5)
	public void verifyLoginWithOutValidCredentials() {

		lp.clickOnLoginButton();

		String expectedwarningtext = dataprop.getProperty("verifyLoginWithInValidCredentials");
		String actualwarningtext = lp.retriveEmailPasswordNotMatchingWarningMessageText();

		Assert.assertEquals(actualwarningtext, expectedwarningtext);

	}

}
