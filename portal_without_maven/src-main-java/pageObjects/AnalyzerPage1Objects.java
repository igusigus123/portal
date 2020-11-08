package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalyzerPage1Objects {
	WebDriver driver;
	WebDriverWait w;

	public AnalyzerPage1Objects (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 5);
	}
	
	// analyzerCheckbox
		@FindBy(xpath = "//label[@for='agreement-input-ZANKR']")
		private WebElement analyzerCheckbox;

		public WebElement analyzerCheckbox() {
			w.until(ExpectedConditions.visibilityOf(analyzerCheckbox));
			return analyzerCheckbox;
		}

		// analyzerCheckboxIfChecked
		@FindBy(xpath = "//input[@id='agreement-input-ZANKR']")
		private WebElement analyzerCheckboxIfChecked;

		public WebElement analyzerCheckboxIfChecked() {
			return analyzerCheckboxIfChecked;
		}
		// consumerCreditTypeNoCalculation
		@FindBy(xpath = "//label[@for='radio1a']")

		private WebElement consumerCreditTypeNoCalculation;

		public WebElement consumerCreditTypeNoCalculation() {
			w.until(ExpectedConditions.visibilityOf(consumerCreditTypeNoCalculation));
			return consumerCreditTypeNoCalculation;
		}

		// consumerCreditTypeIfCheckedNoCalculation
		@FindBy(xpath = "//input[@id='radio1a']")
		private WebElement consumerCreditTypeIfCheckedNoCalculation;

		public WebElement consumerCreditTypeIfCheckedNoCalculation() {
			return consumerCreditTypeIfCheckedNoCalculation;
		}

		// mortgageCreditTypeNoCalculation
		@FindBy(xpath = "//label[@for='radio2a']")
		private WebElement mortgageCreditTypeNoCalculation;

		public WebElement mortgageCreditTypeNoCalculation() {
			w.until(ExpectedConditions.visibilityOf(mortgageCreditTypeNoCalculation));
			return mortgageCreditTypeNoCalculation;
		}

		// consumerMortgageTypeIfCheckedNoCalculation
		@FindBy(xpath = "//input[@id='radio2a']")
		private WebElement consumerMortgageTypeIfCheckedNoCalculation;

		public WebElement consumerMortgageTypeIfCheckedNoCalculation() {
			return consumerMortgageTypeIfCheckedNoCalculation;
		}

		// creditTypeSubmitNoCalculation
		@FindBy(xpath = "//button[@class='outline-button']")
		private WebElement creditTypeSubmitNoCalculation;

		public WebElement creditTypeSubmitNoCalculation() {
			w.until(ExpectedConditions.visibilityOf(creditTypeSubmitNoCalculation));
			return creditTypeSubmitNoCalculation;
		}

		// consumerCreditType
		@FindBy(xpath = "//label[@for='radio1b']")

		private WebElement consumerCreditType;

		public WebElement consumerCreditType() {
			w.until(ExpectedConditions.visibilityOf(consumerCreditType));
			return consumerCreditType;
		}

		// consumerCreditTypeIfChecked
		@FindBy(xpath = "//input[@id='radio1b']")
		private WebElement consumerCreditTypeIfChecked;

		public WebElement consumerCreditTypeIfChecked() {
			return consumerCreditTypeIfChecked;
		}

		// mortgageCreditType
		@FindBy(xpath = "//label[@for='radio2b']")
		private WebElement mortgageCreditType;

		public WebElement mortgageCreditType() {
			w.until(ExpectedConditions.visibilityOf(mortgageCreditType));
			return mortgageCreditType;
		}

		// consumerMortgageTypeIfChecked
		@FindBy(xpath = "//input[@id='radio2b']")
		private WebElement consumerMortgageTypeIfChecked;

		public WebElement consumerMortgageTypeIfChecked() {
			return consumerMortgageTypeIfChecked;
		}

		// creditTypeSubmit
		@FindBy(xpath = "//a[@class='outline-button pull-right mt-5']")
		private WebElement creditTypeSubmit;

		public WebElement creditTypeSubmit() {
			w.until(ExpectedConditions.visibilityOf(creditTypeSubmit));
			return creditTypeSubmit;
		}

		// detailsLastCalculation
		@FindBy(xpath = "//a[@class='outline-button pull-right -mt-md-75 mt-55 mt-sm-45 mt-xs-5 mt-btn-an-correction']")
		private WebElement detailsLastCalculation;

		public WebElement detailsLastCalculation() {
			w.until(ExpectedConditions.visibilityOf(detailsLastCalculation));
			return detailsLastCalculation;
		}
		// lastAmount
		@FindBy(xpath = "//div[@class='col-lg-8 col-md-8 col-sm-6']//p[1]")
		private WebElement lastAmount;

		public WebElement lastAmount() {
			w.until(ExpectedConditions.visibilityOf(lastAmount));
			return lastAmount;
		}

		// lastPeriod
		@FindBy(xpath = "//div[@class='col-lg-8 col-md-8 col-sm-6']//p[2]")
		private WebElement lastPeriod;

		public WebElement lastPeriod() {
			w.until(ExpectedConditions.visibilityOf(lastPeriod));
			return lastPeriod;
		}

		// lastChance
		@FindBy(xpath = "//div[@class='col-lg-8 col-md-8 col-sm-6']//p[3]")
		private WebElement lastChance;

		public WebElement lastChance() {
			w.until(ExpectedConditions.visibilityOf(lastChance));
			return lastChance;
		}
		
		// firstRadioSource
		@FindBy(xpath = "//div[contains(@class,'radio-input')]//div[1]//label[1]")
		private WebElement firstRadioSource;

		public WebElement firstRadioSource() {
			w.until(ExpectedConditions.visibilityOf(firstRadioSource));
			return firstRadioSource;
		}
}
