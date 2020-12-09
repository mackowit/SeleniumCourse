package basicweb;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import usefulmethods.GenericMethods;

public class ScreenShotDemo {

	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://facebook.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		String fileName = getRandomString(10) + ".png";
		String directory = System.getProperty("user.dir") + "\\screenshots\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		//driver.quit();
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.id("u_0_h")).click();
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
		
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String chars = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
		for(int i = 0; i < length; i++) {
			int index = (int)(Math.random() * chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

}
