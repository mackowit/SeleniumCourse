package usefulmethods;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsefulMethodsTest {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement buttonElement = driver.findElement(By.id("opentab"));
		String elementText = buttonElement.getText();
		String elementClass = buttonElement.getAttribute("class");
		
		boolean result;
		List<WebElement> elementsList = driver.findElements(By.id("opentab"));
		if(elementsList.size() > 0) {
			System.out.println("ElementsList size is: " + elementsList.size());
			result = true;
		}
		else result = false;
		
		System.out.println(elementText +"\n" + elementClass + "\n" + result);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
