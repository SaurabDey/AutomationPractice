package my.auto.com.AutomationPractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import my.auto.com.AutomationPractice.Page.RegistrationPage;
import my.auto.com.AutomationPractice.Page.SignUPPage;
import my.auto.com.AutomationPractice.utilities.CommonUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class GRIDClass {
	WebDriver Driver;
	ExtentReports extent;
	ExtentTest test;
	@Test
	public void f() throws IOException {

		CommonUtility common = new CommonUtility(Driver);
		
			SignUPPage sign = new SignUPPage(Driver,test);
			sign.signUp();

			RegistrationPage regis = new RegistrationPage(Driver);
			regis.registration();		

	}

	@Parameters("browserName")
	@BeforeTest
	public void beforeTest(String value) throws MalformedURLException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Resource/ExtentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		test = extent.createTest("BrowserTest");
		test.info("Started my test");
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setBrowserName(value);

		Driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		Driver.manage().window().maximize();
		

		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		
	}

	@AfterTest
	public void afterTest() {		
		Driver.quit();
		test.info("Ended my test");
		extent.flush();
	}

}
