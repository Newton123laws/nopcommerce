package com.nopcommerce.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_0001 extends Baseclass{
	
	@Test
	public void LoginTest() throws InterruptedException 
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		LoginPage pa = new LoginPage(driver);
		
		pa.setusername(username);
		logger.info("User Provided"); //loggs added
		
		pa.setpassword(password);
		logger.info("Password given"); //loggs added
		
		Thread.sleep(3000);
		pa.ClickLogin();
		logger.info("Click on Login Button"); //loggs added
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Thread.sleep(5000);
			pa.ClickLogout();
			logger.info("Logout from it");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
	}

}
