package sumat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministracionDeContribuyentesPage extends BasePage{
	
	private By Documento_box = By.name("_CONTDOCTPO");
	private By Documento_num = By.name("_CONDOC");
	private By Documento_ver = By.name("_CONDIGVER");
	private By RazonSocial = By.name("_CONRAZSOC");
	private By Denominacion = By.name("_CONDEN");
	private By Button_Buscar = By.name("SEARCHBUTTON");
	private By Button_NuevoContribuyente = By.id("NUEVOCONTRIBUYENTE");
	private By Button_Actualizar = By.id("K2BREFRESH");
	

	
	public AdministracionDeContribuyentesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//25693931
	public void UtilizarFiltroTIPO(String tipo) {		
		writeText(Documento_box, tipo);
		click(Button_Buscar);
		
	}
	/**
	 * Recibe un DNI y lo compara contra los resultados del filtro.
	 * @param comparar_DNI
	 */
	public boolean Resultados(String comparar_DNI) {
		WebElement Tabla_Resultados = driver.findElement(By.id("GRID1"));
		List<WebElement> Columna_Documento = Tabla_Resultados.findElements(By.className("ReadonlyK2BGridAttribute"));	
		for(WebElement e : Columna_Documento) {
			if(e.getText().equalsIgnoreCase(comparar_DNI)) {
				return true;
			
			}			
			
		}
		return false;
	}
	
	public void UtilizarFiltroDOCUMENTO(String Documento) {
		writeText(Documento_num, Documento);
		click(Button_Buscar);
	}
	
	

}
/*
 * //Grab the table
		WebElement table = driver.findElement(By.id("detailpanel_1"));
		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		 * 
		 * ReadonlyK2BGridAttribute
 */
