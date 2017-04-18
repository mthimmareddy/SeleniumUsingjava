/*
 * Handle the Webtable and calender using List<Webelement>
 */

package com.learn.lesson1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Webtabledemo{
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void webtablehandle(){
				
		driver.get("http://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='onward_cal']/following::label[1]")).click();
		 List<WebElement> caldates =driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
		 
		 for(int i=0;i<caldates.size();i++)
		 {
			 WebElement ele =caldates.get(i);
			 String date1=ele.getText();
			 
			//	QA System.out.println("Element Name"+date1);
			 
			 if(date1.equalsIgnoreCase("25")){
				 ele.click();
				 break;
			 }
		 }
		 driver.quit();
		
	}}
		
		




