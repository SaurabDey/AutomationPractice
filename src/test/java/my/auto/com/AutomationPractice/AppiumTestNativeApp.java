package my.auto.com.AutomationPractice;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppiumTestNativeApp
{
	
//	Maven---
//	<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
//		<dependency>
//			<groupId>io.appium</groupId>
//			<artifactId>java-client</artifactId>
//			<version>6.1.0</version>
//		</dependency>
//		
		
	AndroidDriver<AndroidElement> driver;
	//AppiumDriver<WebElement> driver;

	public void enterPin()
	{
	
		for (int i = 0; i < 4; i++) {
			WebElement pin1=driver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']"));
			pin1.click();
		}
		
}
	
	public void addingExpense(String value) 
	{
	
		WebElement icon=driver.findElement(By.xpath("//android.widget.TextView[@text='"+value+"']"));
		icon.click();
		
		for (int i = 0; i < 2; i++) {
			WebElement amount=driver.findElement(By.xpath("//android.widget.FrameLayout[@index='2']"));
			amount.click();
		}
		
		WebElement save=driver.findElement(By.xpath("//android.widget.FrameLayout[@index='11']"));
		save.click();
		waitSleep(2000);
}

	public void swipeRightToLeft()
	{
		waitSleep(5000);
		    
		//TouchAction act=new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * 0.7);
		int startPoint = (int) (size.width * 0.7);
		int endPoint = (int) (size.width * 0.01);
		new TouchAction(driver).press(point(startPoint, anchor)).waitAction(waitOptions(Duration.ofSeconds(3))).moveTo(point(endPoint, anchor)).release().perform();
		//act.press(ElementOption.element(element,startPoint,anchor)).waitAction(Duration.ofSeconds(3)).moveTo(endPoint,anchor).release().perform();


	}

	public void waitSleep(int sec)
	{
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@BeforeTest
	public void beforeTest() throws MalformedURLException 
	{

		File app=new File("Resource/CoCoin.apk");
		//File app=new File("Resource/TheMallApp.apk");
		
		DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
		//desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);//just clears the app data, such as its cache
		//desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);//fullRest uninstalls the app. fullReset is generally used when you have newer versions of the app coming in fairly quickly. So with fullReset, you will always uninstall the app and then automatically install the new version.		
		//desiredCapabilities.setCapability("browserName", "chrome");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "5.1");
		desiredCapabilities.setCapability("deviceName", "Lenevo");
		desiredCapabilities.setCapability("app", app.getAbsolutePath());

		driver= new  AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver.get("https://www.facebook.com/");

	}
	
	@Test
	public void CoCoinAppCode()
	{	
		swipeRightToLeft();
		swipeRightToLeft();
		swipeRightToLeft();
		swipeRightToLeft();
		
		waitSleep(5000);
		
		enterPin();
		enterPin();

		addingExpense("Home");
		addingExpense("Lunch");
		addingExpense("Breakfast");
		
		
		WebElement menu=driver.findElement(By.id("com.nightonke.cocoin:id/content_hamburger"));
		menu.click();
		
		enterPin();
		waitSleep(5000);
	}
	
	public void mallAppCode() throws InterruptedException
	{
		WebElement menu=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.demo.amanora:id/loginGold']"));
		menu.click();
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		waitSleep(20000);
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
}
