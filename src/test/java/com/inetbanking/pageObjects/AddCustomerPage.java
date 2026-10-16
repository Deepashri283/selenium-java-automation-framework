package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver idriver;
	
	
	public AddCustomerPage(WebDriver rdriver)
	{
		idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement customer;
	
	
	@FindBy(name="name")
	WebElement cname;
	
	@FindBy(xpath = "//td[contains(text(),'Gender')]/following-sibling::td/input[1]")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement cdob;
	
	@FindBy(name="addr")
	WebElement caddress;
	
	@FindBy(name="city")
	WebElement cacity;
	
	@FindBy(name="state")
	WebElement cstate;
	

	@FindBy(name="pinno")
	WebElement cspin;
	

	@FindBy(name="emailid")
	WebElement csemailid;
	
	@FindBy(name="sub")
	WebElement submitbtn;
	
	
	public void selectcustomerlink()
	{
		customer.click();
	}
	
	public void setcustomer(String csname)
	{
		cname.sendKeys(csname);
	}
	
	public void selectgender()
	{
		gender.click();
	}
	
	public void setdob(String csdob)
	{
		cdob.sendKeys(csdob);
	}
	public void setaddress(String csadd)
	{
		caddress.sendKeys(csadd);
	}

	public void setcity(String cscity)
	{
		cacity.sendKeys(cscity);
	}
	
	public void setstate(String csstate)
	{
		cstate.sendKeys(csstate);
	}
	

	public void setpin(String csspin)
	{
		cspin.sendKeys(csspin);
	}
	
	public void setemai(String csemail)
	{
		csemailid.sendKeys(csemail);
	}
	public void selectsubmitr()
	{
		submitbtn.click();
	}
	
	
}
