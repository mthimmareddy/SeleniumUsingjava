/*
 * Demonstrates about scroll in view and scroll tmentioned dimentions
 */

package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Scrolldemo {
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void Scrolliframes(){
				
		driver.get("http://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		WebElement ele =driver.findElement(By.xpath(".//*[@id='navFooter']/table/tbody/tr/td[7]/ul/li[1]/a"));
		je.executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		System.out.println("Parent window title"+driver.getTitle());
		
	}
}
