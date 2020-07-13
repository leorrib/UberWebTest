package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelSpecs {

	By name = By.cssSelector("[data-identity*='name'] div div");
	By location = By.cssSelector("[placeholder]");
	By correct_address;
	By origin_displayed = By.cssSelector("[data-test*='pickup'] span");
	By dest_displayed = By.cssSelector("[data-test='drop-text'] span");
	By request = By.cssSelector("[data-test*='req'] button");
	By request_confirmation = By.cssSelector("div[data-test='top-section-container'] div");
	By cancel = By.xpath("//button[text()='Cancel trip request']");
	By cancel_confirmation = By.xpath("//button[text()='Yes, Cancel']");

	public WebDriver driver;

	public TravelSpecs(WebDriver driver) {
		this.driver = driver;
	}

	public void selectingLocation( String st_address, String neighborhood) {
		correct_address = By.xpath("//*[contains(text(),'" + neighborhood + "')]");
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOfElementLocated(location));
		driver.findElement(location).sendKeys(st_address);
		driver.findElement(correct_address).click();
	}

	public String getDisplayedOrigin() {
		return driver.findElement(origin_displayed).getText().toLowerCase();
	}

	public String getDisplayedDestination() {
		return driver.findElement(dest_displayed).getText().toLowerCase();
	}
	
	public String getDisplayedName() {
		return driver.findElement(name).getText();
	}
	
	public String getRequestType() {
		return driver.findElement(request).getText();
	}
	
	public void clickRequest() {
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(request)));
		driver.findElement(request).click();
	}
	
	public String getRequestConfirmation() {
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOfElementLocated(cancel));
		return driver.findElement(request_confirmation).getText();
	}
	
	public void cancelRequest() {
		try {
			driver.findElement(cancel).click();
			driver.findElement(cancel_confirmation).click();
		} 
		catch (org.openqa.selenium.StaleElementReferenceException error) {
			driver.findElement(cancel).click();		
			try {
				driver.findElement(cancel_confirmation).click();
			}
			catch (org.openqa.selenium.StaleElementReferenceException err) {
				driver.findElement(cancel_confirmation).click();
			}		
		}	
	}
}
