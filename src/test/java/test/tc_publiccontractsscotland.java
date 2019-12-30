package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import object_repo.po_LogIn;

public class tc_publiccontractsscotland {
	
	 WebDriver driver;
	 
@Parameters({"url"})	 
@BeforeMethod
public void invokeBrowser(String url){
	System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	}

@Test
@Parameters ({"emailID","password"})
public void tc_LogIn(String emailID, String password) {
	
	po_LogIn logIn=PageFactory.initElements(driver, po_LogIn.class);
	logIn.allMethods_LogIn(emailID, password);
	
	Reporter.log("LogIn Succesfully");
	 
	String exp="Supplier Control Panel - Public Contracts Scotland";
	String act=driver.getTitle();
	Assert.assertEquals(act,exp);

	
}

@AfterMethod
public void tearDown() {
	driver.close();
}
	
}
