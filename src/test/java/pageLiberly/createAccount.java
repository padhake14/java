package pageLiberly;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class createAccount {
	WebDriver driver;

	// By.xpath("//a[@class='login']")).click();
	// By.id("email_create")).sendKeys("1245552@gmail.com");
	// By.id("SubmitCreate")).click();
	static Logger log1 = Logger.getLogger(createAccount.class.getName());
	By mrRadionButton = By.xpath("//*[@id='id_gender1']");
	By verifyCreateaccountLable = By.xpath("//h1");
	By verifyPersonalInfoLable = By.xpath("//h3");
	By enetrFirstname = By.id("customer_firstname");
	By enetrLastname = By.id("customer_lastname");
	By password = By.id("passwd");
	By days = By.id("days");
	By enterMonth = By.id("months");
	By enterYear = By.id("years");
	By enterCompany = By.id("company");
	By enterAddress = By.id("address1");
	By enaterCity = By.id("city");
	By yourAddressStateDropDown = By.xpath("//select[@id='id_state']/option[3]");
	By enaterPostcode = By.id("postcode");
	By yourAddressCountryName = By.xpath("//*[@id='id_country']");
	By enateOtherDetails = By.id("other");
	By enaterPhone = By.id("phone");
	By enaterMobile = By.id("phone_mobile");
	By enaterAlisas = By.id("alias");
	By claickOnRegister = By.xpath("//span[text()='Register']");

	public createAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMrRadionButton() {
		log1.info("selecting Mr Radion Button");
		driver.findElement(mrRadionButton).click();
	}

	public boolean verifyCreateaccountLable() {
		try {
			driver.findElement(verifyCreateaccountLable).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyPersonalInfoLable() {
		try {
			driver.findElement(verifyPersonalInfoLable).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void enterFirstName(String firstname) {
		log1.info("enter first name");
		driver.findElement(enetrFirstname).sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enetrLastname).sendKeys(lastname);
	}

	public void enetrpassword(String pass) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(password).sendKeys(pass);
	}

	public void enterDay(String day) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(days).click();

		String day1 = "//select[@id='days']/option[";
		String day2 = "]";

		driver.findElement(By.xpath(day1 + day + day2)).click();
	}

	public void enterMonth(String month) throws InterruptedException {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enterMonth).click();
		Thread.sleep(1000);
		List<WebElement> monthsData = driver.findElements(By.xpath("//*[@id='months']/option"));
		for (WebElement mon : monthsData) {
			// System.out.println(mon.getText());
			if (mon.getText().trim().toLowerCase().equals(month.toLowerCase())) {

				mon.click();
			}
		}
	}

	public void enterYear(String year) throws InterruptedException {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enterYear).click();
		Thread.sleep(1000);
		List<WebElement> years = driver.findElements(By.xpath("//*[@id='years']/option"));
		for (WebElement yearr : years) {
			if (yearr.getText().trim().equals(year)) {

				yearr.click();
			}
		}

	}

	public void enterCompany(String companyname) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enterCompany).sendKeys(companyname);
	}

	public void enterAddress(String address) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enterAddress).sendKeys(address);
	}

	public void enaterCity(String city) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enaterCity).sendKeys(city);
	}

	public void selectYourAddressState() throws InterruptedException {
		log1.info("selecting Mr Radion Button");
		driver.findElement(yourAddressStateDropDown).click();
		Thread.sleep(1000);

	}

	public void enaterPostcode(String postcode) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enaterPostcode).sendKeys(postcode);
	}

	public void selectYourAddressCountry() throws InterruptedException {
		log1.info("clicking on your Address Country Name");
		driver.findElement(yourAddressCountryName).click();
		Thread.sleep(1000);
		log1.info("selecting Country Name");
		driver.findElement(By.xpath("//*[@id='id_country']/option[2]")).click();
	}

	public void enateOtherDetails(String otherDetails) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enateOtherDetails).sendKeys(otherDetails);
	}

	public void enaterPhone(String phone) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enaterPhone).sendKeys(phone);
	}

	public void enaterMobile(String mobile) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enaterMobile).sendKeys(mobile);
	}

	public void enaterAlisas(String alisas) {
		log1.info("selecting Mr Radion Button");
		driver.findElement(enaterAlisas).sendKeys(alisas);
	}

	public void claickOnRegister() {
		log1.info("selecting Mr Radion Button");
		driver.findElement(claickOnRegister).click();
	}
	
	public boolean verifyRegistrationMsg(){
		String msg = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
		if(msg.contains("Welcome123 to your account. Here you can manage all of your personal information and orders.")){
			return true;
		}
		else{
			return false;
		}
		
	}

	public void testUserRegistration(String firstName, String lastName, String pass, String day, String month,String year) throws InterruptedException {
		selectMrRadionButton();
		enterFirstName(firstName);
		enterLastname(lastName);
		enetrpassword(pass);
		enterDay(day);
		enterMonth(month);
		enterYear(year);
		enterCompany("companyname");
		enterAddress("address");
		enaterCity("city");
		selectYourAddressState();
		enaterPostcode("90001");
		selectYourAddressCountry();
		enateOtherDetails("otherDetails");
		enaterPhone("1234567890");
		enaterMobile("1234567890");
		enaterAlisas("alisas");
		claickOnRegister();
	}

}
