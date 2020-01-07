package sumat.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sumat.pages.GenerarPlanillaDeAutoliquidacionPage;
import sumat.pages.HomePage;
import sumat.pages.LoginPage;

public class GenerarPlanillaDeAutoliquidacionTest extends BaseTest{
	
	@Test
	public void test() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		GenerarPlanillaDeAutoliquidacionPage gp = homepage.generarPlanillaDeAutoliquidacion("Generar planilla de autoliquidación");
		WebElement self = driver.findElement(By.id("INM"));
		self.click();
		
	}

}
