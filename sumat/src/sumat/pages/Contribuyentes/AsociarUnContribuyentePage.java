package sumat.pages.Contribuyentes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import sumat.pages.BasePage;
import sumat.pages.DB_SUMAT;
import sumat.pages.DB_SUMAT.Contribuyente;

public class AsociarUnContribuyentePage extends BasePage{
	
	private By Button_Asociar = By.name("BTN_ENTER");
	private By Button_Cancelar = By.name("BTN_CANCEL");
	private By RIF_documento = By.name("_CONDOC");
	private By RIF_verificador = By.name("_CONDIGVER");
	private By mensajeExitoBy = By.id("HEADER_TRN3");
	
	
	public AsociarUnContribuyentePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 
	private Select getSelect() {		
		return new Select(driver.findElement(By.name("_DOCCOD")));
	}
	
	public void SelectVisible(String text) {
		getSelect().selectByVisibleText(text);
	}
	
	public void Completar_Cedula(String cedula) {
		writeText(RIF_documento, cedula);
		
	}

	public void Completar_Tipo(String tipo) {
		writeText(RIF_documento, tipo);
	} 
	
	public void Completar_Ver(String ver) {
		writeText(RIF_verificador, ver);
	}
	
	/**
	 * Recibe un Objeto Contribuyente y utiliza sus atributos para asociarlo.
	 * @param nuevo_contribuyente
	 */
	public void Completar(Contribuyente nuevo_contribuyente) {		
		SelectVisible(nuevo_contribuyente.getDoc_tipo());
		writeText(RIF_documento, nuevo_contribuyente.getDoc_doc());
		writeText(RIF_verificador, nuevo_contribuyente.getDoc_ver());
		click(Button_Asociar);
		click(Button_Asociar);
	}
	
	public void test(Contribuyente newC) {
		System.out.println(newC.getDoc_tipo() +" "+newC.getDoc_doc()+" "+newC.getDoc_ver());
	}
	
	public void PorfavorVerificarLosDatos() {
		WebElement table = driver.findElement(By.id("TABLE1"));
		WebElement tr = table.findElement(By.tagName("tr"));
		WebElement td = tr.findElement(By.tagName("td"));
		String aviso = td.getText();
		if(td.isDisplayed()) {
			click(Button_Asociar);
			System.out.println("Elemento porfavor encontrado");
		}
		
	}
	/**
	 * Añadir un jsExecutor que espere a que la pagina termine de cargarse.
	 */
	public void ContribuyenteAsociadoConExito() {		
	}
	
	
}//final
