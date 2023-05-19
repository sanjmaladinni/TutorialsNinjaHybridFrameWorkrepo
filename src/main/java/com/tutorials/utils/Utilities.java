package com.tutorials.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public static int Implicit_Wait_Time = 10;
	public static int Page_Wait_Load_ime = 5;

	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "").replace(":", "_");
		return "sanju" + timeStamp + "@gmail.com";
	}

	public static Object[][] getTestDataFromExcel(String SheetName) {
		File file = new File("src\\main\\java\\com\\tutorialninja\\testdata\\TutorialTestData.xlsx");
		XSSFWorkbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;

	}
	
	public static String captureScreenShot(WebDriver driver , String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Screen Shots\\" + testName + ".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
}
