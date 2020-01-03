package sumat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	private By campoID = By.name("_DOCUMENTO");
	private By campoPASSWORD = By.name("_USERPASSWORD");
	private By botonINGRESAR = By.name("LOGIN2");
	private String url = "http://simattemp.ex-cle.com/simat_web_test/servlet/hlogin";
	private By FailedLogin = By.xpath("span[text()='El Usuario se encuentra bloqueado.']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void goSumatHome() {
		driver.get(url);
	}
	
	
	public void completeUserName(String name) {
		waitVisibility(campoID);
		driver.findElement(campoID).sendKeys(name);
	}
	public void completePassword(String password) {
		waitVisibility(campoPASSWORD);
		driver.findElement(campoPASSWORD).sendKeys(password);
	}
	public HomePage clickOnLoginButton() {
		waitVisibility(botonINGRESAR);
		driver.findElement(botonINGRESAR).click();
		return new HomePage(driver);
	}
	
	public String getActualURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	public String get_failedLogin() {
		waitVisibility(FailedLogin);
		return "true";
	}
	
	
	

}
