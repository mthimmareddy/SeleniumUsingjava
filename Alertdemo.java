package com.learn.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Alertdemo {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	
	@Test
	
	public void TestAL() throws InterruptedException{
		     
        driver.get("http://www.ksrtc.in/oprs-web/");
 
        // Maximize the window
 
        driver.manage().window().maximize();
        Thread.sleep(5000);
          
        driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();
 
        // Switch to alert window and capture the text and print
 
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.close();
 
        // Pause testcase for 5 second

}
}