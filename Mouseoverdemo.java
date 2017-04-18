/*
 * Performs the mouseover operations using the Actions class
 */

package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Mouseoverdemo{
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void Mousehoverhandle(){
				
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		//if more than one operation try build().perform();
		act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Automation')]"))).perform();
		//choose findelement to select all the drop downs
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
	}
		

}

