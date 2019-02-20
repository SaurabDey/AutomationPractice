package my.auto.com.AutomationPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	@FindBy (id="id_gender1")
	WebElement genderRadioButton;
	
	@FindBy(name="customer_firstname")
	WebElement FirstnameTextBox;
	
	@FindBy(name="customer_lastname")
	WebElement LastnameTextBox;
	
	@FindBy (name="passwd")
	WebElement passwordTextBox;
	
	@FindBy (id="days")
	WebElement selectDay;
	
	@FindBy(id="months")
	WebElement selectMonth;
	
	WebDriver Driver;
	public RegistrationPage(WebDriver driver2) {
		Driver=driver2;
		PageFactory.initElements(Driver, this);
	}
	public void registration() throws IOException {
		
		ExcelReadWrite erw= new ExcelReadWrite();
		String[] myValues =erw.readExcel();
		
		System.out.println("Ragistration page");
		
		genderRadioButton.click();

		FirstnameTextBox.sendKeys(myValues[0]);

		System.out.println("welcome ");
		LastnameTextBox.sendKeys(myValues[1]);
	
		passwordTextBox.sendKeys(myValues[2]);

		Select DayButton = new Select(selectDay);
		DayButton.selectByIndex(23);

		Select monthsButton = new Select(selectMonth);
		monthsButton.selectByIndex(10);
	}
}
