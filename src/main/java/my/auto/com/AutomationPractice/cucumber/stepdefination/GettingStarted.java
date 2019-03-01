package my.auto.com.AutomationPractice.cucumber.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.auto.com.AutomationPractice.Page.RegistrationPage;
import my.auto.com.AutomationPractice.Page.SignUPPage;

public class GettingStarted {
	WebDriver Driver;
	@Given("^I have the site$")
	public void i_have_the_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.navigate().to("http://demosite.center/wordpress/wp-login.php?");

	}

	@When("^I provide (\\w+) and (\\w+)$")
	public void i_want_provide_username_and_password(String x, String y) throws Throwable {
	    
		Driver.findElement(By.id("user_login")).sendKeys(x);
		Driver.findElement(By.id("user_pass")).sendKeys(y);
		Driver.findElement(By.id("wp-submit")).click();
		Driver.findElement(By.xpath("//div[text()='Posts']")).click();
		Driver.findElement(By.xpath("//a[text()='All Posts']")).click();
	}

	@Then("^I should get logged in$")
	public void i_should_get_logged_in() throws Throwable {
		Driver.quit();
	}

	@When("^I provide incorrect (\\w+) and (\\w+)$")
	public void i_want_provide_incorrect_username_and_password(String x, String y) throws Throwable {
		Driver.findElement(By.id("user_login")).sendKeys(x);
		Driver.findElement(By.id("user_pass")).sendKeys(y);
		Driver.findElement(By.id("wp-submit")).click();
	}

	@Then("^I should not get logged in$")
	public void i_should_not_get_logged_in() throws Throwable {
		Driver.quit();
	}
	
	
	@When("^I provide incorrect username and correct password$")
	public void xyz() throws Throwable {
	    
		SignUPPage sign = new SignUPPage(Driver);
		sign.signUp();
	}
	
	@When("^I provide correct username and incorrect password$")
	public void sda() throws Throwable {
	    
		SignUPPage sign = new SignUPPage(Driver);
		sign.signUp();
	}

	
	@When("^I provide both incorrect username and password$")
	public void met()
	{
		SignUPPage sign = new SignUPPage(Driver);
		sign.signUp();
	}
}
