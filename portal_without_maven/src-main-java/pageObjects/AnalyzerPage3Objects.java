package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalyzerPage3Objects {
	WebDriver driver;
	WebDriverWait w;

	public AnalyzerPage3Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		w = new WebDriverWait(driver, 5);
	}

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

	// hiddenObligatoryTextSourceOfIncome
	@FindBy(xpath = "//select[@id='finance-source']/following-sibling::div[@class='validate-text']")
	private WebElement hiddenObligatoryTextSourceOfIncome;

	public WebElement hiddenObligatoryTextSourceOfIncome() {
		w.until(ExpectedConditions.visibilityOf(hiddenObligatoryTextSourceOfIncome));
		return hiddenObligatoryTextSourceOfIncome;
	}

	// sourceOfIncome2
	@FindBy(xpath = "//select[@id='finance-source2']")
	private WebElement sourceOfIncome2;

	public WebElement sourceOfIncome2() {
		w.until(ExpectedConditions.visibilityOf(sourceOfIncome2));
		return sourceOfIncome2;
	}

	// hiddenObligatoryTextSourceOfIncome2
	@FindBy(xpath = "//select[@id='finance-source2']/following-sibling::div[@class='validate-text']")
	private WebElement hiddenObligatoryTextSourceOfIncome2;

	public WebElement hiddenObligatoryTextSourceOfIncome2() {
		w.until(ExpectedConditions.visibilityOf(hiddenObligatoryTextSourceOfIncome2));
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
}
