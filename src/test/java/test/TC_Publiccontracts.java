package test;

import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import object_repo.po_BrowseNotices;
import object_repo.po_LogIn;
import object_repo.po_ViewNotice;
import utility.BrowserManager;
import utility.Screenshorts;
import utility.XmlWriter;

public class TC_Publiccontracts {
	
	
	
	@Test
	public void createE2E (){
		//1. website :: https://www.publiccontractsscotland.gov.uk/
		WebDriver driver=BrowserManager.browserSetUp("chrome", "https://www.publiccontractsscotland.gov.uk/");
		//WebDriver driver;

		//2. login 
		po_LogIn logIn=PageFactory.initElements(driver, po_LogIn.class);
		logIn.allMethods_LogIn("rudaipurwala@gmail.com", "example123$");
		Reporter.log("LogIn Succesfully");
		String exp="Supplier Control Panel - Public Contracts Scotland";
		String act=driver.getTitle();
		Assert.assertEquals(act,exp);
		
//		3. Navigate to Browse Notices
		po_BrowseNotices tabBrowseNotices=PageFactory.initElements(driver, po_BrowseNotices.class);
		tabBrowseNotices.click_On_Browse_Notices();
//		4. To find all the notice based on a keyword 
		tabBrowseNotices.enter_Keywords("cash");
		tabBrowseNotices.click_On_Search_btn();
//		5. Open each contract with existing keyword and take screenshot of the card
//		6. The file name of the screenshot to be  <reference_number>_<timestamp>.png
//       
		 // List <WebElement> links_Notices=driver.findElements(By.xpath("//a[contains(@href,'/search/show/search_view.aspx?ID=')]"));
		List <WebElement> links_Notices=driver.findElements(By.xpath("//a[contains(@title,'Notice Title')]"));
		
		   for(int i=1;i<links_Notices.size();i++) {
		
			links_Notices.get(i).click();
			String url=driver.getCurrentUrl();
			Reporter.log("current url "+url);
			po_ViewNotice viewNotice=PageFactory.initElements(driver, po_ViewNotice.class);
			String refNumber=viewNotice.fetch_Reference_No();
			Screenshorts.TakeScreenShot(driver, refNumber);

//	    7. extract the briefing, url of the posting and email id and place it into an xml in appropriate tagnames.
			String title=viewNotice.fetch_Title();
			String referenceNo=viewNotice.fetch_Reference_No();
			String	ocid=viewNotice.fetch_OCID();
			String	publishedby=viewNotice.fetch_Published_by();
			String	publicationDate=viewNotice.fetch_Publication_Date();
			viewNotice.click_On_Contact_Info();
			String	mainContactEmail=viewNotice.fetch_Main_Contact_Email();
			XmlWriter.xmlWrite(title, referenceNo, ocid, publishedby, publicationDate, mainContactEmail, url);
			driver.navigate().back();
//		8. All related contracts should be placed in a single xml
//		9. Export the xml as your final result
			}
            BrowserManager.closedDriver(driver);
	}

	private JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
	}
