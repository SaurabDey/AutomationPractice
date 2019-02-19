package my.auto.com.AutomationPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public static void main(String[] args) throws IOException {
		
		File f=new File("Resource/Book.xlsx");
		FileInputStream fis= new FileInputStream(f);
		
		XSSFWorkbook exc= new XSSFWorkbook(fis);
		XSSFSheet sh= exc.getSheet("selenium");
		
		String user= sh.getRow(1).getCell(0).getStringCellValue();
		
		String pass= sh.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(user +" "+pass);
		
		exc.close();
		fis.close();
		
	}

}
