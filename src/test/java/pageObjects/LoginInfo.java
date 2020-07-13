package pageObjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginInfo {
 
	By cell_number = By.id("mobile");
	By next_button = By.id("next-button");
	By sms_code = By.id("smsOTP");
	By password = By.id("password");
	
	public WebDriver driver;
	
	public LoginInfo(WebDriver driver) {
		this.driver = driver;
	}
	
	private void enterCellNumber(String number) {
		driver.findElement(cell_number).sendKeys(number);
	}
	
	private void clickNext() {
		driver.findElement(next_button).click();
	}
	
	private void enterCode() {
		System.out.println("Please, insert SMS code and press 'Enter': ");
		try(Scanner scan = new Scanner(System.in)){
			String code = scan.nextLine();
			driver.findElement(sms_code).sendKeys(code);
		}
	}
		
	private void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	
	public void InputingUserInfo(String number, String pass) {
		enterCellNumber(number);
		clickNext();
		enterCode();
		clickNext();
		enterPassword(pass);
		clickNext();
	}
}
