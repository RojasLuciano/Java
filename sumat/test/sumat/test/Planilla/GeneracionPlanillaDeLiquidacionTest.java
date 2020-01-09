package sumat.test.Planilla;

import org.testng.annotations.Test;

import sumat.pages.HomePage;
import sumat.pages.LoginPage;
import sumat.pages.Contribuyentes.AdministracionDeContribuyentesPage;
import sumat.pages.Planillas.GenerarPlanillaDeLiquidacionPage;
import sumat.test.BaseTest;

public class GeneracionPlanillaDeLiquidacionTest extends BaseTest {
	
	@Test
	public void test() {	LoginPage loginpage = new LoginPage(driver);
	loginpage.goSumatHome();
	loginpage.completeUserName("v37933047");
	loginpage.completePassword("excle2020");
	HomePage homepage = loginpage.clickOnLoginButton();
	AdministracionDeContribuyentesPage adm =  homepage.administracionDeContribuyentesPage("Generar planilla de liquidación");
		GenerarPlanillaDeLiquidacionPage gp = new GenerarPlanillaDeLiquidacionPage(driver);
		gp.AseoUrbano();
		gp.JuegosApuestasLIcitas();
		gp.ExpendioDeBebidasAlcoholicas();
		gp.EspectaculosPublicos();
		gp.IndustriayComercio();
		gp.Vehiculos();
		gp.PublicidadPropagandaComercial();
	}
	
	

}
 