package hooks;

import java.io.IOException;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import resources.DriverInit;

public class Hooks extends DriverInit {
	
	@BeforeSuite
	public void StartDriver() throws IOException {
		driver = initializeDriver();
	}
	
	@BeforeTest
	public void GoToHomePage() throws IOException {
		driver.get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void quitDriver() throws IOException {
		driver.quit();
	}
}