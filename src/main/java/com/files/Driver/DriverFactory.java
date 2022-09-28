package com.files.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DriverFactory {
	public static void webDespegar(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get("https://www.despegar.com");	
		
		}
		public static WebDriver iniciarDriver(String browserName) {
			WebDriver driver=null;
			
			switch(browserName) {
			case "CHROME":{
				System.setProperty("webdriver.chrome.driver", "D:/Nueva carpeta/ChromeDriver/chromedriver.exe");
				System.out.println("Abre Chrome");
				driver=new ChromeDriver();
				break;
			}
			case "FIREFOX":{
				System.setProperty("webdriver.gecko.driver", "D:/Nueva carpeta/GeckoDriver/geckodriver.exe");
				System.out.println("Abre Firefox");
				driver=new FirefoxDriver();
				break;
			}
			case "EDGE":{
				System.setProperty("webdriver.msedge.driver", "D:/Nueva carpeta/EdgeDriver/msedgedriver.exe");
				System.out.println("Abre Edge");
				driver=new EdgeDriver();
				break;
			}
			default:
				Reporter.log("No selecciona ningun browser correcto, se asigna chrome");
				System.setProperty("webdriver.chrome.driver", "src/resources/Recursos/chromedriver.exe");
				Reporter.log("Abre browser");
				driver=new ChromeDriver();
				
			}
			return driver;
		}
			
		
}

