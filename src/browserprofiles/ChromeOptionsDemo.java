package browserprofiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

	public static void main(String[] args) {
		String baseUrl = "http://www.google.com";
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Samsung\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gbmdgpbipfallnflgajpaliibnhdgobh\\0.18.0_0.crx"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(baseUrl);

	}

}
