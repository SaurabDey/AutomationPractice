package my.auto.com.AutomationPractice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
<<<<<<< HEAD
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
=======

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import my.auto.com.AutomationPractice.Page.RegistrationPage;
import my.auto.com.AutomationPractice.Page.SignUPPage;
import my.auto.com.AutomationPractice.utilities.CommonUtility;

/**
 * @author Lenovo
 *
 */

public class MaintestNg {
	WebDriver Driver;
	/**
	 * @author Saurab
	 * make ExtentHtmlReporter ExtentReports static to get parallel report
	 */
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	ExtentTest test;
>>>>>>> cd8548e63208d327506b23bcc0ef972a31487549

	@Test
	public void f() {

<<<<<<< HEAD
		SignUPPage sign = new SignUPPage(Driver);
		sign.signUp();
=======
		CommonUtility common = new CommonUtility(Driver);
		try {
			SignUPPage sign = new SignUPPage(Driver,test);
			sign.signUp();
			test.pass("signUp method was successful");
		} catch (Exception e) {
			test.fail("error in signUp method ").addScreenCaptureFromPath(common.screenshot("problem1"));
		}
>>>>>>> cd8548e63208d327506b23bcc0ef972a31487549

		RegistrationPage regis = new RegistrationPage(Driver);
		regis.registration();

	}

	@Parameters("browserName")
	@BeforeTest
	public void beforeTest(String value) {

<<<<<<< HEAD
		String browser=value;
		
=======
		htmlReporter = new ExtentHtmlReporter("Resource/MakeReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(true);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		/**
		 * @author Saurab
		 * this is create new test for each browser
		 */
		test = extent.createTest("Test "+value);
		test.info("Started my test");

		String browser = value;

>>>>>>> cd8548e63208d327506b23bcc0ef972a31487549
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
<<<<<<< HEAD
=======
		
	}
	
	/**
	 * @author Saurab
	 * flush using @AfterSuite will generate the parallel report
	 */
	@AfterSuite
	public void afterSuite() {
		extent.flush();
>>>>>>> cd8548e63208d327506b23bcc0ef972a31487549
	}
	

}
