package com.tutorial.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorials.utils.Extentreport;
import com.tutorials.utils.Utilities;

public class MyListener implements ITestListener {
	ExtentReports extentRepor;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentRepor = Extentreport.generateExtenetReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentRepor.createTest(testName);
		extentTest.log(Status.INFO, testName + "started Executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + " got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String dest = Utilities.captureScreenShot(driver, testName);

		extentTest.addScreenCaptureFromPath(dest);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + " got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();

		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + " got failed");

	}

	@Override
	public void onFinish(ITestContext context) {
		extentRepor.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.htm";
		File file = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
