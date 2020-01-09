package sumat.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import sumat.pages.Contribuyentes.AdministracionDeContribuyentesPage;
import sumat.pages.Planillas.ConsultadeAutoliquidacionesPage;
import sumat.pages.Planillas.GenerarPlanillaDeAutoliquidacionPage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Generar una Liquidación de Tasa")
	private By generarUnaLiquidacionDeTasa;
	private By pruebaIssue = By.name("ENTENDIDO");

	
	private void moverHasta(WebElement we) {
		Actions firstAction = new Actions(driver);
		waitElement(we);
		
		firstAction.moveToElement(we).perform();
	}

/**
 * Recibe un string que equivalga a la opcion que se desea ingresar.
 * @param Opcion
 * @return La clase equivalente a la pedida.
 */
	public AdministracionDeContribuyentesPage administracionDeContribuyentesPage(String Opcion) {
		try {
			String self = "";
		
		waitVisibility(By.className("ddsmoothmenu"));
		WebElement div = driver.findElement(By.className("ddsmoothmenu"));
		//WebElement ul = div.findElement(By.tagName("ul"));	
		List<WebElement> li = div.findElements(By.tagName("li"));
			for(WebElement e: li) {
				//moverHasta(e);
				List<WebElement> a = driver.findElements(By.tagName("a"));
					for(WebElement b: a) {
						moverHasta(b);
						self=b.getText();
						if(self.equalsIgnoreCase(Opcion)) {
							b.click();
							break;
						}
						
					}
					if(self.equalsIgnoreCase(Opcion)) {
					
						break;
					}
					
					
			} 
		 
		}catch(Exception e){
			//System.out.println(e.getMessage());
		}
		return new AdministracionDeContribuyentesPage(driver);	
	}
	
	/**
	 * Recibe un string que equivalga a la opcion que se desea ingresar.
	 * @param Opcion
	 * @return La clase equivalente a la pedida.
	 */

		public GenerarPlanillaDeAutoliquidacionPage generarPlanillaDeAutoliquidacion(String Opcion) {
			try {
				String self = "";
			WebElement div = driver.findElement(By.className("ddsmoothmenu"));
			//waitVisibility(By.className("ddsmoothmenu"));
			//WebElement ul = div.findElement(By.tagName("ul"));	
			List<WebElement> li = div.findElements(By.tagName("li"));
				for(WebElement e: li) {
					//moverHasta(e);
					List<WebElement> a = driver.findElements(By.tagName("a"));
						for(WebElement b: a) {
							moverHasta(b);
							self=b.getText();
							if(self.equalsIgnoreCase(Opcion)) {
								b.click();
								break;
							}
							
						}
						if(self.equalsIgnoreCase(Opcion)) {
						
							break;
						}
						 
						
				} 
			 
			}catch(Exception e){
				//System.out.println(e.getMessage());
			}
			return new GenerarPlanillaDeAutoliquidacionPage(driver);	
		}
	
		public ConsultadeAutoliquidacionesPage generarConsultadeAutoliquidacionesPage(String Opcion) {
			try {
				String self = "";
			WebElement div = driver.findElement(By.className("ddsmoothmenu"));
			//waitVisibility(By.className("ddsmoothmenu"));
			//WebElement ul = div.findElement(By.tagName("ul"));	
			List<WebElement> li = div.findElements(By.tagName("li"));
				for(WebElement e: li) {
					//moverHasta(e);
					List<WebElement> a = driver.findElements(By.tagName("a"));
						for(WebElement b: a) {
							moverHasta(b);
							self=b.getText();
							if(self.equalsIgnoreCase(Opcion)) {
								b.click();
								break;
							}
							
						}
						if(self.equalsIgnoreCase(Opcion)) {
						
							break;
						}
						 
						
				} 
			 
			}catch(Exception e){
				//System.out.println(e.getMessage());
			}
			return new ConsultadeAutoliquidacionesPage(driver);	
		}

}// final