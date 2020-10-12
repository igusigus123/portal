package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInObjects {
	WebDriver driver;
	WebDriverWait w; // = new WebDriverWait(driver, 30);

	public SignInObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 60);
	}

	// email
	@FindBy(xpath = "//input[@placeholder='Adres e-mail']")
	private WebElement email;

	public WebElement Email() {
		w.until(ExpectedConditions.visibilityOf(email));
		return email;
	}

	// password
	@FindBy(xpath = "//password-field-component/div[2]/input")
	private WebElement pass;

	public WebElement Password() {
		w.until(ExpectedConditions.visibilityOf(pass));
		return pass;
	}

	// box PESEL
	@FindBy(xpath = "//pesel-num-box-component[@id='login-pesel-num-box']/div[1]")
	private WebElement boxPesel;

	public WebElement BoxPesel() {
		w.until(ExpectedConditions.visibilityOf(boxPesel));
		return boxPesel;
	}

	// submit
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	public WebElement Submit() {
		w.until(ExpectedConditions.visibilityOf(submit));
		return submit;
	}

	// closeAnotherSessionCheckbox
	@FindBy(xpath = "//div[@class='checkbox checkbox-input']//label")
	private WebElement closeAnotherSessionCheckbox;

	public WebElement closeAnotherSessionCheckbox() {
		w.until(ExpectedConditions.visibilityOf(closeAnotherSessionCheckbox));
		return closeAnotherSessionCheckbox;
	}

	// check if ImproperValidText is visible
		public boolean isImproperValidText() throws InterruptedException {
			try {
				Thread.sleep(5000);
				return true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				Thread.sleep(1000);
				return false;
			}
		}
	// check if closeAnotherSessionCheckbox is disabled
	public boolean isElementPresent() throws InterruptedException {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='checkbox checkbox-input']//label"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Thread.sleep(1000);
			return false;
		}
	}

	// cookiesComunnicateClose
	@FindBy(xpath = "//a[@title='Zamknij']")
	private WebElement cookiesComunnicateClose;

	public WebElement CookiesComunnicateClose() {
		w.until(ExpectedConditions.visibilityOf(cookiesComunnicateClose));
		return cookiesComunnicateClose;
	}

	// blindEye
	@FindBy(xpath = "//i[@class='fa fa-eye fa-size-18']")
	private WebElement blindEye;

	public WebElement blindEye() {
		w.until(ExpectedConditions.visibilityOf(blindEye));
		return blindEye;
	}

	// profileSubmit
	@FindBy(xpath = "//*[text()='Wybierz']")
	private WebElement profileSubmit;

	public WebElement ProfileSubmit() {
		w.until(ExpectedConditions.visibilityOf(profileSubmit));
		return profileSubmit;
	}

	// klienciIndywid
	@FindBy(xpath = "//div[@class='header__navi-panel']//span[contains(text(),'Klienci indywidualni')]")
	private WebElement klienciIndywid;

	public WebElement KlienciIndywid() {
		w.until(ExpectedConditions.visibilityOf(klienciIndywid));
		return klienciIndywid;
	}

	public WebElement[] getActivePeselNumbers() {
		WebElement[] we = new WebElement[11];

		for (int i = 0; i < 11; i++) {
			// int j = i + 1;
			String s = driver.findElement(By.xpath("//input[@id='pesel-" + i + "']/parent::div")).getAttribute("class");

			if (s.contains("disabled")) {
				we[i] = null;
			} else
				we[i] = driver.findElement(By.xpath("//input[@id='pesel-" + i + "']"));

		}
		return we;

	}

}
