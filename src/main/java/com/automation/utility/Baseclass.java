package com.automation.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass extends Browser {

	public WebDriver driver;
	public ExcelDataProvider excel;

	@BeforeSuite
	public void setupsuit() {
		excel = new ExcelDataProvider();
	}

	@BeforeMethod
	public void openbrowser() throws IOException {
		driver = initalizedriver();

	}

	/*
	 * @AfterMethod public void closebrowser() { driver.quit(); }
	 */
}
