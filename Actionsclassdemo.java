/*
 * Demonstrates mouseOver,Rightclick ,sendKeys on right click,
 * autosuggetion pick,drag and drop
 */

package com.learn.lesson1;

import java.util.Iterator;
//import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

@Listeners(ITestlistener.class)
public class Actionsclassdemo {
	
	//WebDriver driver = Utility.Openbrowser("firefox");
	  
	  @Test
		public void  Autosuggetions() throws InterruptedException 
		{
			WebDriver driver = Utility.Openbrowser("chrome");
			driver.get("http://www.naukri.com");
			
			String Parenthandle = driver.getWindowHandle();
			
			System.out.println("Parenthandle"+Parenthandle);
			
			Set<String> allhandles=driver.getWindowHandles();
			
			Iterator<String> s1=allhandles.iterator();
			
			while(s1.hasNext()){
				String childwindow = s1.next();
				
				System.out.println("Childhandle"+childwindow);
				
				if(!Parenthandle.equalsIgnoreCase(childwindow)){
					driver.switchTo().window(childwindow);
					//System.out.println("Childhandle"+childhandle);
					System.out.println("In the child Window" +driver.getTitle());
					driver.close();
				}
				}
				
			driver.switchTo().window(Parenthandle);
			
					driver.findElement(By.xpath(".//*[@id='qsbClick']/span[1]")).click();
		
		Actions builder=new Actions(driver);
		
//ContextClick(WebElement) rightclicks on webelement
		builder.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();;
	//builder.moveToElement(ele1).perform();
	//ele1.click();
		
		Thread.sleep(5000);
			
			 driver.findElement(By.xpath(".//*[@id='skill']/div[1]/div[2]/input")).sendKeys("qtp,");
			Thread.sleep(2000);
			
			WebElement ele1=driver.findElement(By.xpath(".//*[@id='sugDrp_skill']/ul/li[1]/div"));
			//ele1.sendKeys("qtp");
			 
			//builder.contextClick().perform();
			builder.moveToElement(ele1).click().build().perform();
			 
			
			Thread.sleep(2000);
			 
			
			//builder.click(ele1).build().perform();
			driver.close();
		} 

	  
	  @Test(enabled=false)
	  
	  public void dragdrop() throws InterruptedException{
			WebDriver driver = Utility.Openbrowser("chrome");
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		 
		// Add 5 seconds wait
		Thread.sleep(5000);
		 
		// Create object of actions class
		Actions act=new Actions(driver);
		 
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
		 
		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
		 
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		 
		  
	  }
}
			
			
	  
	


