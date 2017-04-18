import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExceldemo {
	
	@Test
 public void readexcel() throws Exception{
	File src= new File("C:\\Automation\\ApachePoi\\SeleniumDataExcel.xlsx");
	FileInputStream f1 = new FileInputStream(src);
	XSSFWorkbook excel1 = new XSSFWorkbook(f1);
	XSSFSheet sheet1 = excel1.getSheetAt(0);
   System.out.println("Value from excel is"+sheet1.getRow(0).getCell(0));
   
   System.out.println("Total number of rows"+(sheet1.getLastRowNum()+1));
   int numrow = sheet1.getLastRowNum()+1;
   for (int i=0;i<numrow;i++){
	    for(int j=0;j<2;j++)
	   System.out.println(sheet1.getRow(i).getCell(j));
   }
   }
   
}

