package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExtendsBaseclass extends BaseclassDemo{
	//@Parameters({"chrome"})
	@Test
	public void Login(){
		
		driver1.get("http://www.facebook.com");
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver1.findElement(By.xpath(".//*[@id='email']")).sendKeys("manjujnv87@gmail.com");
		driver1.findElement(By.xpath(".//*[@id='pass']")).sendKeys("rishi123");
		driver1.findElement(By.xpath("//label[@for='email']//following::label[2]")).click();
		driver1.close();
	}
}		
		
	
	


