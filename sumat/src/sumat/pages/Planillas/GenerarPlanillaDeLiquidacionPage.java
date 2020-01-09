package sumat.pages.Planillas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sumat.pages.BasePage;

public class GenerarPlanillaDeLiquidacionPage extends BasePage{

	
	
	private WebElement error_viewer = FindWebElementBy_className("ErrorViewer");
	
	
	public GenerarPlanillaDeLiquidacionPage(WebDriver driver) {
		super(driver);
		}
	
	private boolean validar_mensaje() {	
		WebElement error = FindWebElementBy_className("ErrorViewer");
		if(error.isDisplayed()) {
			System.out.println(error.getText());
		}
		return false;
	}
	
	public void AseoUrbano() {
		FindWebElementBy_ID("ASU").click();
		validar_mensaje();
	}
	
	public void JuegosApuestasLIcitas() {
		FindWebElementBy_ID("JAL").click();
		validar_mensaje();
	}
	
	public void ExpendioDeBebidasAlcoholicas() {
	
		FindWebElementBy_ID("EBA").click();
		validar_mensaje();
	}
	
	public void EspectaculosPublicos() {		
		FindWebElementBy_ID("DEP").click();
		validar_mensaje();
	}
	
	public void IndustriayComercio() {		
		FindWebElementBy_ID("IYC").click();
		validar_mensaje();
	}
	
	public void Vehiculos() {	
		FindWebElementBy_ID("VEH").click();
		validar_mensaje();
	}
	
	public void PublicidadPropagandaComercial() {
		FindWebElementBy_ID("PPC").click();
		validar_mensaje();
	}
	
}//final
