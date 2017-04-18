package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;


public class Listenerdemo {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	@Test
	
	public void operations(){
		
	EventFiringWebDriver event1=new EventFiringWebDriver(driver);
	 
	WebDriverEventListenerdemo handle=new WebDriverEventListenerdemo();
	 
	event1.register(handle);
	 
	event1.navigate().to("http://www.facebook.com");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	event1.findElement(By.id("email")).sendKeys("asdsadsa");
	 
	event1.findElement(By.id("loginbutton")).click();
	 
	event1.quit();
	 
	event1.unregister(handle);
	 
	System.out.println("End");

	}
}
