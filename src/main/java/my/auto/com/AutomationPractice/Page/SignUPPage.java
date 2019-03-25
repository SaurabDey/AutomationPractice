package my.auto.com.AutomationPractice.Page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SignUPPage{
	static Logger log = Logger.getLogger(SignUPPage.class);
	
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
		
		//database code
//		DBClass db= new DBClass();
//		String emailFromDB=db.getDataFromDB();
		
		//test.info("inside Sign up method -------");
		log.info("we are inside signUp method");
		
		SigninButton.click();

		EmailaddressTextBox.sendKeys("saurab");

		CreateanaccountButton.click();
		
		log.info("end of signUp method");
		
		//test.info("completed Sign up method------");

	}
}
