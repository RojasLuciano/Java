package sumat.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class BasePage { 
    public WebDriver driver;
    public WebDriverWait wait;

    //Todos los que hereden se llevan este
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
    	ImplicitWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void waitElement(WebElement element) {
    	ImplicitWait();
    	wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    
    public void ImplicitWait() {
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
/*
    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }
*/
}