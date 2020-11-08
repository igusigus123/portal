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
	WebDriverWait w;

	public SignInObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 5);
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

	// ImproperValidText
	@FindBy(xpath = "//div[@id='bottom-validate-text']/div[2]/div[1]")
	private WebElement ImproperValidText;

	public WebElement improperValidText() {
		w.until(ExpectedConditions.visibilityOf(ImproperValidText));
		return ImproperValidText;
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

	public WebElement ProfileSubmit() throws InterruptedException {
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

	// FirstActivePeselNumber
	@FindBy(xpath = "//input[contains(@class,'peselchar-error')]")
	private WebElement FirstActivePeselNumber;

	public WebElement FirstActivePeselNumber() {
		w.until(ExpectedConditions.visibilityOf(FirstActivePeselNumber));
		return FirstActivePeselNumber;
	}

	public WebElement[] getActivePeselNumbers() {
		WebElement[] we = new WebElement[11];

		for (int i = 0; i < 11; i++) {
			String s = driver.findElement(By.xpath("//input[@id='pesel-" + i + "']/parent::div")).getAttribute("class");

			if (s.contains("disabled")) {
				we[i] = null;
			} else
				we[i] = driver.findElement(By.xpath("//input[@id='pesel-" + i + "']"));

		}
		return we;

	}

}
