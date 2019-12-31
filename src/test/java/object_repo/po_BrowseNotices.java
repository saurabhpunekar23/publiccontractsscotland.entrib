package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Screenshots;

public class po_BrowseNotices {
	
	WebDriver driver;
	
	public po_BrowseNotices(WebDriver driver){
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH, using="//a[@title='Browse Notices']")
	WebElement link_Browse_Notices;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_txtKeywords")
	WebElement box_Keywords;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_cmdSearch")
	WebElement btn_Search;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_cmdSignIn")
	WebElement logIn_button;
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'/search/show/search_view.aspx?ID=')]")
	List<WebElement> links_Notices;
	
	public void click_On_Browse_Notices() {
		link_Browse_Notices.click();
	}
	
	public void enter_Keywords(String key) {
		box_Keywords.sendKeys(key);
	}
	
	public void click_On_Search_btn() {
		 btn_Search.click();
	}
	
	
}


