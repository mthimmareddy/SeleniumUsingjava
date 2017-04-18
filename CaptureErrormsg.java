package com.learn.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class CaptureErrormsg {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	@Test
	public void TestError() throws InterruptedException
	{
	  
	// Open browser     
		
		By Signin1 = By.xpath(".//*[@id='nav-orders']/span[2]");
		//By Signin2 = By.xpath(".//*[@id='nav-signin-tooltip']/a/span");
		By username = By.xpath(".//*[@id='ap_email']");
		By password = By.cssSelector("input[id='ap_password']");
		By subbtn= By.xpath("//input[@id='signInSubmit']");
		By forgetlink = By.linkText("Forgot your password?");
		
	
	// maximize browser
	driver.manage().window().maximize();
	        
	// Open URL
	driver.get("http://www.amazon.com/");
	
	        
	// Click on login button
	driver.findElement(Signin1).click();
	//driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[9]/a")).click();
	Thread.sleep(1000);
	driver.findElement(subbtn).click();
	        
	// This will capture error message
	String actual_msg=driver.findElement(By.xpath(".//*[@id='auth-email-missing-alert']/div/div")).getText();
	    
	// Store message in variable
	String expect="Enter your email or mobile phone number";
	                
	// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
	//exception and fail testcases
	 
	// Verify error message
	Assert.assertEquals(actual_msg, expect,"Strings dint match");
	
	
	driver.close();
	 
	    }

}
