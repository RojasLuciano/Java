package sumat.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sumat.pages.HomePage;
import sumat.pages.LoginPage;
import sumat.pages.Contribuyentes.AdministracionDeContribuyentesPage;

public class LoginTest extends BaseTest{

	@Test(enabled = false)
	public void successful_login() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		Assert.assertEquals(loginpage.getActualURL(), "http://simattemp.ex-cle.com/simat_web_test/servlet/hiniciologin");
		
		
	}
	
	@Test(enabled = false)
	public void failed_login() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("qweqw");
		loginpage.completePassword("sqweqweimat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		
	}
	
	
	
	
	
	 
	
	
	
	
}
