package findalllinks;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindLinks {

	private WebDriver driver;
	private String baseUrl;;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//ul[@id='uitk-tabs-button-container']/li[2]")).click();
		List<WebElement> linksList = clickableLinks(driver);
		for (WebElement link : linksList) {
			String href = link.getAttribute("href");
			try {
			String status = linkStatus(new URL(href));
			System.out.println(status);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		//elements with tak <a>
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		//elements with tag <img>
		elements.addAll(driver.findElements(By.tagName("img")));
		
		//if elements have att href="" it means that this is link so add them to linksToClick
		for (WebElement e : elements) {
			if(e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}

	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
