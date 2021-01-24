package actionsclass;

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
import org.openqa.selenium.interactions.Actions;

import usefulmethods.GenericMethods;

public class MouseHoverActions {

	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	JavascriptExecutor jse;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		jse = (JavascriptExecutor)driver;
		
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
		jse.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(3000);
		
		WebElement mainElement = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(3000);
		
		WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		subElement.click();
		
	}

}
