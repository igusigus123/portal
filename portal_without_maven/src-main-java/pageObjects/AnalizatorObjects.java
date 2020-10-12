package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalizatorObjects {
	WebDriver driver;
	WebDriverWait w;

	public AnalizatorObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 120);
	}

	// analyzerBox
	@FindBy(xpath = "//div[@class='analyzer-box-inner white-border-box']")
	private WebElement analyzerBox;

	public WebElement AnalyzerBox() {
		return analyzerBox;
	}
	
	public boolean isElementPresent (WebElement element) {
		boolean b = true;
		try {
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
	}

	public boolean isPresentanalyzerCheckbox() throws InterruptedException {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='agreement-input-ZANKR']"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Thread.sleep(1000);
			return false;
		}
	}

	// analyzerCheckbox
	@FindBy(xpath = "//label[@for='agreement-input-ZANKR']")
	private WebElement analyzerCheckbox;

	public WebElement analyzerCheckbox() {
		return analyzerCheckbox;
	}

	// analyzerCheckboxIfChecked
	@FindBy(xpath = "//input[@id='agreement-input-ZANKR']")
	private WebElement analyzerCheckboxIfChecked;

	public WebElement analyzerCheckboxIfChecked() {
		return analyzerCheckboxIfChecked;
	}

/////////////////credit type//////////////////
	// consumerCreditTypeNoCalculation
	@FindBy(xpath = "//label[@for='radio1a']")

	private WebElement consumerCreditTypeNoCalculation;

	public WebElement consumerCreditTypeNoCalculation() {
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

/////////////////CreditCriteria/////////////////////////////////////	

	// creditAmountSliderPoint
	@FindBy(xpath = "//div[@id='credit-amount-slider']//div[@class='noUi-handle noUi-handle-lower']")
	private WebElement creditAmountSliderPoint;

	public WebElement CreditAmountSliderPoint() {
		w.until(ExpectedConditions.visibilityOf(creditAmountSliderPoint));
		return creditAmountSliderPoint;
	}

	public boolean CreditAmountSliderPointIsPresent() {
		boolean b = true;
		try {
			w.until(ExpectedConditions.visibilityOf(creditAmountSliderPoint));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			b = false;
		}
		return b;
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

	// creditAmountInput
	@FindBy(xpath = "//input[@id='credit-amount-value']")
	private WebElement creditAmountInput;

	public WebElement creditAmountInput() {
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
		return creditInstallmentsInput;
	}

	// creditInstallmentsMin
	@FindBy(xpath = "//div[@class='row mt-10']//div[@class='noUi-pips noUi-pips-horizontal']//div[2]")
	private WebElement creditInstallmentsMin;

	public WebElement CreditInstallmentsMin() {
		return creditInstallmentsMin;
	}

	// creditInstallmentsMax
	@FindBy(xpath = "//div[@class='row mt-10']//div[103]")
	private WebElement creditInstallmentsMax;

	public WebElement CreditInstallmentsMax() {
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

////////////////////component and personal criteria/////////////////	

	// componentConsumerCreditType
	@FindBy(xpath = "//div[@class='row mt-15']//div[1]//p[1]//strong[2]")
	private WebElement componentConsumerCreditType;

	public WebElement componentConsumerCreditType() {
		w.until(ExpectedConditions.visibilityOf(componentConsumerCreditType));
		return componentConsumerCreditType;
	}

	// componentMortgageCreditType
	@FindBy(xpath = "//div[@class='row mt-15']//div[1]//p[1]//strong[1]")
	private WebElement componentMortgageCreditType;

	public WebElement componentMortgageCreditType() {
		w.until(ExpectedConditions.visibilityOf(componentMortgageCreditType));
		return componentMortgageCreditType;
	}

	// componentCreditAmount
	@FindBy(xpath = "//div[@class='row mt-15']//div[2]//p[1]//strong[1]")
	private WebElement componentCreditAmount;

	public WebElement componentCreditAmount() {
		w.until(ExpectedConditions.visibilityOf(componentCreditAmount));
		return componentCreditAmount;
	}

	// componentInstallmentscount
	@FindBy(xpath = "//div[@class='mt-30 white-border-box']//div[1]//p[2]//strong[1]")
	private WebElement componentInstallmentscount;

	public WebElement componentInstallmentscount() {
		w.until(ExpectedConditions.visibilityOf(componentInstallmentscount));
		return componentInstallmentscount;
	}

	// componentInstallmentValue
	@FindBy(xpath = "//div[@class='row mt-15']//div[2]//p[2]//strong[1]")
	private WebElement componentInstallmentValue;

	public WebElement componentInstallmentValue() {
		w.until(ExpectedConditions.visibilityOf(componentInstallmentValue));
		return componentInstallmentValue;
	}

	// componentPropertyValue
	@FindBy(xpath = "//div[@class='row mt-15']//div[3]//p[1]//strong[1]")
	private WebElement componentPropertyValue;

	public WebElement componentPropertyValue() {
		w.until(ExpectedConditions.visibilityOf(componentPropertyValue));
		return componentPropertyValue;
	}

	// linkWhyAsk
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-sm-5 mt-5']//a")
	private WebElement linkWhyAsk;

	public WebElement linkWhyAsk() {
		w.until(ExpectedConditions.visibilityOf(linkWhyAsk));
		return linkWhyAsk;
	}

	// buttonCloseWhyAsk
	@FindBy(xpath = "//a[@class='blue-button']")
	private WebElement buttonCloseWhyAsk;

	public WebElement buttonCloseWhyAsk() {
		w.until(ExpectedConditions.visibilityOf(buttonCloseWhyAsk));
		return buttonCloseWhyAsk;
	}

	// creditTaker1
	@FindBy(xpath = "//label[contains(text(),'samodzielnie')]")
	private WebElement creditTaker1;

	public WebElement creditTaker1() {
		w.until(ExpectedConditions.visibilityOf(creditTaker1));
		return creditTaker1;
	}

	// creditTaker1IfChecked
	@FindBy(xpath = "//input[@id='coCreditTaker-1']")
	private WebElement creditTaker1IfChecked;

	public WebElement creditTaker1IfChecked() {
		return creditTaker1IfChecked;
	}

	// creditTaker2
	@FindBy(xpath = "//div[@class='radio-input']//div//label[contains(text(),'kredytobiorc')]")
	private WebElement creditTaker2;

	public WebElement creditTaker2() {
		w.until(ExpectedConditions.visibilityOf(creditTaker2));
		return creditTaker2;
	}

	// creditTaker2IfChecked
	@FindBy(xpath = "//input[@id='coCreditTaker-2']")
	private WebElement creditTaker2IfChecked;

	public WebElement creditTaker2IfChecked() {
		return creditTaker2IfChecked;
	}

	// ifcreditTakerTextEnabled
	public boolean ifcreditTakerTextEnabled() throws InterruptedException {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//label[contains(text(),'Drugi kredytobiorca')]"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Thread.sleep(1000);
			return false;
		}
	}

	// creditTakerTooltip
	@FindBy(xpath = "//div[@class='radio-input']//div//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement creditTakerTooltip;

	public WebElement creditTakerTooltip() {
		w.until(ExpectedConditions.visibilityOf(creditTakerTooltip));
		return creditTakerTooltip;
	}

	// creditTakerTooltipText
	@FindBy(xpath = "//div[@class='radio-input']//div//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement creditTakerTooltipText;

	public WebElement creditTakerTooltipText() {
		w.until(ExpectedConditions.visibilityOf(creditTakerTooltipText));
		return creditTakerTooltipText;
	}

	// sourceOfIncomeTooltip
	@FindBy(xpath = "//div[@class='form-row mt-30']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement sourceOfIncomeTooltip;

	public WebElement sourceOfIncomeTooltip() {
		w.until(ExpectedConditions.visibilityOf(sourceOfIncomeTooltip));
		return sourceOfIncomeTooltip;
	}

	// sourceOfIncomeTooltipText
	@FindBy(xpath = "//div[@class='form-row mt-30']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement sourceOfIncomeTooltipText;

	public WebElement sourceOfIncomeTooltipText() {
		w.until(ExpectedConditions.visibilityOf(sourceOfIncomeTooltipText));
		return sourceOfIncomeTooltipText;
	}

	// sourceOfIncome
	@FindBy(xpath = "//select[@id='finance-source']")
	private WebElement sourceOfIncome;

	public WebElement sourceOfIncome() {
		w.until(ExpectedConditions.visibilityOf(sourceOfIncome));
		return sourceOfIncome;
	}

	private WebElement hiddenObligatoryTextSourceOfIncome;

	public WebElement hiddenObligatoryTextSourceOfIncome() {
		hiddenObligatoryTextSourceOfIncome = driver
				.findElement(By.xpath("//select[@id='finance-source']/following-sibling::div[@class='validate-text']"));
		w.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(("//select[@id='finance-source']/following-sibling::div[@class='validate-text']"))));
		return hiddenObligatoryTextSourceOfIncome;
	}

	// sourceOfIncome2
	@FindBy(xpath = "//select[@id='finance-source2']")
	private WebElement sourceOfIncome2;

	public WebElement sourceOfIncome2() {
		w.until(ExpectedConditions.visibilityOf(sourceOfIncome2));
		return sourceOfIncome2;
	}

	private WebElement hiddenObligatoryTextSourceOfIncome2;

	public WebElement hiddenObligatoryTextSourceOfIncome2() {
		hiddenObligatoryTextSourceOfIncome2 = driver.findElement(
				By.xpath("//select[@id='finance-source2']/following-sibling::div[@class='validate-text']"));
		w.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(("//select[@id='finance-source2']/following-sibling::div[@class='validate-text']"))));
		return hiddenObligatoryTextSourceOfIncome2;
	}

	// monthIncomeTooltip
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[2]//label[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement monthIncomeTooltip;

	public WebElement monthIncomeTooltip() {
		w.until(ExpectedConditions.visibilityOf(monthIncomeTooltip));
		return monthIncomeTooltip;
	}

	// monthIncomeTooltipText
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[2]//label[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement monthIncomeTooltipText;

	public WebElement monthIncomeTooltipText() {
		w.until(ExpectedConditions.visibilityOf(monthIncomeTooltipText));
		return monthIncomeTooltipText;
	}

	// monthIncome
	@FindBy(xpath = "//input[@id='month-finance']")
	private WebElement monthIncome;

	public WebElement monthIncome() {
		w.until(ExpectedConditions.visibilityOf(monthIncome));
		return monthIncome;
	}

	// monthIncome2
	@FindBy(xpath = "//input[@id='month-finance2']")
	private WebElement monthIncome2;

	public WebElement monthIncome2() {
		w.until(ExpectedConditions.visibilityOf(monthIncome2));
		return monthIncome2;
	}

	// hiddenTextMonthIncomeNoCalculation
	@FindBy(xpath = "//input[@id='month-finance']/following-sibling::div[1]")
	private WebElement hiddenTextMonthIncomeNoCalculation;

	public WebElement hiddenTextMonthIncomeNoCalculation() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeNoCalculation));
		return hiddenTextMonthIncomeNoCalculation;
	}

	// hiddenTextMonthIncomeNoCalculation2
	@FindBy(xpath = "//input[@id='month-finance2']/following-sibling::div[1]")
	private WebElement hiddenTextMonthIncomeNoCalculation2;

	public WebElement hiddenTextMonthIncomeNoCalculatio2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeNoCalculation2));
		return hiddenTextMonthIncomeNoCalculation2;
	}

	// hiddenTextMonthIncome
	@FindBy(xpath = "//input[@id='month-finance']/following-sibling::div[1]")
	private WebElement hiddenTextMonthIncome;

	public WebElement hiddenTextMonthIncome() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncome));
		return hiddenTextMonthIncome;
	}

	// hiddenTextMonthIncome2
	@FindBy(xpath = "//input[@id='month-finance2']/following-sibling::div[1]")
	private WebElement hiddenTextMonthIncome2;

	public WebElement hiddenTextMonthIncome2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncome2));
		return hiddenTextMonthIncome2;
	}

	// hiddenTextMonthIncomeLessThanMinNoCalculation
	@FindBy(xpath = "//div[@class='form-row mt-25 validate']//div[3]")
	private WebElement hiddenTextMonthIncomeLessThanMinNoCalculation;

	public WebElement hiddenTextMonthIncomeLessThanMinNoCalculation() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeLessThanMinNoCalculation));
		return hiddenTextMonthIncomeLessThanMinNoCalculation;
	}

	// hiddenTextMonthIncomeLessThanMin
	@FindBy(xpath = "//input[@id='month-finance']/following-sibling::div[2]")
	private WebElement hiddenTextMonthIncomeLessThanMin;

	public WebElement hiddenTextMonthIncomeLessThanMin() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeLessThanMin));
		return hiddenTextMonthIncomeLessThanMin;
	}

	// hiddenTextMonthIncomeLessThanMin2
	@FindBy(xpath = "//input[@id='month-finance2']/following-sibling::div[2]")
	private WebElement hiddenTextMonthIncomeLessThanMin2;

	public WebElement hiddenTextMonthIncomeLessThanMin2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeLessThanMin2));
		return hiddenTextMonthIncomeLessThanMin2;
	}

	// hiddenTextMonthIncomeMoreThanMax
	@FindBy(xpath = "//input[@id='month-finance']/following-sibling::div[3]")
	private WebElement hiddenTextMonthIncomeMoreThanMax;

	public WebElement hiddenTextMonthIncomeMoreThanMax() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeMoreThanMax));
		return hiddenTextMonthIncomeMoreThanMax;
	}

	// hiddenTextMonthIncomeMoreThanMax2
	@FindBy(xpath = "//input[@id='month-finance2']/following-sibling::div[3]")
	private WebElement hiddenTextMonthIncomeMoreThanMax2;

	public WebElement hiddenTextMonthIncomeMoreThanMax2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeMoreThanMax2));
		return hiddenTextMonthIncomeMoreThanMax2;
	}

	// hiddenTextMonthIncomeLessThanInstallValue
	@FindBy(xpath = "//input[@id='month-finance']/following-sibling::div[4]")
	private WebElement hiddenTextMonthIncomeLessThanInstallValue;

	public WebElement hiddenTextMonthIncomeLessThanInstallValue() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeLessThanInstallValue));
		return hiddenTextMonthIncomeLessThanInstallValue;
	}

	// hiddenTextMonthIncomeLessThanInstallValue2
	@FindBy(xpath = "//input[@id='month-finance2']/following-sibling::div[4]")
	private WebElement hiddenTextMonthIncomeLessThanInstallValue2;

	public WebElement hiddenTextMonthIncomeLessThanInstallValue2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextMonthIncomeLessThanInstallValue2));
		return hiddenTextMonthIncomeLessThanInstallValue2;
	}

	// legalChargesTooltip
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[3]//label[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement legalChargesTooltip;

	public WebElement legalChargesTooltip() {
		w.until(ExpectedConditions.visibilityOf(legalChargesTooltip));
		return legalChargesTooltip;
	}

	// legalChargesTooltipText
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[3]//label[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement legalChargesTooltipText;

	public WebElement legalChargesTooltipText() {
		w.until(ExpectedConditions.visibilityOf(legalChargesTooltipText));
		return legalChargesTooltipText;
	}

	// legalCharges
	@FindBy(xpath = "//input[@id='legal-charges']")
	private WebElement legalCharges;

	public WebElement legalCharges() {
		w.until(ExpectedConditions.visibilityOf(legalCharges));
		return legalCharges;
	}

	// legalCharges2
	@FindBy(xpath = "//input[@id='legal-charges2']")
	private WebElement legalCharges2;

	public WebElement legalCharges2() {
		w.until(ExpectedConditions.visibilityOf(legalCharges2));
		return legalCharges2;
	}

	// hiddenTexLegalCharges
	@FindBy(xpath = "//input[@id='legal-charges']/parent::div/div[3]")
	private WebElement hiddenTexLegalCharges;

	public WebElement hiddenTexLegalCharges() {
		w.until(ExpectedConditions.visibilityOf(hiddenTexLegalCharges));
		return hiddenTexLegalCharges;
	}

	// hiddenTexLegalCharges2
	@FindBy(xpath = "//input[@id='legal-charges2']/parent::div/div[3]")
	private WebElement hiddenTexLegalCharges2;

	public WebElement hiddenTexLegalCharges2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTexLegalCharges2));
		return hiddenTexLegalCharges2;
	}

	// hiddenTextLegalChargesLessThanMin
	@FindBy(xpath = "//input[@id='legal-charges']/parent::div/div[4]")
	private WebElement hiddenTextLegalChargesLessThanMin;

	public WebElement hiddenTextLegalChargesLessThanMin() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextLegalChargesLessThanMin));
		return hiddenTextLegalChargesLessThanMin;
	}

	// hiddenTextLegalChargesLessThanMin2
	@FindBy(xpath = "//input[@id='legal-charges2']/parent::div/div[4]")
	private WebElement hiddenTextLegalChargesLessThanMin2;

	public WebElement hiddenTextLegalChargesLessThanMin2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextLegalChargesLessThanMin2));
		return hiddenTextLegalChargesLessThanMin2;
	}

	// hiddenTextLegalChargesMoreThanMax
	@FindBy(xpath = "//input[@id='legal-charges']/parent::div/div[5]")
	private WebElement hiddenTextLegalChargesMoreThanMax;

	public WebElement hiddenTextLegalChargesMoreThanMax() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextLegalChargesMoreThanMax));
		return hiddenTextLegalChargesMoreThanMax;
	}

	// hiddenTextLegalChargesMoreThanMax2
	@FindBy(xpath = "//input[@id='legal-charges2']/parent::div/div[5]")
	private WebElement hiddenTextLegalChargesMoreThanMax2;

	public WebElement hiddenTextLegalChargesMoreThanMax2() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextLegalChargesMoreThanMax2));
		return hiddenTextLegalChargesMoreThanMax2;
	}

	// PayedInstallmentsText
	@FindBy(xpath = "//div[5]//span[1]")
	private WebElement PayedInstallmentsText;

	public WebElement PayedInstallmentsText() {
		w.until(ExpectedConditions.visibilityOf(PayedInstallmentsText));
		return PayedInstallmentsText;
	}

	// payedInstallments
	@FindBy(xpath = "//input[@id='paidInstallments']")
	private WebElement payedInstallments;

	public WebElement payedInstallments() {
		w.until(ExpectedConditions.visibilityOf(payedInstallments));
		return payedInstallments;
	}

	// hiddenTexPayedInstallments
	@FindBy(xpath = "//input[@id='paidInstallments']/following-sibling::div[1]")
	private WebElement hiddenTexPayedInstallments;

	public WebElement hiddenTexPayedInstallments() {
		w.until(ExpectedConditions.visibilityOf(hiddenTexPayedInstallments));
		return hiddenTexPayedInstallments;
	}

	// hiddenTextPayedInstallmentsLessThanMin
	@FindBy(xpath = "//input[@id='paidInstallments']/following-sibling::div[2]")
	private WebElement hiddenTextPayedInstallmentsLessThanMin;

	public WebElement hiddenTextPayedInstallmentsLessThanMin() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextPayedInstallmentsLessThanMin));
		return hiddenTextPayedInstallmentsLessThanMin;
	}

	// hiddenTextPayedInstallmentsMoreThanMax
	@FindBy(xpath = "//input[@id='paidInstallments']/following-sibling::div[3]")
	private WebElement hiddenTextPayedInstallmentsMoreThanMax;

	public WebElement hiddenTextPayedInstallmentsMoreThanMax() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextPayedInstallmentsMoreThanMax));
		return hiddenTextPayedInstallmentsMoreThanMax;
	}

	// creditLimitsText
	@FindBy(xpath = "//div[6]//span[1]")
	private WebElement creditLimitsText;

	public WebElement creditLimitsText() {
		w.until(ExpectedConditions.visibilityOf(creditLimitsText));
		return creditLimitsText;
	}

	// creditLimits
	@FindBy(xpath = "//input[@id='payment-month-limit2']")
	private WebElement creditLimits;

	public WebElement creditLimits() {
		w.until(ExpectedConditions.visibilityOf(creditLimits));
		return creditLimits;
	}

	// hiddenTextCreditLimits
	@FindBy(xpath = "//input[@id='payment-month-limit2']/following-sibling::div[1]")
	private WebElement hiddenTextCreditLimits;

	public WebElement hiddenTextCreditLimits() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextCreditLimits));
		return hiddenTextCreditLimits;
	}

	// hiddenTextCreditLimitsLessThanMin
	@FindBy(xpath = "//input[@id='payment-month-limit2']/following-sibling::div[2]")
	private WebElement hiddenTextCreditLimitsLessThanMin;

	public WebElement hiddenTextCreditLimitsLessThanMin() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextCreditLimitsLessThanMin));
		return hiddenTextCreditLimitsLessThanMin;
	}

	// hiddenTextCreditLimitsMoreThanMax
	@FindBy(xpath = "//input[@id='payment-month-limit2']/following-sibling::div[3]")
	private WebElement hiddenTextCreditLimitsMoreThanMax;

	public WebElement hiddenTextCreditLimitsMoreThanMax() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextCreditLimitsMoreThanMax));
		return hiddenTextCreditLimitsMoreThanMax;
	}

	// dependentsTooltip
	@FindBy(xpath = "//label[@class='mb-0 line-height-normal']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement dependentsTooltip;

	public WebElement dependentsTooltip() {
		w.until(ExpectedConditions.visibilityOf(dependentsTooltip));
		return dependentsTooltip;
	}

	// dependentsTooltipText
	@FindBy(xpath = "//label[@class='mb-0 line-height-normal']//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[@role='tooltip']")
	private WebElement dependentsTooltipText;

	public WebElement dependentsTooltipText() {
		w.until(ExpectedConditions.visibilityOf(dependentsTooltipText));
		return dependentsTooltipText;
	}

	// dependents
	@FindBy(xpath = "//select[@id='familySize']")
	private WebElement dependents;

	public WebElement dependents() {
		w.until(ExpectedConditions.visibilityOf(dependents));
		return dependents;
	}

	// householdExpensesTooltip
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[7]//label[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement householdExpensesTooltip;

	public WebElement householdExpensesTooltip() {
		w.until(ExpectedConditions.visibilityOf(householdExpensesTooltip));
		return householdExpensesTooltip;
	}

	// householdExpensesTooltipText
	@FindBy(xpath = "//div[@class='col-xs-12 col-lg-4 col-md-4 col-sm-4 hidden-xs']//div[7]//label[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement householdExpensesTooltipText;

	public WebElement householdExpensesTooltipText() {
		w.until(ExpectedConditions.visibilityOf(householdExpensesTooltipText));
		return householdExpensesTooltipText;
	}

	// householdExpenses
	@FindBy(xpath = "//input[@id='payments']")
	private WebElement householdExpenses;

	public WebElement householdExpenses() {
		w.until(ExpectedConditions.visibilityOf(householdExpenses));
		return householdExpenses;
	}

	// hiddenTextHouseholdExpenses
	@FindBy(xpath = "//input[@id='payments']/following-sibling::div[1]")
	private WebElement hiddenTextHouseholdExpenses;

	public WebElement hiddenTextHouseholdExpenses() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextHouseholdExpenses));
		return hiddenTextHouseholdExpenses;
	}

	// hiddenTextHouseholdExpensesLessThanMin
	@FindBy(xpath = "//input[@id='payments']/following-sibling::div[2]")
	private WebElement hiddenTextHouseholdExpensesLessThanMin;

	public WebElement hiddenTextHouseholdExpensesLessThanMin() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextHouseholdExpensesLessThanMin));
		return hiddenTextHouseholdExpensesLessThanMin;
	}

	// hiddenTextHouseholdExpensesMoreThanMax
	@FindBy(xpath = "//input[@id='payments']/following-sibling::div[3]")
	private WebElement hiddenTextHouseholdExpensesMoreThanMax;

	public WebElement hiddenTextHouseholdExpensesMoreThanMax() {
		w.until(ExpectedConditions.visibilityOf(hiddenTextHouseholdExpensesMoreThanMax));
		return hiddenTextHouseholdExpensesMoreThanMax;
	}

	// buttonBack
	@FindBy(xpath = "//button[@id='go-prev-button']")
	private WebElement buttonBack;

	public WebElement buttonBack() {
		w.until(ExpectedConditions.visibilityOf(buttonBack));
		return buttonBack;
	}

	// buttonCount
	@FindBy(xpath = "//button[@class='blue-button pull-right w-xs-100']")
	private WebElement buttonCount;

	public WebElement buttonCount() {
		w.until(ExpectedConditions.visibilityOf(buttonCount));
		return buttonCount;
	}

