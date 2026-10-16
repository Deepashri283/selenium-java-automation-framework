package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.loginPage;

public class AddCustomerTest03 extends testbaseClass {

	
	@Test
	public void addcustomer() throws InterruptedException
	{
		loginPage lp=new loginPage(driver);
		driver.get(baseurl);
		lp.setusername(username);
		lp.setpassword(passwords);
		lp.clicksubmit();
		driver.manage().window().maximize();
		AddCustomerPage addcs=new AddCustomerPage(driver);
		addcs.selectcustomerlink();
		Thread.sleep(1000);
		addcs.setcustomer("deepa");
		logger.info("updated customer");
		addcs.selectgender();
		logger.info("updated gender");
		addcs.setdob("21/03/1994");
		logger.info("updated DOB");
		addcs.setaddress("bangalore");
		logger.info("updated address");
		addcs.setcity("bangalore abc");
		logger.info("updated city");
		addcs.setstate("karnataka");
		logger.info("updated state");
		addcs.setpin("123212");
		logger.info("updated pin");
		addcs.setemai("deepa1@gmail.com");
		logger.info("updated email");
		Thread.sleep(1000);
		addcs.selectsubmitr();
		logger.info("Clikecd submit");
		
		
		
	}
}
