/*
 * Handle the bootstrap dropdown
 */

package com.learn.lesson1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Bootstrapdropdowndemo {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void dropdownhandle(){
				
		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='menu1']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> dd_menu =driver.findElements(By.xpath(".//ul[@class='dropdown-menu']/li/a"));
		
		//for(int i=0;i<dd_menu.size();i++)
			for (WebElement ele:dd_menu)
		{
			//WebElement ele=dd_menu.get(i);
			String content= ele.getAttribute("innerHTML");
			if(content.equalsIgnoreCase("Javascript")){
				ele.click();
				break;
				}
			
			System.out.println("WebElement is:" +ele.getAttribute("innerHTML"));
			
		}
		
	
	
	driver.quit();
	}
}
		


//}
