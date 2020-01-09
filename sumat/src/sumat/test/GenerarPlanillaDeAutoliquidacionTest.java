package sumat.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import sumat.pages.DB_SUMAT;
import sumat.pages.GenerarPlanillaDeAutoliquidacionPage;
import sumat.pages.HomePage;
import sumat.pages.LoginPage;

public class GenerarPlanillaDeAutoliquidacionTest extends BaseTest{
	
	@Test(enabled = false)
	public void test() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		GenerarPlanillaDeAutoliquidacionPage gp = homepage.generarPlanillaDeAutoliquidacion("Generar planilla de autoliquidación");
		WebElement INM = driver.findElement(By.id("INM"));
		WebElement IYC = driver.findElement(By.id("IYC"));
		IYC.click();
		try {
			WebElement error = driver.findElement(By.className("ErrorViewer"));
			System.out.println(error.getText());
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Test(enabled = false)
	public void dbtest() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		GenerarPlanillaDeAutoliquidacionPage gp = homepage.generarPlanillaDeAutoliquidacion("Generar planilla de autoliquidación");
		DB_SUMAT DB = new DB_SUMAT();
		DB.connect();
		DB.Habilitar_Deshabilitar(0);
		
		
		gp.BuscarCuenta("00PB02");
		
		
		
//		00PB02   - R42792

		
		
		 
		 
		  
		 
		
		
		
	}
	
	@Test(enabled = true)
	public void simple() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		GenerarPlanillaDeAutoliquidacionPage gp = homepage.generarPlanillaDeAutoliquidacion("Generar planilla de autoliquidación");
		DB_SUMAT DB = new DB_SUMAT();
		DB.connect();
		DB.Habilitar_Deshabilitar(0);
		gp.INM();
		gp.IYC();
		gp.JAL();
		gp.RET();
	
	}
	

}
