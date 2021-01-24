package testngtutorial;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Parallel_Parameters_Exercise {

	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equals("chrome"))
			driver = new ChromeDriver();
		
		baseUrl = "https://letskodeit.teachable.com";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	@Parameters({"email", "password"})
	public void testMethod(String email, String password) {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(password);
		//driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}
	
	@AfterClass
	public void afterClass() {
	}

}
