package sumat.test.Contribuyentes;

import org.testng.annotations.Test;

import sumat.pages.DB_SUMAT;
import sumat.pages.HomePage;
import sumat.pages.LoginPage;
import sumat.pages.Contribuyentes.AdministracionDeContribuyentesPage;
import sumat.pages.Contribuyentes.AsociarUnContribuyentePage;
import sumat.test.BaseTest;

public class AsociarUnContribuyenteTest extends BaseTest{
	
	@Test
	public void Asociar_test() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goSumatHome();
		loginpage.completeUserName("v37933047");
		loginpage.completePassword("excle2020");
		HomePage homepage = loginpage.clickOnLoginButton();
		AdministracionDeContribuyentesPage adm =  homepage.administracionDeContribuyentesPage("Administración de Contribuyentes");
		AsociarUnContribuyentePage ac = adm.nuevo_contribuyente();
		DB_SUMAT db = new DB_SUMAT();
		db.connect();
		ac.Completar(db.GenerarUsuariosNoAsociados());
		ac.test(db.GenerarUsuariosNoAsociados());
		ac.PorfavorVerificarLosDatos();
		ac.ContribuyenteAsociadoConExito();
		
	}
	
	
	
	@Test
	public void pruebaDB() {
		AsociarUnContribuyentePage ac = new AsociarUnContribuyentePage(driver);
		DB_SUMAT db = new DB_SUMAT();
		db.connect();
		ac.test(db.GenerarUsuariosNoAsociados());
	}

}
