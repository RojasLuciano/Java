package sumat.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Generar una Liquidación de Tasa")
	private By generarUnaLiquidacionDeTasa;
	private By pruebaIssue = By.name("ENTENDIDO");
	private WebElement divInicio = driver.findElement(By.xpath("//div[@id='smoothmenu1']/ul")); 
	
	
	
	public String getPruebaIssue() {
		String TITULO = driver.findElement(pruebaIssue).getText();
		click(pruebaIssue);
		return TITULO;

	}

	private Select seleccionarDelMenu(String opt) {
		// WebElement opcion = null;
		List<WebElement> divInicio = driver.findElements(By.xpath("//div[@id='smoothmenu1']/ul/li/a"));
		for (WebElement i : divInicio) {
			if (i.getText().equalsIgnoreCase(opt)) {
				moverHasta(i);
				return new Select(i);
			}
		}
		return null;
	}

	private void moverHasta(WebElement we) {
		Actions firstAction = new Actions(driver);
		waitElement(we);
		firstAction.moveToElement(we).perform();
	}

	public void seleccionarOpcion(String opc, String subOpcion) {
		seleccionarDelMenu(opc).selectByVisibleText(subOpcion);
	}

	public AdministracionDeContribuyentesPage SiMatMenu(String opt) {
		waitVisibility(By.xpath("//div[@id='smoothmenu1']/ul"));

		List<WebElement> subInicio = divInicio.findElements(By.tagName("a"));

		Iterator<WebElement> iterator = subInicio.iterator();
		while (iterator.hasNext()) {
			WebElement e = iterator.next();
			waitVisibility(By.partialLinkText(e.getText()));
			moverHasta(e);
			if(e.getText().equalsIgnoreCase(opt)) {
				e.click();
				break;
			}

		}
		return new AdministracionDeContribuyentesPage(driver);

	}

}// final