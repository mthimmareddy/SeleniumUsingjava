package com.learn.lesson1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public class Sikulidemo {
	
	WebDriver driver = Utility.Openbrowser("chrome");
	@Test
	public void  Sikulitest() throws Exception 
	{
		Screen screen = new Screen();
		Pattern img1 = new Pattern("C:\\Automation\\Sikuli\\Signin.PNG");
		
		Pattern img2 = new Pattern("C:\\Automation\\Sikuli\\Username.PNG");
		Pattern img3= new Pattern("C:\\Automation\\Sikuli\\next.PNG");
		Pattern img4= new Pattern("C:\\Automation\\Sikuli\\gmail.PNG");
		
		driver.get("http://www.google.com");
		 
		screen.wait(img4, 10);
		 
			screen.click(img1);
		 
		screen.type(img2, "manjujnv87@gmail.com");
		 	 
		screen.click(img3);
		 

}}
	
