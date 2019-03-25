package my.auto.com.AutomationPractice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoItUtility {

	WebDriver driver;

	@Test
	public void f() throws IOException {

		WebElement username= driver.findElement(By.id("user_login"));
        username.sendKeys("admin");
        WebElement password=  driver.findElement(By.name("pwd"));
        password.sendKeys("demo123");
        WebElement loginButn=  driver.findElement(By.xpath("//input[@type='submit']"));
        loginButn.click();      
        WebElement clickPost=  driver.findElement(By.xpath("//div[text()='Posts']"));
        clickPost.click();
        WebElement clickAddnew=  driver.findElement(By.xpath("//a[text()='Add New'][@href='post-new.php']"));
        clickAddnew.click();
        
        WebElement clickSetimage=  driver.findElement(By.xpath("//button[text()='Set Image']"));
        clickSetimage.click();
        
        WebElement clickUploadFiles=  driver.findElement(By.xpath("//a[text()='Upload Files']"));
        clickUploadFiles.click();
        
        WebElement clickSelectFiles=  driver.findElement(By.xpath("//button[text()='Select Files']"));
        clickSelectFiles.click();
        
        Runtime.getRuntime().exec("Resource/UploadFileScript.exe"+" "+"\\Resource\\Capture.PNG");
	}

	@BeforeTest
	public void b() {
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void c() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
