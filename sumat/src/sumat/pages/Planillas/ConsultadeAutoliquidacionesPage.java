package sumat.pages.Planillas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sumat.pages.BasePage;

public class ConsultadeAutoliquidacionesPage extends BasePage{

	public ConsultadeAutoliquidacionesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private boolean validar_mensaje() {	
		WebElement error = FindWebElementBy_className("ErrorViewer");
		if(error.isDisplayed()) {
			System.out.println(error.getText());
		}
		return false;
	}
	
	public void InmueblesUrbanos() {
		FindWebElementBy_ID("INM").click();
		validar_mensaje();
	}
	
	public void JuegosApuestasLIcitas() {
		FindWebElementBy_ID("JAL").click();
		validar_mensaje();
	}
	
	public void IndustriayComercio() {		
		FindWebElementBy_ID("IYC").click();
		validar_mensaje();
	}
		
	public void RetencionIndustriaYComercio() {
		FindWebElementBy_ID("RET").click();
		validar_mensaje();
	}

}
