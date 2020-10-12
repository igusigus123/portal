package pageObjects;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoObjects {
	WebDriver driver;
	WebDriverWait w;

	public BoObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 120);
	}

	//
	@FindBy(xpath = "//div[@class='body-center']//span[contains(text(),'kartotek')]")
	private WebElement customerFileBox;

	public WebElement customerFileBox() {
		w.until(ExpectedConditions.visibilityOf(customerFileBox));
		return customerFileBox;
	}
	
	@FindBy(xpath = "//div[@class='body-center']//span[contains(text(),'szukiwanie')]")
	private WebElement customerSearch;

	public WebElement customerSearch() {
		w.until(ExpectedConditions.visibilityOf(customerSearch));
		return customerSearch;
	}
	
	@FindBy(xpath = "//input[@id='pesel']")
	private WebElement peselBox;

	public WebElement peselBox() {
		w.until(ExpectedConditions.visibilityOf(peselBox));
		return peselBox;
	}
	
	@FindBy(xpath = "//button[@id='search-btn']")
	private WebElement searchButton;

	public WebElement searchButton() {
		w.until(ExpectedConditions.visibilityOf(searchButton));
		return searchButton;
	}
	
	@FindBy(xpath = "//div[@class='col-md-3']//a")
	private WebElement customerFile;

	public WebElement customerFile() {
		w.until(ExpectedConditions.visibilityOf(customerFile));
		return customerFile;
	}
	
	@FindBy(xpath = "//div[@class='col-md-3']//a")
	private WebElement IsPresentCustomerFile;

	public boolean IsPresentCustomerFile() throws Exception {
		boolean b = true;
		try {
			w.until(ExpectedConditions.visibilityOf(IsPresentCustomerFile));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
	}
	
	@FindBy(xpath = "//a[contains(@href, 'agreements')]")
	private WebElement agreements;

	public WebElement agreements() {
		w.until(ExpectedConditions.visibilityOf(agreements));
		return agreements;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Warunki i zasady')]/ancestor::div[@class='panel-body']//span[contains(text(),'Wycofaj')]")
	private WebElement withdrawButton;

	public WebElement withdrawButton() {
		w.until(ExpectedConditions.visibilityOf(withdrawButton));
		return withdrawButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Warunki i zasady')]/ancestor::div[@class='panel-body']//span[contains(text(),'Wycofaj')]")
	private WebElement IsPresentwithdrawButton;

	public boolean IsPresentwithdrawButton() throws Exception {
		boolean b = true;
		try {
			w.until(ExpectedConditions.visibilityOf(IsPresentwithdrawButton));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
	}
	
	public boolean IsDesabledwithdrawButton() throws Exception {
		boolean b = true;
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Warunki i zasady')]/ancestor::div[@class='panel-body']//span[contains(text(),'Wycofaj') and @disabled='disabled']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
	}
	
}
