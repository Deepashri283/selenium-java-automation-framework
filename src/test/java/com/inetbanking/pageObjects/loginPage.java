package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver idriver;
	
	
	public loginPage(WebDriver rdriver)
	{
		idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(name="uid")
	WebElement tusername;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	public void setusername(String uname)
	{
		tusername.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		loginbtn.click();
	}
	
	
	
}
