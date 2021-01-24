package switchto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulmethods.GenericMethods;

public class JSPopUp {

	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys("ebi");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	


}
