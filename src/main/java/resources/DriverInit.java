package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverInit {

	public static WebDriver driver;
	public static Properties prop;
	String userDir = System.getProperty("user.dir");

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser").toLowerCase();

		switch(browserName) {
		
		case "chrome": 
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			System.setProperty("webdriver.chrome.driver", userDir + "\\drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("user-agent=mrbean");

			driver = new ChromeDriver(options);
			break;

		case "opera":
			System.setProperty("webdriver.opera.driver", userDir + "\\drivers\\operadriver.exe");

			OperaOptions oopth = new OperaOptions();
			oopth.addArguments("--start-maximized");

			driver = new OperaDriver(oopth);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", userDir + "\\drivers\\geckodriver.exe");

			FirefoxOptions fopt = new FirefoxOptions();
			fopt.addArguments("--start-maximized");
			fopt.addArguments("user-agent=mrbean");

			driver = new FirefoxDriver(fopt);
			break;

		default:
			throw new NotFoundException("Browser inválido. Por favor, escolha um navegador válido");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

}
