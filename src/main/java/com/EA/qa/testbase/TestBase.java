package com.EA.qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Exception
	{
		prop=new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\ExecuteAutomation1\\src\\main\\java\\com\\EA\\qa\\config\\config.properties");
		prop.load(ip);
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
