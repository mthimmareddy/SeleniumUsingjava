package com.learn.lesson1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseclassDemo {
	
	WebDriver driver1 ;
	@Parameters({"browser"})
	@BeforeClass
	public  void Openbrowser(String browser)  
	  {
	
		//String browser="chrome";
		if(browser.equalsIgnoreCase("firefox")){
		        
		System.setProperty("webdriver.gecko.driver","C:\\Automation\\Drivers\\geckodriver.exe");
		driver1 = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			 
			System.setProperty("webdriver.chrome.driver","C:\\Automation\\Drivers\\chromedriver.exe");
	         driver1 = new ChromeDriver();
								
		}
		
		else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
			 
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 
			System.setProperty("webdriver.IE.driver", "C:\\Automation\\Drivers\\IEDriverServer.exe");
			driver1 = new InternetExplorerDriver(cap);}
			
		//return driver1;
	  }
}

