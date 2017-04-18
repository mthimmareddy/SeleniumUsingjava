package com.learn.lesson1;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class CaptureScreenshot {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	@Test
	public void Capturescreen() throws Exception
	{
		 driver.get("http://www.google.com");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/"+"file1.png"));
		System.out.println("Screen shot taken");

	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	
	FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	 

}}}

