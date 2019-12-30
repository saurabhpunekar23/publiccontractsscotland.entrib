package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserManager {

	 

	public static WebDriver  browserSetUp(String browserType , String url) {

		WebDriver driver=null;

		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".D\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else{
			try {
				throw new Exception("Browser is not correct");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("Browser invoke and open url "+url);
		return driver;
		
   }
	
	public static void closedDriver(WebDriver driver) {
		
		driver.close();
		Reporter.log("Driver Closed");
	}
	
}