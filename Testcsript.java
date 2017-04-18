
/**
Create first Selenium Script
Browser Open and Close commands
Browser Navigation command
Working with Firefox Browser
Working with Chrome Browser
Working with IE Browser**/

package com.learn.lesson1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;


public class Testcsript {
	
   
    WebDriver driver = Utility.Openbrowser("firefox");
	@Test
	public void Operations() throws Exception
	{
	    driver.get("http://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("rishi123@gmail.com");
		driver.findElement(By.xpath("//input[@id='next'] [@value='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("rishi123");
		driver.findElement(By.xpath("//input[@name='signIn'] [@value='Sign in']")).click();
		
	}
	
	
	@AfterTest
	public void teardown() {
		
		System.out.println("AfterTest");
		driver.quit();
		
	}
	}
	
	
		
		
		
	


