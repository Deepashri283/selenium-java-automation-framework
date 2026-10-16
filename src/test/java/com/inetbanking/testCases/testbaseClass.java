package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.Utilities.ReadConfig;

public class testbaseClass {
	ReadConfig readconfig=new ReadConfig();
	

	public String baseurl=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String passwords=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath() );
		driver=new ChromeDriver();
		logger=Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("log4j.properties");
	
		
	}
	
	@AfterClass
	public void teardown()
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

}
