package my.auto.com.AutomationPractice.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtility 
{
	WebDriver Driver;

	
	public CommonUtility(WebDriver Driver) {
		this.Driver=Driver;
	}


	public String screenshot(String nameOfScreenshot)
	{
		TakesScreenshot ts = (TakesScreenshot)Driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screens\\"+nameOfScreenshot+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}
}
