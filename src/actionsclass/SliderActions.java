package actionsclass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://jqueryui.com/slider";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, 50, 0).perform();
	}

}
