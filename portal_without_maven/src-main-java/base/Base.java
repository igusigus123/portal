package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	private WebDriverWait w;
	public static Properties prop = new Properties();
	public static Component com;
	public static String email;
	public static String pass;
	public static String pesel;

	public WebDriver initializeDriver(String getUrl) throws IOException, InterruptedException {
		driver=null;
		String path = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(path +
				"\\src-main-resources\\data.properties");
		prop.load(file);

		if (prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\***\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		if (prop.getProperty("browser").contains("firefox")) {
			// driver = new FirefoxDriver();
		}
		if(com.getEnvironment().equals("prod"))
		{
			if (getUrl == "BO") {
				driver.get(prop.getProperty("urlboprod"));
				pesel = prop.getProperty("peselProd");
			} else if (getUrl == "Logowanie") {
				driver.get(prop.getProperty("urlLogowanieProd"));
				email = prop.getProperty("emailProd");
				pass = prop.getProperty("passwordProd");
				pesel = prop.getProperty("peselProd");
			} else if (getUrl == "Test") {
				driver.get(prop.getProperty("urlTest"));
			}
			
		}
		else if(com.getEnvironment().equals("uat"))
		{
			if (getUrl == "Home") {
				driver.get(prop.getProperty("urlHomePage"));
			} else if (getUrl == "Logowanie") {
				driver.get(prop.getProperty("urlLogowanieUat"));
				email = prop.getProperty("emailUat");
				pass = prop.getProperty("passwordUat");
				pesel = null;
			} else if (getUrl == "Test") {
				driver.get(prop.getProperty("urlTest"));
			}
			
		}
		else if(com.getEnvironment().equals("stt"))
		{
			if (getUrl == "BO") {
				driver.get(prop.getProperty("urlbostt"));
				pesel = prop.getProperty("peselStt");
			} else if (getUrl == "Logowanie") {
				driver.get(prop.getProperty("urlLogowanieStt"));
				email = prop.getProperty("emailStt");
				pass = prop.getProperty("passwordStt");
				pesel = prop.getProperty("peselStt");
			} else if (getUrl == "Test") {
				driver.get(prop.getProperty("urlTest"));
			}
			
		}

		return driver;
	}

	
	public void clearInput(WebElement input) {
		int j = input.getAttribute("value").length();
		for (int i = 0; i < j; i++) {
			input.sendKeys(Keys.BACK_SPACE);
		}

	}
	
	

}
