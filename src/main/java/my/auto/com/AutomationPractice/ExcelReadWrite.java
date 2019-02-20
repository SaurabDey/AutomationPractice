package my.auto.com.AutomationPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public String[] readExcel() throws IOException {
		
		File f=new File("Resource/Book.xlsx");
		FileInputStream fis= new FileInputStream(f);
		
		XSSFWorkbook exc= new XSSFWorkbook(fis);
		XSSFSheet sh= exc.getSheet("selenium");
		
		String first= sh.getRow(1).getCell(0).getStringCellValue();
		
		String last= sh.getRow(1).getCell(1).getStringCellValue();
		
		String pass= sh.getRow(1).getCell(2).getStringCellValue();
		
		System.out.println(first+" "+last+" "+pass);
		
		
		String [] values= new String[3];
		values[0]=first;
		values[1]=last;
		values[2]=pass;
		
		exc.close();
		fis.close();
		
		return values;
	}

}
