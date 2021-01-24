package javascriptexecution;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulmethods.GenericMethods;

public class JavascriptExecution {

	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	@Test
	public void test() throws Exception {
		//driver.get(baseUrl);
		//opening url with js
		js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice';");
		//WebElement textBox = driver.findElement(By.id("name"));
		//finding element by js
		Thread.sleep(10000);
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
		textBox.sendKeys("test");
		//retreving height of the window
		long height = (long) js.executeScript("return window.innerHeight");
		System.out.println(height);
		//scroll down
		js.executeScript("window.scrollBy(0, 1900);");
		Thread.sleep(2000);
		//scroll up
		js.executeScript("window.scrollBy(0, -1900);");
		Thread.sleep(2000);
		//scroll into particular element
		WebElement element = driver.findElement(By.id("hide-textbox"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -90);");
		Thread.sleep(2000);
		//clicking with js
		js.executeScript("arguments[0].click();", element);
	}

}
