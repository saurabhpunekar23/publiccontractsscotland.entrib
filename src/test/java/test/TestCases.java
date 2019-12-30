package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.BrowserManager;

public class TestCases {
	
	@BeforeMethod
	public void invokeBrowser()  {
		BrowserManager setBrowser=new BrowserManager();
		setBrowser.browserSetUp("chrome","https://www.publiccontractsscotland.gov.uk/" );
	}
		@Test
		public void login() {
			System.out.println("hello");
			}
		

}
