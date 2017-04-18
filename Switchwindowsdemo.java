/**
 * Handle the Multiple windows using Set and Iterator
 */

package com.learn.lesson1;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class  Switchwindowsdemo {
	
WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	public void SwitchingWondows(){
				
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https://mail.google.com/mail/?pc=topnav-about-en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Parent window title"+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Learn more']")).click();
		
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
		
		System.out.println("Switching back to parent window title"+driver.getTitle());
		
		driver.close();
		
		
		}
	
}
		
		
		
		
		



