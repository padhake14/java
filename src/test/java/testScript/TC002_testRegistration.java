package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLiberly.signIn;
import pageLiberly.createAccount;
import testBase.testBase;

public class TC002_testRegistration extends testBase {
	signIn signIn;
	createAccount createAccount;

	String firstName = "FirstName";
	String lastName = "LastName";
	String pass = "Password";
	String createaccountid = "email" + System.currentTimeMillis() + "@gmail.com";
	String day = "10";
	String month = "july";
	String year = "2007";

	@BeforeClass
	public void setUP() throws IOException {
		init();
	}

	@Test(priority = 0, enabled =true, description="test registration with data")
	public void testregistrationWithData() throws InterruptedException {
		signIn = new signIn(driver);
		createAccount = new createAccount(driver);
		signIn.enterDataToCreateAccount(createaccountid);
		Thread.sleep(10000);
		createAccount.testUserRegistration(firstName, lastName, pass, day, month, year);
		Thread.sleep(3000);
		boolean isSucess = createAccount.verifyCreateaccountLable();
		if (isSucess) {
			Assert.assertTrue(true, "Rgesitration test is pass");
		} else {
			Assert.assertTrue(false, "Rgesitration test is fail");
		}
	}
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
