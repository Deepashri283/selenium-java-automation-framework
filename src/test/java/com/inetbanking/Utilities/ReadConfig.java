package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	
	public String getUserName()
	{
		String un=pro.getProperty("username");
		return un;
	}
	
	public String getPassword()
	{
		String pw=pro.getProperty("passwords");
		return pw;
	}
	
	
	public String getchromepath()
	{
		String chromp=pro.getProperty("chromepath");
		return chromp;
	}
	
	
	
	
}
