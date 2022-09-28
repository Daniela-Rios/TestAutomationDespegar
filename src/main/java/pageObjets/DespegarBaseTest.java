package pageObjets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class DespegarBaseTest {
	  public static void goToMainPage (WebDriver driver) {
		  driver.manage().window().maximize();
	        driver.get("https://www.despegar.com.ar");
	        driver.manage().deleteAllCookies();
	    }


	    public static WebDriver iniciarDriver (String browserName) {
	        WebDriver driver=null;
	        switch(browserName) {
	        case "CHROME": {
	            System.setProperty("webdriver.chrome.driver", "src/main/java/recursos/chromedriver.exe");
	            driver = new ChromeDriver();
	            break;
	        }
	        case "FIREFOX": {
	            System.setProperty("webdriver.geckodriver.driver", "src/main/java/recursos/geckodriver.exe");
	            driver = new ChromeDriver();
	            break;
	           
	       
	        }
	        
	        default:
				Reporter.log("No selecciona ningun browser correcto, se asigna chrome");
				System.setProperty("webdriver.chrome.driver", "src/main/java/recursos/chromedriver.exe");
				Reporter.log("Abre browser");
				driver=new ChromeDriver();
				
	        }
	        return driver;
	    }
	
}
