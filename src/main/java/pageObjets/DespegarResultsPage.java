package pageObjets;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DespegarResultsPage {
	@FindBy(linkText="Alojamientos")
	WebElement alojamientosLink;	
	@FindBy(css=".sbox5-box-places-ovr input")
	WebElement ingresaDestino;
	private WebDriver driver=null;
	private WebDriverWait wait;
	
    public DespegarResultsPage (WebDriver driver) {
    	this.driver=driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	PageFactory.initElements(driver, this);
    	
    }
    public boolean tituloEsVisible() {
    	return this.ingresaDestino.isDisplayed();
    	
    }
}
    


