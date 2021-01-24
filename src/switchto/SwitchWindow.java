package switchto;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulmethods.GenericMethods;

public class SwitchWindow {

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
		
		
		//get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		
		//find open window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		//get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//switching between handles
		for (String handle: handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("python");
				Thread.sleep(3000);
				driver.close();
				break;
			}
		}
		//switch back to parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("ebi");
	}

}
