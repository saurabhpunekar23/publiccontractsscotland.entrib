package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class po_ViewNotice {
	
	WebDriver driver;
	
 public po_ViewNotice(WebDriver driver){
		this.driver=driver;
	}

	
	@FindBy(how=How.ID, using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_introduction1_lblTitle")
	WebElement notice_Title;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_introduction1_lblTenderID")
	WebElement notice_Reference_No;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_introduction1_lblOCID")
	WebElement notice_OCID;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_introduction1_lblAuth")
	WebElement notice_Published_by;
	
	@FindBy(how=How.ID, using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_introduction1_lblPubDate")
	WebElement notice_Publication_Date;
	
	@FindBy(how=How.LINK_TEXT, using="Contact Info")
	WebElement notice_Link_Contact_Info;
	
	@FindBy(how=How.ID, using="ctl00_ContentPlaceHolder1_tab_StandardNoticeView1_notice_contactinfo1_lblEmailContact")
	WebElement notice_Main_Contact_Email;
	
	public String fetch_Title() {
		
        String title=notice_Title.getText();
        return title;
	}
	
    public String fetch_Reference_No() {
    	String referenceNo=notice_Reference_No.getText();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return referenceNo;
	}
	public String fetch_OCID() {
		String  ocid=notice_OCID.getText();
		return ocid;
	}
	
	public String fetch_Published_by() {
		String publishedby=notice_Published_by.getText();
		return publishedby;
		}
	
	public String fetch_Publication_Date() {
		String publicationDate=notice_Publication_Date.getText();
		return publicationDate;
	}
	
	public void click_On_Contact_Info() {
		notice_Link_Contact_Info.click();
	}
	
	public String fetch_Main_Contact_Email() {
		String mainContactEmail=notice_Main_Contact_Email.getText();
		return mainContactEmail;
	  }
	
}


