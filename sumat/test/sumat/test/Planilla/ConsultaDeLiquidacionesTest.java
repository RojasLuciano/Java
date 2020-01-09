package sumat.test.Planilla;

import org.testng.annotations.Test;

import sumat.pages.HomePage;
import sumat.pages.LoginPage;
import sumat.pages.Planillas.ConsultadeAutoliquidacionesPage;
import sumat.test.BaseTest;

public class ConsultaDeLiquidacionesTest extends BaseTest{
	
	@Test
	public void liquidaciones_deshabilitadas() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v37933047");
		loginpage.completePassword("excle2020");
		HomePage homepage = loginpage.clickOnLoginButton();
		ConsultadeAutoliquidacionesPage cap =  homepage.generarConsultadeAutoliquidacionesPage("Consultar Planillas de Liquidaciones");
		
		cap.InmueblesUrbanos();
		cap.JuegosApuestasLIcitas();
		cap.IndustriayComercio();
		cap.RetencionIndustriaYComercio();
	}
}
