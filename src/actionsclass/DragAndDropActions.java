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

import usefulmethods.GenericMethods;

public class DragAndDropActions {

	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://jqueryui.com/droppable";
		
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
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		//drag'n'drop
		//action.dragAndDrop(fromElement, toElement).build().perform();
		
		//click hold move and drop
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		
	}

}
