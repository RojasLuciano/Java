package sumat.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import sumat.pages.DB_SUMAT;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		// Create a Chrome driver. All test classes use this.
		System.setProperty("webdriver.gecko.driver", "res\\geckodriver.exe");
		driver = new EventFiringWebDriver(new FirefoxDriver(getChromeOptions()));
		
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();		
	}

	@BeforeMethod
	private void waitForLoad() {
	    new WebDriverWait(driver, 5).until( webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
}
	
	private FirefoxOptions getChromeOptions() {
		FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("disable-infobars");
		options.setHeadless(false);
		return options;
	}

	

}// final
