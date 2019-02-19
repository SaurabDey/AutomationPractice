package my.auto.com.AutomationPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class MaintestNg {
	WebDriver Driver;

	@Test
	public void f() {

		SignUPPage sign = new SignUPPage(Driver);
		sign.signUp();

		RegistrationPage regis = new RegistrationPage(Driver);
		regis.registration();

	}

	@Parameters("browserName")
	@BeforeTest
	public void beforeTest(String value) {

		String browser=value;
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			Driver = new ChromeDriver();
		} 
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			Driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		}
		else {
			throw new RuntimeException("Please provide correct browser name");
		}
		

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Close Page");
		Driver.quit();
	}

}
