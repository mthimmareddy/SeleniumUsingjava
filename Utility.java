package com.learn.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

//import au.com.bytecode.opencsv.CSVReader;

public class Utility  {
	static WebDriver driver1;
	
	@Test(enabled=false)
public  static WebDriver Openbrowser(String browser)  
	  {
		if(browser.equalsIgnoreCase("firefox")){
			
			//It create firefox profile
			//FirefoxProfile profile=new FirefoxProfile();
			 
			// This will set the true value
			//profile.setAcceptUntrustedCertificates(true);
			//Proxy setting on browser
		/*	Proxy p=new Proxy();
			 
			 
			  // Set HTTP Port to 7777
			  p.setHttpProxy("localhost:7777");
			 
			  // Create desired Capability object
			  DesiredCapabilities cap=new DesiredCapabilities();
			
			 
			  // Pass proxy object p
			  cap.setCapability(CapabilityType.PROXY, p);*/
			
			ProfilesIni init=new ProfilesIni();
			 			 
            // Get the default session  
 
            FirefoxProfile profile2=init.getProfile("default");
            profile2.setAcceptUntrustedCertificates(true);
		System.setProperty("webdriver.gecko.driver","C:\\Automation\\Drivers\\geckodriver.exe");
		driver1 = new FirefoxDriver(profile2);
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			 Map<String, Object> prefs = new HashMap<String, Object>();
			//Disable the notifications to block with 2
			 prefs.put("profile.default_content_setting_values.notifications", 2);
             ChromeOptions options = new ChromeOptions();
             //Disable the chrome developer extentions
			options.addArguments("--disable-extensions");
			//Disable the notifications
			options.setExperimentalOption("prefs", prefs);
			
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			 
			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			System.setProperty("webdriver.chrome.driver","C:\\Automation\\Drivers\\chromedriver.exe");
	         driver1 = new ChromeDriver(options);
								
		}
		
		else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
			 
			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 
			System.setProperty("webdriver.IE.driver", "C:\\Automation\\Drivers\\IEDriverServer.exe");
			driver1 = new InternetExplorerDriver(cap);}
			
		return driver1;
	  }






@Test(enabled=false)
     public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
           {
  
			WebElement ele = null;
			 for(int i=0;i<time;i++){
					try {
					ele=driver.findElement(By.xpath(xpath));
					break;}
					
					catch(Exception e){
					try {
					Thread.sleep(1000);
					}
					catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
					   }
			}
	}
			return ele;
			 
			}
     
     public static WebElement Highlight(WebElement element, WebDriver driver) {
    	  
		  
     	
   	  JavascriptExecutor js=(JavascriptExecutor)driver; 
   	  
   	  js.executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');", element);
   	  
   	  return element;
   	 }
     
@Test(enabled=false)
     public  void Highlight() {
    	     	  
    		  driver1=Openbrowser("chrome");
    		  
    		  driver1.get("http://www.facebook.com");
    		  WebElement element= driver1.findElement(By.id("email"));
    	
    	  JavascriptExecutor js=(JavascriptExecutor)driver1; 
    	  
    	  js.executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');", element);
    	  
    	  //return element;
    	 }
    	  
    	
@Test(enabled=false)
public  static Object[][] readexceldata( String path, int sheetnum) {
	 
	Object[][] Data = new Object[10][3];
	
	try {
		File src= new File(path);
		FileInputStream f1 = new FileInputStream(src);
		XSSFWorkbook excel1 = new XSSFWorkbook(f1);
		XSSFSheet sheet1 = excel1.getSheetAt(sheetnum);
  // System.out.println("Value from excel is"+sheet1.getRow(0).getCell(0));
   
  // System.out.println("Total number of rows"+(sheet1.getLastRowNum()+1));
   int numrow = sheet1.getLastRowNum()+1;
   for (int i=0;i<numrow;i++){
		    for(int j=0;j<2;j++)
		   Data[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
		  }   
  
             } catch (Exception e) {
		
		e.getMessage();
	}
	
	return Data;
   }


@Test

public  static void writeexceldata( ) {
	 
	try {
		 
		  // Specify the file path which you want to create or write
		 
		  File src=new File("C:\\Automation\\ApachePoi\\SeleniumDataExcel.xlsx");
		 
		  // Load the file
		 
		  FileInputStream fis=new FileInputStream(src);
		 
		   // load the workbook
		 
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		 
		  // get the sheet which you want to modify or create
		 
		   XSSFSheet sh1= wb.getSheetAt(0);
		 
		
		   sh1.createRow(0).createCell(3).setCellValue("rishi");
		   sh1.getRow(1).createCell(3).setCellValue("Manju");
		   sh1.getRow(2).createCell(3).setCellValue("Ravi");
		 
		 
		 FileOutputStream fout=new FileOutputStream(new File("C:\\Automation\\ApachePoi\\test2.xlsx"));
		 wb.write(fout);
		 
		 fout.close();
		 
		  } catch (Exception e) {
		 
		   System.out.println(e.getMessage());}
		 
		 }


public void ReadCsvFiles() throws Exception  {
	 
	 
	 CSVReader reader = new CSVReader(new FileReader("C:\\Automation\\OpenCsv\\demo1.csv"));
	 
	 // this will load content into list
	  List<String[]> li=reader.readAll();
	  System.out.println("Total rows which we have is "+li.size());
	            
	 // create Iterator reference
	  Iterator<String[]>i1= li.iterator();
	    
	 // Iterate all values 
	 while(i1.hasNext()){
	     
	 String[] str=i1.next();
	   
	 System.out.print(" Values are ");
	 
	 for(int i=0;i<str.length;i++)
	 	   System.out.print(" "+str[i]);
	   System.out.println("   ");
	   }
	 
	}


	 
	}





