package basicweb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementState {

	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://google.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
		WebElement element = driver.findElement(By.name("q"));
		System.out.println(element.isEnabled());
		element.sendKeys("letskodeit");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
