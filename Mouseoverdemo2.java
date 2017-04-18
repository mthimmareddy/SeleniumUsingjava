package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class  Mouseoverdemo2 {
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void dropdown1(){
				
		driver.get("http://www.naukri.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions act= new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//ul[@class='midSec menu']//li/a[@href='https://www.naukri.com/browse-jobs']"))).perform();
		

}
}
