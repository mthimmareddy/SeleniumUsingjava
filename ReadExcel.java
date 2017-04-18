package com.learn.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class ReadExcel {
	//WebDriver driver= Utility.Openbrowser("chrome");
	

	@Test(dataProvider = "test1")
	
	public void TestFireFox(String uname,String password , String value){
				    
		            WebDriver driver= Utility.Openbrowser("chrome");
					driver.manage().window().maximize();
					 
					driver.get("http://www.facebook.com");
						 
					driver.findElement(By.id("email")).clear();
					 	 
					driver.findElement(By.id("email")).sendKeys(uname);
					 
					driver.findElement(By.id("pass")).clear();
					 	
					driver.findElement(By.id("pass")).sendKeys(password);
					driver.close();
	        }
	

	   @DataProvider(name = "test1")
	public  Object[][] readdata() {
		   
		   	   Object[][] data= Utility.readexceldata("C:\\Automation\\ApachePoi\\SeleniumDataExcel.xlsx", 0);
	   
			
		return data;
}
}
