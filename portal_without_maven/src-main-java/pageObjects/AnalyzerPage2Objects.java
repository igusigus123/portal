package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalyzerPage2Objects {
	WebDriver driver;
	WebDriverWait w;

	public AnalyzerPage2Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 5);
	}

	// analyzerCheckbox
	@FindBy(xpath = "//label[@for='agreement-input-ZANKR']")
	private WebElement analyzerCheckbox;

	public WebElement analyzerCheckbox() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSliderPoint));
		return analyzerCheckbox;
	}
	
	public boolean analyzerCheckboxDisabled() {
		try {
			w.until(ExpectedConditions.visibilityOf(analyzerCheckbox));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	// analyzerCheckboxIfChecked
	@FindBy(xpath = "//input[@id='agreement-input-ZANKR']")
	private WebElement analyzerCheckboxIfChecked;

	public WebElement analyzerCheckboxIfChecked() {
		return analyzerCheckboxIfChecked;
	}

	// correctTypeCredit
	public WebElement correctTypeCredit(int i) {
		WebElement TypeCredit = driver
				.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[" + i + "][contains(@class, 'active')]"));
		return TypeCredit;
	}

	// creditAmountSliderPoint
	@FindBy(xpath = "//div[@id='credit-amount-slider']//div[@class='noUi-handle noUi-handle-lower']")
	private WebElement creditAmountSliderPoint;

	public WebElement CreditAmountSliderPoint() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSliderPoint));
		return creditAmountSliderPoint;
	}

	// creditAmountSlider
	@FindBy(xpath = "//div[@id='credit-amount-slider']//div[@class='noUi-connects']")
	private WebElement creditAmountSlider;

	public WebElement CreditAmountSlider() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSlider));
		return creditAmountSlider;
	}

	// propertyValueInput
	@FindBy(xpath = "//input[@id='property-value-value']")
	private WebElement propertyValueInput;

	public WebElement propertyValueInput() {

		w.until(ExpectedConditions.visibilityOf(propertyValueInput));
		return propertyValueInput;
	}

	public boolean propertyValueInputDisabled() {
		try {
			w.until(ExpectedConditions.visibilityOf(propertyValueInput));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	// creditAmountInput
	@FindBy(xpath = "//input[@id='credit-amount-value']")
	private WebElement creditAmountInput;

	public WebElement creditAmountInput() {
		w.until(ExpectedConditions.visibilityOf(creditAmountInput));
		return creditAmountInput;
	}

	// creditAmountMin
	@FindBy(xpath = "//body[@class='document-ready']//div[@class='row mt-20']//div[@class='row mt-20']//div[@class='noUi-pips noUi-pips-horizontal']//div[2]")
	private WebElement creditAmountMin;

	public WebElement CreditAmountMin() {
		w.until(ExpectedConditions.visibilityOf(creditAmountMin));
		return creditAmountMin;
	}

	// creditAmountMax
	@FindBy(xpath = "//body[@class='document-ready']//div[@class='row mt-20']//div[@class='row mt-20']//div[103]")
	private WebElement creditAmountMax;

	public WebElement CreditAmountMax() {
		w.until(ExpectedConditions.visibilityOf(creditAmountMax));
		return creditAmountMax;
	}

	// installmentsCount
	@FindBy(xpath = "//label[contains(text(),'liczba rat')]")
	private WebElement installmentsCount;

	public WebElement InstallmentsCount() {
		w.until(ExpectedConditions.visibilityOf(installmentsCount));
		return installmentsCount;
	}

	// installmentsCountIfChecked
	@FindBy(xpath = "//input[@id='radio1']")
	private WebElement installmentsCountIfChecked;

	public WebElement InstallmentsCountIfChecked() {
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='radio1']")));
		return installmentsCountIfChecked;
	}

	// installmentsValue
	@FindBy(xpath = "//label[contains(text(),'wysoko')]")
	private WebElement installmentsValue;

	public WebElement InstallmentsValue() {
		w.until(ExpectedConditions.visibilityOf(installmentsValue));
		return installmentsValue;
	}

	// installmentsValueIfChecked
	@FindBy(xpath = "//input[@id='radio2']")
	private WebElement installmentsValueIfChecked;

	public WebElement InstallmentsValueIfChecked() {
		return installmentsValueIfChecked;
	}

	// creditInstallmentsSliderPoint
	@FindBy(xpath = "//div[@id='credit-installments-slider']//div[@class='noUi-handle noUi-handle-lower']")
	private WebElement creditInstallmentsSliderPoint;

	public WebElement CreditInstallmentsSliderPoint() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSliderPoint));
		return creditInstallmentsSliderPoint;
	}

	public boolean CreditInstallmentsSliderPointIsPresent() {
		boolean b = true;
		try {
			w.until(ExpectedConditions.visibilityOf(creditInstallmentsSliderPoint));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
	}

	// creditInstallmentsSlider
	@FindBy(xpath = "//div[@id='credit-installments-slider']//div[@class='noUi-connects']")
	private WebElement creditInstallmentsSlider;

	public WebElement CreditInstallmentsSlider() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSlider));
		return creditInstallmentsSlider;
	}

	// creditInstallmentsInput
	@FindBy(xpath = "//input[@id='credit-installments-value']")
	private WebElement creditInstallmentsInput;

	public WebElement CreditInstallmentsInput() {
		w.until(ExpectedConditions.visibilityOf(creditInstallmentsInput));
		return creditInstallmentsInput;
	}

	// creditInstallmentsMin
	@FindBy(xpath = "//div[@class='row mt-10']//div[@class='noUi-pips noUi-pips-horizontal']//div[2]")
	private WebElement creditInstallmentsMin;

	public WebElement CreditInstallmentsMin() {
		w.until(ExpectedConditions.visibilityOf(creditInstallmentsMin));
		return creditInstallmentsMin;
	}

	// creditInstallmentsMax
	@FindBy(xpath = "//div[@class='row mt-10']//div[103]")
	private WebElement creditInstallmentsMax;

	public WebElement CreditInstallmentsMax() {
		w.until(ExpectedConditions.visibilityOf(creditInstallmentsMax));
		return creditInstallmentsMax;
	}

	// hiddenObligatoryTextAmount
	@FindBy(xpath = "//input[@id='credit-amount-value']/following-sibling::div[1]")
	private WebElement hiddenObligatoryTextAmount;

	public WebElement HiddenObligatoryTextAmount() {
		w.until(ExpectedConditions.visibilityOf(hiddenObligatoryTextAmount));
		return hiddenObligatoryTextAmount;
	}

	// hiddenObligatoryTextPropertyValue
	@FindBy(xpath = "//input[@id='property-value-value']/following-sibling::div[1]")
	private WebElement hiddenObligatoryTextPropertyValue;

	public WebElement hiddenObligatoryTextPropertyValue() {
		w.until(ExpectedConditions.visibilityOf(hiddenObligatoryTextPropertyValue));
		return hiddenObligatoryTextPropertyValue;
	}

	// hiddenObligatoryTextInstallments
	@FindBy(xpath = "//input[@id='credit-installments-value']/following-sibling::div[1]")
	private WebElement hiddenObligatoryTextInstallments;

	public WebElement HiddenObligatoryTextInstallments() {
		w.until(ExpectedConditions.visibilityOf(hiddenObligatoryTextInstallments));
		return hiddenObligatoryTextInstallments;
	}

	// hiddenMinTextPropertyValue
	private WebElement hiddenMinTextPropertyValue;

	public WebElement hiddenMinTextPropertyValue() {
		hiddenMinTextPropertyValue = driver
				.findElement(By.xpath("//input[@id='property-value-value']/following-sibling::div[2]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMinTextPropertyValue));
		return hiddenMinTextPropertyValue;
	}

	// hiddenMinTextAmount
	private WebElement hiddenMinTextAmount;

	public WebElement HiddenMinTextAmount() {
		hiddenMinTextAmount = driver
				.findElement(By.xpath("//input[@id='credit-amount-value']/following-sibling::div[2]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMinTextAmount));
		return hiddenMinTextAmount;
	}

	// hiddenMinTextInstallments
	private WebElement hiddenMinTextInstallments;

	public WebElement hiddenMinTextInstallments() {
		hiddenMinTextInstallments = driver
				.findElement(By.xpath("//input[@id='credit-installments-value']/following-sibling::div[2]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMinTextInstallments));
		return hiddenMinTextInstallments;
	}

	// hiddenMaxTextPropertyValue
	private WebElement hiddenMaxTextPropertyValue;

	public WebElement hiddenMaxTextPropertyValue() {
		hiddenMaxTextPropertyValue = driver
				.findElement(By.xpath("//input[@id='property-value-value']/following-sibling::div[3]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMaxTextPropertyValue));
		return hiddenMaxTextPropertyValue;
	}

	// hiddenMaxTextAmount
	private WebElement hiddenMaxTextAmount;

	public WebElement hiddenMaxTextAmount() {
		hiddenMaxTextAmount = driver
				.findElement(By.xpath("//input[@id='credit-amount-value']/following-sibling::div[3]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMaxTextAmount));
		return hiddenMaxTextAmount;
	}

	// hiddenMaxTextInstallments
	private WebElement hiddenMaxTextInstallments;

	public WebElement hiddenMaxTextInstallments() {
		hiddenMaxTextInstallments = driver
				.findElement(By.xpath("//input[@id='credit-installments-value']/following-sibling::div[3]"));
		w.until(ExpectedConditions.visibilityOf(hiddenMaxTextAmount));
		return hiddenMaxTextInstallments;
	}

	// tooSmallInstallment
	@FindBy(xpath = "//div[@class='validate-text'][contains(text(),' Zbyt niska rata')]")
	private WebElement tooSmallInstallment;

	public WebElement tooSmallInstallment() {
		w.until(ExpectedConditions.visibilityOf(tooSmallInstallment));
		return tooSmallInstallment;
	}

	// tooLargeInstallment
	@FindBy(xpath = "//div[@class='validate-text'][contains(text(),' Zbyt wysoka rata')]")
	private WebElement tooLargeInstallment;

	public WebElement tooLargeInstallment() {
		w.until(ExpectedConditions.visibilityOf(tooLargeInstallment));
		return tooLargeInstallment;
	}

	// moreThanMaksInstallment
	@FindBy(xpath = "//div[@class='col-sm-4 col-xs-12 mt-xs-10 validate']//div[8]")
	private WebElement moreThanMaksInstallment;

	public WebElement moreThanMaksInstallment() {
		w.until(ExpectedConditions.visibilityOf(moreThanMaksInstallment));
		return moreThanMaksInstallment;
	}

	// lessThanMinInstallment
	@FindBy(xpath = "//div[@class='col-sm-4 col-xs-12 mt-xs-10 validate']//div[9]")
	private WebElement lessThanMinInstallment;

	public WebElement lessThanMinInstallment() {
		w.until(ExpectedConditions.visibilityOf(lessThanMinInstallment));
		return lessThanMinInstallment;
	}

	// hiddenRelationCreditPropertyTextAmount
	private WebElement hiddenRelationCreditPropertyTextAmount;

	public WebElement hiddenRelationCreditPropertyTextAmount() {
		hiddenRelationCreditPropertyTextAmount = driver
				.findElement(By.xpath("//input[@id='credit-amount-value']/following-sibling::div[4]"));
		w.until(ExpectedConditions.visibilityOf(hiddenRelationCreditPropertyTextAmount));
		return hiddenRelationCreditPropertyTextAmount;
	}

	// tooltipPropertyValue
	@FindBy(xpath = "//div[@class='col-sm-7 col-xs-12']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement tooltipPropertyValue;

	public WebElement tooltipPropertyValue() {
		w.until(ExpectedConditions.visibilityOf(tooltipPropertyValue));
		return tooltipPropertyValue;
	}

	// tooltipPropertyValueText
	@FindBy(xpath = "//div[@class='col-sm-7 col-xs-12']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement tooltipPropertyValueText;

	public WebElement tooltipPropertyValueText() {
		w.until(ExpectedConditions.visibilityOf(tooltipPropertyValueText));
		return tooltipPropertyValueText;
	}

	// tooltipAmount
	@FindBy(xpath = "//div[@class='col-xs-12 mb-5']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement tooltipAmount;

	public WebElement tooltipAmount() {
		w.until(ExpectedConditions.visibilityOf(tooltipAmount));
		return tooltipAmount;
	}

	// tooltipAmountText
	@FindBy(xpath = "//div[@class='col-xs-12 mb-5']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement tooltipAmountText;

	public WebElement tooltipAmountText() {
		w.until(ExpectedConditions.visibilityOf(tooltipAmountText));
		return tooltipAmountText;
	}

	// tooltipHowToPay
	@FindBy(xpath = "//div[@class='col-lg-7 col-md-7 col-sm-7 col-xs-12']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement tooltipHowToPay;

	public WebElement tooltipHowToPay() {
		w.until(ExpectedConditions.visibilityOf(tooltipHowToPay));
		return tooltipHowToPay;
	}

	// tooltipHowToPayText
	@FindBy(xpath = "//div[@class='col-lg-7 col-md-7 col-sm-7 col-xs-12']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement tooltipHowToPayText;

	public WebElement tooltipHowToPayText() {
		w.until(ExpectedConditions.visibilityOf(tooltipHowToPayText));
		return tooltipHowToPayText;
	}

	// submit
	@FindBy(xpath = "//input[@class='blue-button pull-right w-xs-100']")
	private WebElement submit;

	public WebElement Submit() {
		return submit;
	}
}
