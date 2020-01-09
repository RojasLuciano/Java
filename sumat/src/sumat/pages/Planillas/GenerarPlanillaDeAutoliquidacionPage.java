package sumat.pages.Planillas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sumat.pages.BasePage;

public class GenerarPlanillaDeAutoliquidacionPage extends BasePage{
	
	private By table = By.id("K2BTABLETRNGENERALDATA");
	private By INM = By.name("CUENTAINM");
	private By IYC = By.name("IYC");
	private By JAL = By.name("JAL");
	private By RET = By.name("RET");
	private By Button_Anterior = By.name("ANTERIOR");
	private By Button_Siguiente = By.name("SIGUIENTE");
	
	

	public GenerarPlanillaDeAutoliquidacionPage(WebDriver driver) {
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
	
	
	public void INM() {
		FindWebElementBy_ID("INM").click();
		validar_mensaje();
	}
	
	public void IYC() {
		FindWebElementBy_ID("IYC").click();
		validar_mensaje();
	}
	
	public void JAL() {
		FindWebElementBy_ID("JAL").click();
		validar_mensaje();
	}
	
	public void RET() {
		FindWebElementBy_ID("RET").click();
		validar_mensaje();
	}
	
	
	
	

	
	
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	private Select getSelect() {		
		return new Select(driver.findElement(By.name("_PADCOD")));
	}
	
	private void SelectVisible(String text) {
		getSelect().selectByVisibleText(text);
	}
	/**
	 * 	Recibe por parametro una string con la cuenta a buscar
	 * @param txt
	 * @return la cuenta completa.
	 * y realiza un scroll hasta la misma.
	 */
	private String devolver_cadena_cuenta(String txt) {
		String cadena_completa=null;
		WebElement test = driver.findElement(By.name("_PADCOD"));
		List<WebElement> li = test.findElements(By.tagName("option"));
		for(WebElement e : li) {
			if(e.getText().contains(txt)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
				cadena_completa = e.getText();
			}
		}
		
		return cadena_completa;
	}
	

	public void BuscarCuenta(String txt) {
		waitVisibility(By.name("_PADCOD"));
		WebElement test = driver.findElement(By.name("_PADCOD"));
		test.click();
		SelectVisible(devolver_cadena_cuenta(txt));
	
	}
	
	

	
	
	

}//final
