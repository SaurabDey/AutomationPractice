package my.auto.com.AutomationPractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

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
	ExtentReports extent;
	ExtentTest test;
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
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Resource/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("SaurabFirstTest");
		test.pass("Started my test");
		
		

		String browser=value;
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			Driver = new ChromeDriver();
			test.pass("chrome started");
			
		} 
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			Driver = new FirefoxDriver();
			test.pass("firefox started");
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
			test.pass("IE started");
		}
		else {
			throw new RuntimeException("Please provide correct browser name");
		}
		

		Driver.manage().window().maximize();
		test.pass("browser maximised");

		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		test.pass("URL successfully opened");
	}

	@AfterTest
	public void afterTest() {
		test.pass("Execution over");
		Driver.quit();
		extent.flush();
	}

}
