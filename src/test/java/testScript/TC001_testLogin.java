package testScript;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLiberly.signIn;
import testBase.testBase;

public class TC001_testLogin extends testBase {
	
	signIn signIn;
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void testlogin() throws InterruptedException{
		signIn = new signIn(driver);
		signIn.clickonsignIn();
		signIn.enetrEmailAddress("dhakeparag3@gmail.com");
		signIn.alrealyResgistredpaawd("123456");
		signIn.clickOnSignInBtn();
		Thread.sleep(3000);
		signIn.logout();
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
