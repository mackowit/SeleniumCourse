package pageclasses;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkTestCase {

	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		searchPage = new SearchPageFactory(driver);
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test() {
		searchPage.clickFlightsTab();
		searchPage.clickRoundtrip();
		searchPage.clickFromLocationTrigger();
	}

}
