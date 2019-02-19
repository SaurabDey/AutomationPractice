package my.auto.com.AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SignUPPage{
	
	@FindBy (xpath="//a[@class='login'][@title='Log in to your customer account']")
	WebElement SigninButton;
	
	@FindBy(id="email_create")
	WebElement EmailaddressTextBox;
	
	@FindBy(xpath="//span[contains(.,'Create an account')]")
	WebElement CreateanaccountButton;
	
	WebDriver Driver;
	ExtentTest test;
	public SignUPPage(WebDriver driver2) {
		Driver=driver2;
		
		PageFactory.initElements(Driver, this);
	}
	public SignUPPage(WebDriver driver2, ExtentTest test) {
		Driver=driver2;
		this.test=test;
		PageFactory.initElements(Driver, this);
	}
	public void signUp() {
		
		test.info("Started signUp");
		
		SigninButton.click();

		EmailaddressTextBox.sendKeys("siddhant456chatur@gmail.com");

		CreateanaccountButton.click();
		
		test.info("Ended signUp");
	}
}
