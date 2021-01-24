package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	
	WebDriver driver; 
	
	@FindBy(xpath="//ul[@id='uitk-tabs-button-container']/li[2]")
	WebElement flightsTab;
	
	@FindBy(xpath="//ul[@id='uitk-tabs-button-container']/div/li[1]")
	WebElement roundtrip;
	
	@FindBy(xpath="//button[@data-stid='location-field-leg1-origin-menu-trigger']")
	WebElement fromLocationTriggerButton;
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		flightsTab.click();
	}
	
	public void clickRoundtrip() {
		roundtrip.click();
	}
	
	public void clickFromLocationTrigger() {
		fromLocationTriggerButton.click();
	}
}
