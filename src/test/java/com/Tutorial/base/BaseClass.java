package com.Tutorial.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import com.tutorials.utils.Utilities;

public class BaseClass {
	 WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	
	public BaseClass() {
		

		prop = new Properties();
		File file = new File("src\\main\\java\\com\\tutorials\\config\\configs.properties");
		
		dataprop= new Properties();
		File file1 = new File("src\\main\\java\\com\\tutorialninja\\testdata\\testdata.properties" );
		
		try {
		FileInputStream fis1 = new FileInputStream(file1);
		dataprop.load(fis1);
		} catch (Throwable e) {
			e.printStackTrace();
			
		}
		
		try {
			FileInputStream fis;
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.Page_Wait_Load_ime));
		driver.get(prop.getProperty("url"));
		return driver;

	}

	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}

}
