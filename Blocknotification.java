package com.learn.lesson1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Blocknotification {

   // WebDriver driver = Utility.Openbrowser("chrome");
	@Test
	public void Operations() throws Exception
	{
	
		Map<String, Object> prefs = new HashMap<String, Object>();
    
    prefs.put("profile.default_content_setting_values.notifications", 2);

    // Create object of ChromeOption class
ChromeOptions options = new ChromeOptions();

    // Set the experimental option
options.setExperimentalOption("prefs", prefs);

    // pass the options object in Chrome driver
System.setProperty("webdriver.chrome.driver","C:\\Automation\\Drivers\\chromedriver.exe");

WebDriver driver = new ChromeDriver(options);
driver.get("https://www.facebook.com/");
driver.manage().window().maximize();
driver.findElement(By.id("email")).sendKeys("manjujnv87@gmail.com");
driver.findElement(By.id("pass")).sendKeys("rishi123");
driver.findElement(By.id("loginbutton")).click();


}
}