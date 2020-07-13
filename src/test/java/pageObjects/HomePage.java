package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
 
	By login = By.cssSelector("li:nth-child(3) button[data-baseweb='button'] div");
	By user_login = By.cssSelector("div:nth-child(4) div:nth-child(3) h2");

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private void SignIn() {
		driver.findElement(login).click();
	}
	
	private void UserSignIn() {
		driver.findElement(user_login).click();
	}
	
	public void SignInAsUser() {
		SignIn();
		UserSignIn();
	}
	
	
}
