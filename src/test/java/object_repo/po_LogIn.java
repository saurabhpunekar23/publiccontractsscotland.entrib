package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class po_LogIn {
	
	WebDriver driver;
		public po_LogIn(WebDriver driver){
		this.driver=driver;
	}
	
	
	@FindBy(how=How.ID,using="ctl00_Header_lnkSignIn")
	WebElement logIn;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_txtEmail")
	WebElement box_email_ID;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_txtPassword")
	WebElement box_password;
	
	@FindBy(how=How.ID,using="ctl00_ContentPlaceHolder1_cmdSignIn")
	WebElement logIn_button;
	
	private void click_On_logIn() {
		logIn.click();
	}
	
	private void enterEmailID(String emailID) {
		box_email_ID.sendKeys(emailID);
	}
	
	private void enterPassword(String password) {
		box_password.sendKeys(password);
	}
	
	private void click_On_logIn_button() {
		logIn_button.click();
	}
	
	public void allMethods_LogIn(String emailID, String password) {
		click_On_logIn();
		enterEmailID(emailID);
		enterPassword(password);
		click_On_logIn_button();
		
	}
}

