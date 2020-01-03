package sumat.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import sumat.pages.AdministracionDeContribuyentesPage;
import sumat.pages.HomePage;
import sumat.pages.LoginPage;

public class AdministracionDeContribuyentesTest extends BaseTest{
	
	
	@Test(enabled = true) 
	public void Filtro_Tipo() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		AdministracionDeContribuyentesPage adm =  homepage.SiMatMenu("Administración de Contribuyentes");
		adm.UtilizarFiltroTIPO("V");
		Assert.assertEquals(adm.Resultados("25693931"), false);  
	}
	
	@Test(enabled = true) 
	public void Filtro_Documento() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v25693931");
		loginpage.completePassword("simat123");
		HomePage homepage = loginpage.clickOnLoginButton();
		AdministracionDeContribuyentesPage adm =  homepage.SiMatMenu("Administración de Contribuyentes");
		adm.UtilizarFiltroDOCUMENTO("25693931");
		adm.Resultados("25693931"); 
	}
}
