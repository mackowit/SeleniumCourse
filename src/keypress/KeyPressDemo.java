package keypress;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressDemo {

	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/p/practice";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		//Thread.sleep(3000);
		//driver.quit();
	}

	//@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("test@mail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.id("user_password")).sendKeys("password");
		Thread.sleep(3000);
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}

	//@Test
	public void test2() throws Exception {
		driver.get(baseUrl);
		
		//driver.findElement(By.id("name")).sendKeys("a");
		//Thread.sleep(2000);
		driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(3000);
	}
	
	@Test
	public void test3() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	}
}
