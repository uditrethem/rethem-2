package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public WebDriver driver;
	public WebDriver initalizedriver() throws IOException
	{
		Properties pro=new Properties();
		String currentDirectory = System.getProperty("user.dir");
		String filepath= "\\src\\main\\java\\data.properties";
		//FileInputStream fis= new FileInputStream("C:\\Users\\parik\\eclipse-workspace\\Rethem\\src\\main\\java\\data.properties");
		FileInputStream fis= new FileInputStream (currentDirectory +filepath);
		pro.load(fis);
		String browsername=pro.getProperty("Browser");
		String Url=pro.getProperty("Devurl");
		
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setBinary(new File("/<path to chrome >/google-chrome"));
			//WebDriver driver  = new ChromeDriver(chromeOptions);

			
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browsername.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else
		{
			System.out.println("we do not support the browser");
		}

		driver.manage().window().maximize();
	driver.get(Url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
	}
	
	
}
