package basicweb;

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

import usefulmethods.GenericMethods;
import utilities.WaitTypes;

public class CalendarSelection {
	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

	//@Test
	public void test() {
		driver.get("http://www.expedia.com");
		//click the Going to button
		driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();
		driver.findElement(By.id("location-field-destination")).sendKeys("Kraków");
	
		gm.clickWhenReady(By.xpath("//div[@id='location-field-destination-menu']/div[2]//li[2]/button"), 5);
		//driver.findElement(By.xpath("//div[@id='location-field-destination-menu']/div[2]//li[2]/button")).click();
		driver.findElement(By.id("d1-btn")).click();
		driver.findElement(By.xpath("//div[@class='uitk-new-date-picker-month'][position()=1]//button[@data-day='6']")).click();
		driver.findElement(By.xpath("//div[@class='uitk-new-date-picker-month'][position()=1]//button[@data-day='10']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'uitk-new-date-picker-menu-footer')]/button")).click();
		driver.findElement(By.xpath("//button[@data-testid='submit-button']")).click();
	}

	@Test
	public void test2() throws InterruptedException {
		driver.get("https://www.goibibo.com");
		String partialText = "Del";
		String textToSelect = "Delhi, India(DEL)";
		
		WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));
		textField.sendKeys(partialText);
		
		WebElement ulElement = driver.findElement(By.id("react-autosuggest-1"));
		String innerHTML = ulElement.getAttribute("innerHTML");
		
		List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
		Thread.sleep(3000);
		
		for(WebElement element : liElements) {
			if(element.getText().contains(textToSelect)) element.click();
			break;
		}
	}
}
