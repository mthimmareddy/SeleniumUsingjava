package com.learn.lesson1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.learn.utilities.Utility;

public  class Brokenlinksdemo {
	
	 WebDriver driver = Utility.Openbrowser("firefox");
		@Test
		public void Operations() throws Exception
		{
			driver.get("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> links = driver.findElements(By.tagName("a"));
			for(int i=0;i<links.size();i++)
			{
				WebElement ele = links.get(i);
				String url= ele.getAttribute("href");
				if(url.contains("javascript")){
					continue;
				}
				System.out.println("Google suburl name is:"+url);
				Verifylinks(url);
			}
			System.out.println("Verified all links");
			driver.quit();
		}
		
		public static void Verifylinks(String Url) throws  Exception
		{
		 URL ul= new URL(Url);
		 try {
			HttpURLConnection http1 =(HttpURLConnection)ul.openConnection();
			http1.setConnectTimeout(3000);
			http1.connect();
			if(http1.getResponseCode()==200){
				System.out.println("Links is valid" +http1.getResponseMessage());
			}else
				System.out.println("Links is broken" +http1.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		 
			

			
}
}
