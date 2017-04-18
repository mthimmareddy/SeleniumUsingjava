package com.learn.lesson1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Framesdemo {
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void Switchingiframes(){
				
		driver.get("http://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Parent window title"+driver.getTitle());
		
		driver.findElement(By.xpath("//div[@id='signin-block']/i")).click();
		driver.findElement(By.xpath(".//*[@id='signInLink']")).click();
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames is: "+iframes.size());
		for (int i=0;i<iframes.size(); i++)
		{
			WebElement ele= iframes.get(i);
			System.out.println("Iframe is"+ele);
			//System.out.println("iframe name is" +ele.getText());
		//	System.out.println("iframe name is" +ele.getAttribute("id"));
			/*System.out.println("iframe name is" +ele.getText());
			
			driver.switchTo().frame(iframes.get(i));
			driver.findElement(By.xpath(".//*[@id='signInView']/div[2]/div/div[3]/button")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='emailID']")).sendKeys("Manju");*/
			
		}
		
		//WebElement ele =driver.findElement(By.xpath("//iframe[@src='https://xds.gsecondscreen.com/xds2/']"));
		
		
		driver.switchTo().frame(0);
		//System.out.println("frame title"+driver.getTitle());
		driver.findElement(By.xpath(".//*[@id='signInView']/div[2]/div/div[3]/button")).click();
		
		//driver.findElement(By.xpath(".//*[@id='password']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='emailID']")).sendKeys("Manju");
		driver.findElement(By.xpath(".//*[@id='password']")).click();
		//This switches back to parent window.We need to switcch to parent window before switching to otherr frame.*/
		driver.switchTo().defaultContent();
	}
		
}		
		
		
	
	

	
