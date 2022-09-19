package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class Baseclass {
	
	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath() );
		    driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{

			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath() );
		    driver=new EdgeDriver();
			
		}
		logger = Logger.getLogger("nopEcommerce"); //Added Logger
		PropertyConfigurator.configure("log4j.properties");
	}
	//C:\Eclipse WorkSpace\nopCommerce\Drivers
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	
	
}
