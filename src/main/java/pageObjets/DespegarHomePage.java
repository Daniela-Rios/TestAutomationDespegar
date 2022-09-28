package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui. WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class DespegarHomePage {
	@FindBy(xpath="//*[@class=\"login-incentive shifu-3-card -shifu-3-shadow-static -show\"]//*[@class=\"login-incentive--close shifu-3-icon-close -eva-3-mr-md\"]")
	WebElement CerrarIngresoGmail;
	@FindBy(xpath="//*[@class=\"lgpd-banner--container lgpd-banner--container_fixed\"]//*[@class=\"lgpd-banner--button eva-3-btn -white -md\"]//*[@class=\"btn-text\"]")
	WebElement CerrarBanner;
	//@FindBy(linkText="Alojamientos")
	//WebElement alojamientos_link;
	@FindBy(css = ".sbox5-box-places-ovr input")
	WebElement ingresaDestino;
	@FindBy(css = ".sbox5-box-dates-checkbox-container .sbox5-dates-input1-container")
	WebElement fechaEntrada;
	@FindBy(xpath = "//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@class=\"sbox5-monthgrid\" and "
    + "@data-month=\"2022-09\"]//*[@class=\"sbox5-monthgrid-dates sbox5-monthgrid-dates-30\"]/child::div[30]")
	WebElement ingresaFechaEntrada;
	@FindBy(css = ".sbox5-box-dates-checkbox-container .sbox5-dates-input2-container")
	WebElement fechaSalida;
	@FindBy(xpath = "//*[@class=\"sbox5-floating-tooltip sbox5-floating-tooltip-opened\"]//*[@class=\"sbox5-monthgrid\" and "
    + "@data-month=\"2022-10\"]//*[@class=\"sbox5-monthgrid-dates sbox5-monthgrid-dates-31\"]/child::div[25]")
	WebElement ingresaSalida;
	@FindBy(css = ".sbox5-floating-tooltip.sbox5-floating-tooltip-opened .calendar-footer .btn-text")
	WebElement aplicar;
	@FindBy(css = ".sbox5-3-double-input")
	WebElement habitaciones;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right")
	WebElement cantAdultos;
	@FindBy(css = ".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right")
	WebElement cantMenores;
	@FindBy(xpath = "//*[@class=\"select\"]")
	WebElement despliegaEdadMenor;
	@FindBy(xpath="//*[@class=\"select-option\" and @value=\"4\"]")
	WebElement edadMenor;
	@FindBy (css = ".distribution__container.distribution__type__rooms .stepper__room__footer  .sbox5-3-btn.-md.-primary .btn-text")
	WebElement botonAplicar;
	@FindBy (xpath="//*[@class=\"sbox5-box-button-ovr sbox5-3-btn sbox5-button -secondary -icon -lg\"]//*[@class=\"btn-text\"]")
	WebElement botonBuscar;
	@FindBy (css =".tooltip-container.-eva-3-shadow-1 .tooltip-close.eva-3-icon-close")
	WebElement cerrarCartel;
	@FindBy (css = ".results-cluster-container .accommodation-name.-eva-3-ellipsis")
	WebElement tituloHotel;
	@FindBy (css = ".results-cluster-container" )
	WebElement hotel;
	
	

	
private WebDriver driver=null;
private WebDriverWait wait;
	
    public DespegarHomePage (WebDriver driver) {
    	this.driver=driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    	PageFactory.initElements(driver, this);
    	
}
    
    
    
    

    public DespegarResultsPage searchText(String text) throws InterruptedException {
   
    	System.out.println("Cierra anuncio Gmail");
    	CerrarIngresoGmail.click();
    	CerrarBanner.click();
    	System.out.println("Selecciona la pesataña Alojamientos...");
    	List<WebElement> listaElementos = driver.findElements(By.xpath ("//ul[@class=\"header-list-products\"]/li"));
		for (int i = 0; i < listaElementos.size(); i++) {
			WebElement elemento = listaElementos.get(i);
			WebElement boton=elemento.findElement(By.xpath("//ul[@class=\"header-list-products\"]/li[1]"));
			
			boton.click();
			Assert.assertTrue(boton.isDisplayed(), "El elemento no es visible");}
    	System.out.println("Selecciona la pesataña Alojamientos...");
    	//alojamientos_link.click();
    	ingresaDestino.click();  
    	System.out.println("Ingresa el destino...");
    	this.ingresaDestino.sendKeys(text);
    	//this.ingresaDestino.sendKeys("Miami Beach, Florida, Estados Unidos");
    	Thread.sleep(2000);
    	ingresaDestino.sendKeys(Keys.CONTROL);
    	Thread.sleep(2000);
    	ingresaDestino.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	// Busca el de entrada
    	System.out.println("Clickea en fecha de ida...");
    	wait.until(ExpectedConditions.visibilityOf(fechaEntrada));
    	fechaEntrada.click();  
    	// Selecciona fecha ida
	    System.out.println("Selecciona fecha de ida 30/09/2022...");
	    wait.until(ExpectedConditions.visibilityOf(ingresaFechaEntrada));
	    ingresaFechaEntrada.click();
	  //Busca el de salida
	    System.out.println("Clickea en fecha de vuelta...");
	    wait.until(ExpectedConditions.visibilityOf(fechaSalida));
	    fechaSalida.click();  
	 // Selecciona fecha salida
	    System.out.println("Selecciona fecha de vuelta 25/10/2022...");
	    wait.until(ExpectedConditions.visibilityOf(ingresaSalida));
	    ingresaSalida.click();
	 // Aplicar
	    System.out.println("Click en aplicar...");
	    wait.until(ExpectedConditions.visibilityOf(aplicar));
	    aplicar.click();
	    // Despliega para buscar habitaciones
	    System.out.println("Despliega para buscar habitaciones...");
	    wait.until(ExpectedConditions.visibilityOf(habitaciones));
	    habitaciones.click();
		// 3 adultos
	    System.out.println("Selecciona 3 adultos...");
	    wait.until(ExpectedConditions.visibilityOf(cantAdultos));
	    cantAdultos.click();   
	    wait.until(ExpectedConditions.visibilityOf(cantAdultos));
		// 1 menor
		System.out.println("Selecciona 1 menor...");
		wait.until(ExpectedConditions.visibilityOf(cantMenores));
		cantMenores.click(); 
		wait.until(ExpectedConditions.visibilityOf(cantMenores));
		// Despliega Edad del menor
		System.out.println("Despliega Edad del menor...");
		wait.until(ExpectedConditions.visibilityOf(despliegaEdadMenor));
		despliegaEdadMenor.click();  
		wait.until(ExpectedConditions.visibilityOf(despliegaEdadMenor));
		// Selecciona la edad
		System.out.println("Selecciona la edad...");
		wait.until(ExpectedConditions.visibilityOf(edadMenor));
		edadMenor.click(); 
		wait.until(ExpectedConditions.visibilityOf(edadMenor));
		// Aplicar habitaciones
		System.out.println("Aplicar habitaciones...");
		wait.until(ExpectedConditions.visibilityOf(botonAplicar));
		botonAplicar.click(); 
		//Buscar
		System.out.println("Clickea en buscar...");
		wait.until(ExpectedConditions.visibilityOf(botonBuscar));
		botonBuscar.click();
		wait.until(ExpectedConditions.visibilityOf(botonBuscar));
		//CERRAR CARTEL
		System.out.println("Cierra el cartel");
		Thread.sleep(2000);
		cerrarCartel.click();
		Thread.sleep(2000);
		//Valida el titulo del hotel
		System.out.println("Se encontro " + tituloHotel.getText());
		wait.until(ExpectedConditions.visibilityOf(tituloHotel));
		Assert.assertTrue(tituloHotel.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(tituloHotel));
		//Selecciona el primer hotel de la lista
		System.out.println("Selecciona el primer hotel...");
		wait.until(ExpectedConditions.visibilityOf(hotel));
		hotel.click();
		Thread.sleep(2000);
		
		
		
		
		
    	return new DespegarResultsPage(this.driver);
    }
	
  
   /* public void clickAplicarHab() {
    	System.out.println("Aplicar habitaciones...");
		wait.until(ExpectedConditions.elementToBeClickable(botonAplicar));
		botonAplicar.click();
		wait.until(ExpectedConditions.elementToBeClickable(botonAplicar));
		
	
   }
    
    
    public void clickBuscar() {
    	//System.out.println("Clickea en buscar...");
    	wait.until(ExpectedConditions.elementToBeClickable(botonBuscar));
    	botonBuscar.click();
    	wait.until(ExpectedConditions.elementToBeClickable(botonBuscar));
    	
    }
    
    
    public void cerrarBaner() {
    	//System.out.println("Cierra el cartel");
    	wait.until(ExpectedConditions.elementToBeClickable(cerrarCartel));	
    	cerrarCartel.click();
    	wait.until(ExpectedConditions.elementToBeClickable(cerrarCartel));
    }
    
    
    public void validaTituloHotel() {
    	System.out.println("Se encontro " + tituloHotel.getText());
    	wait.until(ExpectedConditions.elementToBeClickable(tituloHotel));	
    	Assert.assertTrue(tituloHotel.isDisplayed());
    	wait.until(ExpectedConditions.elementToBeClickable(tituloHotel));	
    }*/
    
    
    /*public void primerHotel() {
    	wait.until(ExpectedConditions.elementToBeClickable(hotel));
    	hotel.click();
    	wait.until(ExpectedConditions.elementToBeClickable(hotel));
    }*/
    
   
   
    
    
    
}


    
    
    
    
    

