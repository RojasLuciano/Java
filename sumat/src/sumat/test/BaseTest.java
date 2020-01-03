package sumat.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Create a Chrome driver. All test classes use this.
		System.setProperty("webdriver.gecko.driver", "res\\geckodriver.exe");
		driver = new EventFiringWebDriver(new FirefoxDriver(getChromeOptions()));
		Thread.sleep(100);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	private FirefoxOptions getChromeOptions() {
		FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("disable-infobars");
		options.setHeadless(false);
		return options;
	}

}// final
