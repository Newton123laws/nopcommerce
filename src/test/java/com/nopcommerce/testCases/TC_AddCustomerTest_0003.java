package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_0003 extends Baseclass
{

	
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		lp.setusername(username);
		logger.info("User name is provided");
		
		lp.setpassword(password);
		logger.info("password is provided");
		
		Thread.sleep(2000);
		lp.ClickLogin();
						
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomers_MenuItem();
		
		addcust.clickOn_AddNewBtn();
		logger.info("click on add new button");
		Thread.sleep(3000);
		
		logger.info("providing customer details....");		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		Thread.sleep(3000);
		
		addcust.setFirstName("Harsha");
		addcust.setLastName("Vardhan");
		Thread.sleep(3000);
		
		addcust.setGender("Male");
		
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		Thread.sleep(3000);
		
		addcust.setCompanyName("IBM India");
		
		addcust.TaxPayer();
		Thread.sleep(3000);
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guests");
		
		addcust.setManagerOfVendor("Vendor 1");
		Thread.sleep(3000);
		addcust.savedetails();
		
		/*
		addcust.AdminComment("This is for testing.........");
		Thread.sleep(3000); */
	
		
		
		
		logger.info("validation started....");
		Thread.sleep(2000);
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("testcase failed");
		}
				
	}
	
}
