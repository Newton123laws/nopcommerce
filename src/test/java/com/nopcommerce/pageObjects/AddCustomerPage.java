package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	By lnkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomers_menuItem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By btnAddNew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\'Email\']");
	By txtPassword	= By.name("Password");
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	
	By rdmale_gender = By.id("Gender_Male");
	By rdfemale_gender = By.id("Gender_Female");
	
	By txtDateOfBirth = By.id("DateOfBirth");
	By txtCompany = By.id("Company");
	
	By checkBoxTax = By.id("IsTaxExempt");
	
	//By txtcustomerRoles = By.xpath("//*[@id=\'customer-info\']/div[2]/div[12]/div[2]/div/div[1]/div");

	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemForum_Moderators=By.xpath("//li[contains(text(),'Forum Moderators']");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpgrpVender = By.xpath("//*[@id=\'VendorId\']");
	
	By txtAdminComment = By.xpath("//*[@id=\'AdminComment\']");
	
	By btnSave = By.name("save");
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomers_MenuItem() {
		ldriver.findElement(lnkCustomers_menuItem).click();
	}
	
	public void clickOn_AddNewBtn() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdmale_gender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdfemale_gender).click();
		}
		else
		{
			ldriver.findElement(rdmale_gender).click();//Default
		}	
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDateOfBirth).sendKeys(dob);
	}
	
	public void setCompanyName(String compname)
	{
		ldriver.findElement(txtCompany).sendKeys(compname);
	}
	
	public void TaxPayer()
	{
		ldriver.findElement(checkBoxTax).click();
	}
	
	public void setCustomerRoles(String role) 
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
		
		ldriver.findElement(txtcustomerRoles).click();
					
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
				listitem=ldriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=ldriver.findElement(lstitemGuests); break;
		case "Registered":
			listitem=ldriver.findElement(lstitemRegistered); break;
		case "Vendors":
			listitem=ldriver.findElement(lstitemVendors); break;
		default:
			listitem=ldriver.findElement(lstitemGuests);
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpgrpVender));
		drp.selectByVisibleText(value);
	}
/*	
	public void AdminComment(String val)
	{
		ldriver.findElement(txtAdminComment).sendKeys(val);
	}
	
*/	
	public void savedetails()
	{
		ldriver.findElement(btnSave).click();
	}
	
}
