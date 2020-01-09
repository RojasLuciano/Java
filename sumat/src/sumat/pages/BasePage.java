package sumat.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	// Todos los que hereden se llevan este
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	// Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		ImplicitWait();
		wait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}

	public void waitElement(WebElement element) {
		ImplicitWait();
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Click Method
	public void click(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	public void ImplicitWait() {
		new WebDriverWait(driver, 5).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	// Write Text
	public void writeText(By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	// Read Text
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	
	/**
	 * Espera a que se cargue la pagina, la visibilidad del elemento y regresa el
	 * mismo en forma de WebElement
	 * 
	 * @param txt
	 * @return
	 */
	public WebElement FindWebElementBy_ID(String txt) {
		WebElement new_web_element = null;
		try {
			new WebDriverWait(driver, 5).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;

	}

	public WebElement FindWebElementBy_className(String txt) {
		WebElement new_web_element = null;
		try {
			new WebDriverWait(driver, 5).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;

	}

	public WebElement FindWebElementBy_name(String txt) {
		WebElement new_web_element = null;
		try {
			new WebDriverWait(driver, 5).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;

	}

	/*
	 * //Assert public void assertEquals (By elementBy, String expectedText) {
	 * waitVisibility(elementBy); Assert.assertEquals(readText(elementBy),
	 * expectedText);
	 * 
	 * }
	 */
}