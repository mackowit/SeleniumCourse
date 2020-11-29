package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWin {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\eclipse-workspace\\libs\\selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://www.letskodeit.com";
		driver.get(baseURL);

	}

}
