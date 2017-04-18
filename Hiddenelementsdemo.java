/*
 * Handle the hidden elements in selenium
 */

package com.learn.lesson1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class  Hiddenelementsdemo {
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void hiddenhandle(){
				
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	/*int x =	driver.findElement(By.xpath(".//*[@id='male']")).getLocation().getX();
	int y =	driver.findElement(By.xpath(".//*[@id='male']")).getLocation().getY();
	System.out.println("X and Y" +x +y);*/
	
	List<WebElement> radio = driver.findElements(By.xpath(".//*[@id='male']"));
	
	for(WebElement ele:radio){
		
		int z=  ele.getLocation().getX();
		if(z!=0){
			ele.click();
			//break;
		}}
		}
}
	
	
	
	
	


