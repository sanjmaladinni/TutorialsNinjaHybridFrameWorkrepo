package com.tutorials.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {

	public static ExtentReports generateExtenetReport() {
		ExtentReports er = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.htm");
		ExtentSparkReporter esp = new ExtentSparkReporter(file);
		
		esp.config().setTheme(Theme.DARK);
		esp.config().setReportName("Tutorials Automation Test Report");
		esp.config().setDocumentTitle("TN Automation  Report");
		esp.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		er.attachReporter(esp);
		
		Properties configprop = new Properties();
		File file1= new File ("src\\main\\java\\com\\tutorials\\config\\configs.properties");
	
		try {
			
		FileInputStream fis = new FileInputStream(file1);
		configprop.load(fis);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		er.setSystemInfo("Appkication URL", configprop.getProperty("url"));
		er.setSystemInfo("Browser Name", configprop.getProperty("browser"));
		er.setSystemInfo("Email ", configprop.getProperty("validEmail"));
		er.setSystemInfo("validPassword ", configprop.getProperty("validPassword"));
		er.setSystemInfo("operating System", System.getProperty("os.version"));
		er.setSystemInfo("User Name", System.getProperty("user.name"));
		er.setSystemInfo("Java  vision", System.getProperty("java.version"));
		
		return er;
	}
	
}
