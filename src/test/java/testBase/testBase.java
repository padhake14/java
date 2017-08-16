package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream fis;
	public WebDriver driver;

	public void init() throws IOException {
		loadPropertiesfile();
		selectBrowser(Repository.getProperty("browser"));
		driver.get(Repository.getProperty("url"));
	}

	public void loadPropertiesfile() throws IOException {
		f = new File(System.getProperty("user.dir") + "/src/test/java/config/config.properties");
		fis = new FileInputStream(f);
		Repository.load(fis);
	}

	public WebDriver selectBrowser(String browser) {
		if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "/home/parag/Music/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "/home/parag/Music/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;

	}
	public void closeBrowser(){
		driver.quit();
	}

}
