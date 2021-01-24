package demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoblazeLoginTestSuite {
	
	WebDriver driver;
	String baseURL;
	String username = "mackowit";
	String password = "1234";
	
	@BeforeMethod
	public void setUp() {
		
		baseURL = "https://www.demoblaze.com";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\eclipse-workspace\\libs\\selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void testLoginPositive() throws Exception {
		
		driver.findElement(By.id("login2")).click();

		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
		
		String logOutDisplay = driver.findElement(By.xpath("//div[@id='navbarExample']//li/a[text()='Log out']")).getAttribute("style");
		String welcomeDisplay = driver.findElement(By.xpath("//div[@id='navbarExample']//li/a[text()='Welcome "+username+"']")).getAttribute("style");
			
		Assert.assertEquals(logOutDisplay, "display: block;");
		Assert.assertEquals(welcomeDisplay, "display: block;");
	}
	
	@Test
	public void testLoginWrongUsername() throws Exception {
		
		driver.findElement(By.id("login2")).click();

		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys(username + "a");
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		Assert.assertEquals(alertText, "User does not exist.");		
	}
	
	@Test
	public void testLoginWrongPassword() throws Exception {
		
		driver.findElement(By.id("login2")).click();

		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys(password + "a");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		Assert.assertEquals(alertText, "Wrong password.");		
	}
	
	@Test
	public void testLoginNoPassword() throws Exception {
		
		driver.findElement(By.id("login2")).click();

		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		Assert.assertEquals(alertText, "Please fill out Username and Password.");		
	}
	
	@Test
	public void testLoginNoUsername() throws Exception {
		
		driver.findElement(By.id("login2")).click();

		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		Assert.assertEquals(alertText, "Please fill out Username and Password.");		
	}
	
	@AfterMethod
	public void cleanUp() {
		
		driver.quit();
	}
}
