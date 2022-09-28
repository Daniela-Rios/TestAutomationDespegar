package com.files.tests;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import pageObjets.DespegarBaseTest;
import pageObjets.DespegarHomePage;
import pageObjets.DespegarResultsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class DespegarTestInicial {
	WebDriver driver = null;
	DespegarHomePage homepage = null;
	
	
	@BeforeMethod(alwaysRun = true)
	public void validar(ITestContext context) throws Exception{
		System.setProperty("webdriver.chrome.driver", "src/main/java/recursos/chromedriver.exe");
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
		 this.driver.get("https://www.despegar.com.ar");
		 String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		 String navegador = navegadorTestSuite != null ? navegadorTestSuite : "CHROME";
		  homepage = new DespegarHomePage(this.driver);
		 
	}
	
	@DataProvider(name= "despegar")
	public Object [][] dpMethod(){
		return new Object [][] {{" Santiago de Chile, Santiago, Chile"}, 
			                    {" Miami Beach, Florida, Estados Unidos"}, 
			                    {" Buenos Aires, Ciudad de Buenos Aires, Argentina"}};
		}
	
	@Test(groups = {"grupo1"}, dataProvider="despegar", description="Validar que las busquedas funcionan") 
	public void validarBusquedaDespegar(String text) throws Exception{
		//DespegarBaseTest.goToMainPage(driver);
		DespegarHomePage homepage=new DespegarHomePage(driver);
		DespegarResultsPage resultspage = homepage.searchText(text);
		Assert.assertTrue(resultspage.tituloEsVisible(), "El titulo no esta visible");
		/*homepage.clickAplicarHab();
		homepage.clickBuscar();
		homepage.cerrarBaner();
		//homepage.validaTituloHotel();
		homepage.primerHotel();*/


}
	
	
	
 
	 @AfterMethod(alwaysRun = true)
	    public void Cerrar() {
	    	driver.quit();
	    	
	    }

}
