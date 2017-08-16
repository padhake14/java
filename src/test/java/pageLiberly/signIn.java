package pageLiberly;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class signIn {

	WebDriver driver;
	static Logger log = Logger.getLogger(signIn.class.getName());
	By signIn = By.xpath("//a[@class='login']");
	By CreateAccountEmailid = By.id("email_create");
	By submitBtn = By.id("SubmitCreate");
	By alrealyResgistredEmail = By.id("email");
	By alrealyResgistredpaawd = By.id("passwd");
	By alrealyResgistredSignInBtn = By.id("SubmitLogin");
	By signOut = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");
	
	
	
	public signIn(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickonsignIn() {
		log.info("click on signIb link");
		driver.findElement(signIn).click();
	}
	
	public void CreateAccountEmailid(String createaccountid) {
		log.info("entering createaccount email id");
		driver.findElement(CreateAccountEmailid).sendKeys(createaccountid);;
	}
	public void submitBtn() {
		log.info("click on createaccount Btn");
		driver.findElement(submitBtn).click();
	}
	
	public void enetrEmailAddress(String emailadd){
		log.info("enetr alrealy registered email address");
		driver.findElement(alrealyResgistredEmail).sendKeys(emailadd);
	}
	
	public void alrealyResgistredpaawd(String pass){
		log.info("enetr alrealy registered password");
		driver.findElement(alrealyResgistredpaawd).sendKeys(pass);
	}
	
	public void clickOnSignInBtn(){
		log.info("click on submit button");
		driver.findElement(alrealyResgistredSignInBtn).click();
	}
	public void enterDataToCreateAccount(String createaccountid ) throws InterruptedException{
		clickonsignIn();
		Thread.sleep(2000);
		CreateAccountEmailid(createaccountid);
		Thread.sleep(4000);
		submitBtn();
	}
	public void logout(){
		try{
		boolean isdisplayed = driver.findElement(signOut).isDisplayed();
		if(isdisplayed){
			driver.findElement(signOut).click();
		}
		}
		catch(Exception e){
			Assert.assertTrue("sign out buttom is not displayed", false);
		}
	}
	
}
