package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverWin {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Samsung\\eclipse-workspace\\libs\\selenium\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://learn.letskodeit.com";
		driver.get(baseURL);

	}

}
