package com.learn.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class FileUploaddemo {
	WebDriver driver = Utility.Openbrowser("chrome");
		@Test
		public void Operations() throws Exception
		{
	
	// This will open respective URL
	driver.get("file:///C:/Automation/AutoIT/Upload.html");
	        
	// This will click on Upload button
	driver.findElement(By.xpath("//input[@type='file']")).click();
	     
	// This will invoke AutoIT script here give the path of the script 
	//and this will throw IO exception so u can use throw or try catch
	// In my case I am using throws
	 
	Runtime.getRuntime().exec("C:\\Automation\\AutoIT\\Uploadatoit.exe");
	 
	// Once you will run this program AutoIt script will be invoked and respective f//ile will be attached
	  
	  }

}
