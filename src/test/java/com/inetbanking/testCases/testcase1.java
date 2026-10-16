package com.inetbanking.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.loginPage;


public class testcase1 extends testbaseClass {


	@Test
	public void test()
	{
		driver.get(baseurl);
		logger.info("URL Opened");
		loginPage lp=new loginPage(driver);
		lp.setusername(username);
		logger.info("updated UN");
		lp.setpassword(passwords);
		logger.info("updated PW");
		lp.clicksubmit();
//		String title=driver.getTitle();
//		System.out.println(title);
		if(driver.getTitle().equals("GTPL Bank Manager HomePagesss"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
			try {
				captureScreen(driver,"login passed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	

}
