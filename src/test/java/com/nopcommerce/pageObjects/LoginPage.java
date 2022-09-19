package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement linkLogout;
	
	public void setusername(String user)
	{
		txtUsername.clear();
		txtUsername.sendKeys(user);
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btnLogin.click();
	}
	
	public void ClickLogout()
	{
		linkLogout.click();
	}
	
}
