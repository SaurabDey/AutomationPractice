package my.auto.com.AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import my.auto.com.AutomationPractice.Page.SignUPPage;

public class MainLog4j {

	WebDriver Driver;

	static Logger log = Logger.getLogger(MainLog4j.class);

	@BeforeTest
	public void start() {

		// BasicConfigurator.configure();
		PropertyConfigurator.configure("Resource/log4j.properties");
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		Driver = new ChromeDriver();
		log.debug("debug messsage-----------");
		log.info("browser started successfully");
		log.warn("warn messsage-----------");
		log.error("error messsage-----------");
		log.fatal("fatal messsage-----------");

		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		log.info("URL opened successfully");
	}

	@Test
	public void login() {

		try {

			SignUPPage sign = new SignUPPage(Driver);
			sign.signUp();

			log.info("SignUPPage was successfully executed");
		} catch (Exception e) {
			log.error("SignUPPage has some error");
		}
	}

	@AfterTest
	public void teardown() {

		Driver.quit();
		log.info("closing the browser");

	}

}
