package common_actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CommonFunctions {
	
	public static WebDriver driver = null;
	public static Properties properties = null;

	static Logger logger = Logger.getLogger(CommonFunctions.class);
	
	
	public Properties loadPropertyFile() throws IOException {
	FileInputStream stream = new FileInputStream("config.properties");
	properties = new Properties();
	properties.load(stream);
	return properties;
	
	
	}
	@BeforeSuite
	public void OpenBrowser() throws IOException {
		
		//Configure log4j 
		PropertyConfigurator.configure("log4j.properties");
		
		//Load property file first before opening the browser
		logger.info("Orange HRM TEST begins.....");
		
		loadPropertyFile();
		
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverlocation = properties.getProperty("driverlocation");
		
		//Launch Chrome browser
		logger.info("Opening Chrome browser....");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver = new ChromeDriver();
			
		} 
		//Launch Firefox browser
		
		else if (browser.equalsIgnoreCase("firefox")) {
			logger.info("Opening Firefox browser..");
			System.setProperty("webdriver.gecko.driver", driverlocation);
			driver = new FirefoxDriver();
		}
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Maximize the screen
		logger.info("Maximize the screen");
		driver.manage().window().maximize();
		//Navigating to the url
		logger.info("Navigating to the application");
		driver.get(url);
		
		

	}
	
	@AfterSuite
	
	public void tearDown() {
		logger.info("Closing the browser");
		driver.quit();
	}
}
