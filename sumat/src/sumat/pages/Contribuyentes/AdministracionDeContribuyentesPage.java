package sumat.pages.Contribuyentes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sumat.pages.BasePage;

public class AdministracionDeContribuyentesPage extends BasePage {

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

	/**
	 * Recibe un TIPO de dni y lo carga en el box de busqueda.
	 * 
	 * @param tipo
	 */
	public void UtilizarFiltroTIPO(String tipo) {
		writeText(Documento_box, tipo);
		click(Button_Buscar);

	}

	/**
	 * Recibe un DNI y lo compara contra los resultados del filtro.
	 * 
	 * @param comparar_DNI
	 */
	public boolean Resultados(String comparar_DNI) {
		WebElement Tabla_Resultados = driver.findElement(By.id("GRID1"));
		List<WebElement> Columna_Documento = Tabla_Resultados.findElements(By.className("ReadonlyK2BGridAttribute"));
		for (WebElement e : Columna_Documento) {
			if (e.getText().equalsIgnoreCase(comparar_DNI)) {
				return true;

			}

		}
		return false;
	}

	public void UtilizarFiltroDOCUMENTO(String Documento) {
		writeText(Documento_num, Documento);
		click(Button_Buscar);
	}

	public void UtilizarFiltroRAZONSOCIAL(String RazonSocial) {
		writeText(this.RazonSocial, RazonSocial);
		click(Button_Buscar);

	}
	/** 
	 * Si solo se utiliza la denomicacion no trae resultados.
	 * @param denominacion
	 */
	public void UtilizarFiltroDenominacion(String denominacion) {
		writeText(Denominacion,denominacion);
		click(Button_Buscar);
	}
	
	
	
	
	/**
	 * Recorre cada celda del resultado de la busqueda.
	 * Tengo que añadir la validacion contra la consulta a la DB.
	 */
	public void getCeldas(String razonSocial) {
		
		WebElement table = driver.findElement(By.id("GRID1"));
			List<WebElement> tr = table.findElements(By.tagName("tr"));
				for (WebElement r : tr) {
					List<WebElement> d = r.findElements(By.tagName("td"));
						for(WebElement f : d) {
							if(f.getText().equalsIgnoreCase(razonSocial)) {
							//	System.out.println(f.getText());
					
							}
			}
		}
	}



public void get_celdas_test() {
	
	WebElement table = driver.findElement(By.id("GRID1"));
		List<WebElement> tr = table.findElements(By.tagName("tr"));
			for (WebElement r : tr) {
				List<WebElement> d = r.findElements(By.tagName("td"));
					for(WebElement f : d) {
						System.out.println(f.getText());
				
		}
	}
}



public AsociarUnContribuyentePage nuevo_contribuyente() {
	click(Button_NuevoContribuyente);
	return new AsociarUnContribuyentePage(driver);
}











}//final
/*
 * //Grab the table WebElement table =
 * driver.findElement(By.id("detailpanel_1")); // Now get all the TR elements
 * from the table List<WebElement> allRows =
 * table.findElements(By.tagName("tr")); // And iterate over them, getting the
 * cells
 * 
 * ReadonlyK2BGridAttribute
 */
