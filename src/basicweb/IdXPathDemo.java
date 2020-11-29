package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdXPathDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://learn.letskodeit.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		//driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		//driver.findElement(By.xpath("//a[@href='/pages/practice']")).click();
		//driver.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label/input[@id='bmwradio']")).click();
		//driver.findElement(By.id("user_email")).sendKeys("letskode@gmail.com");
		//driver.findElement(By.name("enter-name")).sendKeys("macko");
		//driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Pract")).click();
		//driver.findElement(By.className(className));
		driver.findElement(By.cssSelector("#radio-btn-example")).click();
	}
	
}
