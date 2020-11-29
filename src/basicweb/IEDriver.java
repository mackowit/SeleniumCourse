package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEDriver {

	public static void main(String[] args) {
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Samsung\\eclipse-workspace\\libs\\selenium\\drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		String baseURL = "http://www.google.com";
		driver.get(baseURL);
			
			// Even if you have windows 64-bit version, please download IEDriverServer 32-bit version
			// All protected zones settings should be same (Disabled / Enabled)
			// Zoom Level should be 100%
			// Use Desired Capabilities class to set IE properties
			/*	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
				driver = new InternetExplorerDriver(caps);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				*/
	}

}
