package com.tutotiarlsninjs.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorial.base.BaseClass;
import com.tutorial.POM.HomePage;
import com.tutorial.POM.SearchPage;

public class SearchTest extends BaseClass {
	public WebDriver driver;
	SearchPage sp;

	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
	}

	@Test(priority = 1)
	public void verifysearchWithValidProduct() {
		HomePage hp = new HomePage(driver);
		hp.enterproductNameToSearchBoxField(dataprop.getProperty("validProduct"));
		sp=hp.clickOnSearchButton();
		
		Assert.assertTrue(sp.displayStatusOfHpValidProduct(), "Valid product HP is not displayed in the search result");

	}

	@Test(priority = 2)
	public void verifysearchWithInValidProduct() {
		HomePage hp = new HomePage(driver);
		hp.enterproductNameToSearchBoxField(dataprop.getProperty("inValidProduct"));
		sp=hp.clickOnSearchButton();

	
		String actualsearchtext = sp.retrieveNoProductMessage();
		String expctedsearchtext = dataprop.getProperty("noProductTextInSearchBox");
		Assert.assertEquals(actualsearchtext, expctedsearchtext, "no product matchies in criteria");

	}

	@Test(priority = 3, dependsOnMethods = {"verifysearchWithInValidProduct"})
	public void verifysearchWithOutAnyProduct() {
		HomePage hp = new HomePage(driver);
		sp=hp.clickOnSearchButton();


		String actualsearchtext = sp.retrieveNoProductMessage();
		String expctedsearchtext = dataprop.getProperty("noProductTextInSearchBox");
		Assert.assertEquals(actualsearchtext, expctedsearchtext, "no product matchies in criteria");

	}

}
