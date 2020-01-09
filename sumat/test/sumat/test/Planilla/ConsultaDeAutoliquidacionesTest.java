package sumat.test.Planilla;

import org.testng.annotations.Test;

import sumat.pages.HomePage;
import sumat.pages.LoginPage;
import sumat.pages.Contribuyentes.AdministracionDeContribuyentesPage;
import sumat.pages.Planillas.ConsultadeAutoliquidacionesPage;
import sumat.test.BaseTest;

public class ConsultaDeAutoliquidacionesTest extends BaseTest {

	@Test
	public void Validar_Link_Deshabilitados() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v37933047");
		loginpage.completePassword("excle2020");
		HomePage homepage = loginpage.clickOnLoginButton();
		ConsultadeAutoliquidacionesPage cap =  homepage.generarConsultadeAutoliquidacionesPage("Consultar Planillas de Autoliquidaciones");
		
		cap.InmueblesUrbanos();
		cap.JuegosApuestasLIcitas();
		cap.IndustriayComercio();
		cap.RetencionIndustriaYComercio();

	}
	
}
