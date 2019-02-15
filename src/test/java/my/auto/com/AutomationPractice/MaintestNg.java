package my.auto.com.AutomationPractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void f() throws IOException {

		CommonUtility common = new CommonUtility(Driver);
		try {
			SignUPPage sign = new SignUPPage(Driver);
			sign.signUp();
			test.pass("signUp method was successful");
		} catch (Exception e) {
			test.fail("error in signUp method ").addScreenCaptureFromPath(common.screenshot("problem1"));
		}

		try {
			RegistrationPage regis = new RegistrationPage(Driver);
			regis.registration();
			test.pass("registration method was successful");
		} catch (Exception e) {
			
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshot("newway")).build();
			test.fail("error in registration method ", mediaModel);
		}

	}

	@Parameters("browserName")
	@BeforeTest
	public void beforeTest(String value) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Resource/ExtentReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(true);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("SaurabFirstTest");
		test.info("Started my test");

		String browser = value;

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			Driver = new ChromeDriver();
			test.info("chrome started");

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			Driver = new FirefoxDriver();
			test.info("firefox started");
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
			test.info("IE started");
		} else {
			throw new RuntimeException("Please provide correct browser name");
		}

		Driver.manage().window().maximize();
		test.info("browser maximised");

		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		test.info("URL successfully opened");
	}

	@AfterTest
	public void afterTest() {
		test.info("Execution over");
		Driver.quit();
		extent.flush();
	}

}