/////////////////////credit chances//////////////////////////////

	// chanceText
	@FindBy(xpath = "//h3[@class='mt-10']//strong")
	private WebElement chanceText;

	public WebElement chanceText() {
		w.until(ExpectedConditions.visibilityOf(chanceText));
		return chanceText;
	}

	// caclucationDate
	@FindBy(xpath = "//div[@class='col-xs-12 col-md-6 hidden-sm hidden-xs text-right']//h3")
	private WebElement caclucationDate;

	public WebElement caclucationDate() {
		w.until(ExpectedConditions.visibilityOf(caclucationDate));
		return caclucationDate;
	}

	// iconMarker
	@FindBy(xpath = "//img[@class='max-width-185']")
	private WebElement iconMarker;

	public WebElement iconMarker() {
		w.until(ExpectedConditions.visibilityOf(iconMarker));
		return iconMarker;
	}

	// scoreTooltip
	@FindBy(xpath = "//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//i[@class='fa fa-question-circle-o position-relative']")
	private WebElement scoreTooltip;

	public WebElement scoreTooltip() {
		w.until(ExpectedConditions.visibilityOf(scoreTooltip));
		return scoreTooltip;
	}

	// scoreTooltipText
	@FindBy(xpath = "//div[@class='-display-inline-block tooltip-container desktop-tooltip white']//div[1]")
	private WebElement scoreTooltipText;

	public WebElement scoreTooltipText() {
		w.until(ExpectedConditions.visibilityOf(scoreTooltipText));
		return scoreTooltipText;
	}

	// summaryCreditType
	@FindBy(xpath = "//div[@class='pt-30 pb-30 pr-20 pl-20 pr-xs-0 pl-xs-0']//div[1]//strong[1]")
	private WebElement summaryCreditType;

	public WebElement summaryCreditType() {
		w.until(ExpectedConditions.visibilityOf(summaryCreditType));
		return summaryCreditType;
	}

	// summaryCreditAmount
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 dotted-border-col']//div[2]//strong[1]")
	private WebElement summaryCreditAmount;

	public WebElement summaryCreditAmount() {
		w.until(ExpectedConditions.visibilityOf(summaryCreditAmount));
		return summaryCreditAmount;
	}

	// summaryInstallmentsCount
	@FindBy(xpath = "//div[3]//strong[1]")
	private WebElement summaryInstallmentsCount;

	public WebElement summaryInstallmentsCount() {
		w.until(ExpectedConditions.visibilityOf(summaryInstallmentsCount));
		return summaryInstallmentsCount;
	}

	// summaryInstallmentsValue
	@FindBy(xpath = "//div[@id='ux-desktop']//div[4]//strong[1]")
	private WebElement summaryInstallmentsValue;

	public WebElement summaryInstallmentsValue() {
		w.until(ExpectedConditions.visibilityOf(summaryInstallmentsValue));
		return summaryInstallmentsValue;
	}

	// punctualityPaymentTooltip
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement punctualityPaymentTooltip;

	public WebElement punctualityPaymentTooltip() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentTooltip));
		return punctualityPaymentTooltip;
	}

	// punctualityPaymentTooltipText
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement punctualityPaymentTooltipText;

	public WebElement punctualityPaymentTooltipText() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentTooltip));
		return punctualityPaymentTooltipText;
	}

	// punctualityPaymentSeeMore
	@FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement punctualityPaymentSeeMore;

	public WebElement punctualityPaymentSeeMore() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentSeeMore));
		return punctualityPaymentSeeMore;
	}

	// punctualityPaymentSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//a[@class='mr-20']")
	private WebElement punctualityPaymentSeeLess;

	public WebElement punctualityPaymentSeeLess() {
		w.until(ExpectedConditions.visibilityOf(punctualityPaymentSeeLess));
		return punctualityPaymentSeeLess;
	}

	// scoringTooltip
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement scoringTooltip;

	public WebElement scoringTooltip() {
		w.until(ExpectedConditions.visibilityOf(scoringTooltip));
		return scoringTooltip;
	}

	// scoringTooltipText
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement scoringTooltipText;

	public WebElement scoringTooltipText() {
		w.until(ExpectedConditions.visibilityOf(scoringTooltipText));
		return scoringTooltipText;
	}

	// scoringSeeMore
	@FindBy(xpath = "//div[@class='row mt-30']//div[2]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement scoringSeeMore;

	public WebElement scoringSeeMore() {
		w.until(ExpectedConditions.visibilityOf(scoringSeeMore));
		return scoringSeeMore;
	}

	// scoringSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//div[@class='text-right mt-30 analyzer-hide-details-anchor']//span")
	private WebElement scoringSeeLess;

	public WebElement scoringSeeLess() {
		w.until(ExpectedConditions.visibilityOf(scoringSeeLess));
		return scoringSeeLess;
	}

	// budgetChargeTooltip
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement budgetChargeTooltip;

	public WebElement budgetChargeTooltip() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeTooltip));
		return budgetChargeTooltip;
	}

	// budgetChargeTooltipText
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement budgetChargeTooltipText;

	public WebElement budgetChargeTooltipText() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeTooltipText));
		return budgetChargeTooltipText;
	}

	// budgetChargeSeeMore
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement budgetChargeSeeMore;

	public WebElement budgetChargeSeeMore() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeSeeMore));
		return budgetChargeSeeMore;
	}

	// budgetChargeSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//span")
	private WebElement budgetChargeSeeLess;

	public WebElement budgetChargeSeeLess() {
		w.until(ExpectedConditions.visibilityOf(budgetChargeSeeLess));
		return budgetChargeSeeLess;
	}

	// creditSumTooltip
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//a[1]//i[1]")
	private WebElement creditSumTooltip;

	public WebElement creditSumTooltip() {
		w.until(ExpectedConditions.visibilityOf(creditSumTooltip));
		return creditSumTooltip;
	}

	// creditSumTooltipText
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//h4[1]//uni-tooltip[1]//div[1]//div[@role='tooltip']")
	private WebElement creditSumTooltipText;

	public WebElement creditSumTooltipText() {
		w.until(ExpectedConditions.visibilityOf(creditSumTooltipText));
		return creditSumTooltipText;
	}

	// creditSumSeeMore
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[3]//div[1]//a[1]//span[1]")
	private WebElement creditSumSeeMore;

	public WebElement creditSumSeeMore() {
		w.until(ExpectedConditions.visibilityOf(creditSumSeeMore));
		return creditSumSeeMore;
	}

	// creditSumSeeLess
	@FindBy(xpath = "//makw-score-details-result[@class='hidden-xs']//div[@class='text-right mt-30 analyzer-hide-details-anchor']//span")
	private WebElement creditSumSeeLess;

	public WebElement creditSumSeeLess() {
		w.until(ExpectedConditions.visibilityOf(creditSumSeeLess));
		return creditSumSeeLess;
	}

	// calculateAnotherCredit
	@FindBy(xpath = "//div[@class='col-lg-10 col-md-9 col-sm-8 col-xs-12 pt-15 pt-xs-0 pull-right']//a")
	private WebElement calculateAnotherCredit;

	public WebElement calculateAnotherCredit() {
		w.until(ExpectedConditions.visibilityOf(calculateAnotherCredit));
		return calculateAnotherCredit;
	}

	// toHomePage
	@FindBy(xpath = "//a[@class='outline-button w-xs-100']")
	private WebElement toHomePage;

	public WebElement toHomePage() {
		w.until(ExpectedConditions.visibilityOf(toHomePage));
		return toHomePage;
	}

}
