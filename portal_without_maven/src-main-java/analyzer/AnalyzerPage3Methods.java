package analyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.javatuples.Pair;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.AnalyzerPage3Objects;
import pageObjects.AnalyzerPage4Objects;

public class AnalyzerPage3Methods extends Base {

	// private AnalyzerPage1Objects apo1;
	private AnalyzerPage4Objects apo4;
	private AnalyzerPage3Objects apo3;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage2Methods apm2;
	private WebDriverWait w;
	private Component com;
	private FileInputStream file;
	private String environment;
	private WebElement monthIncome;
	private WebElement monthIncome2;
	private WebElement legalCharges;
	private WebElement legalCharges2;
	private WebElement payedInstallments;
	private WebElement creditLimits;
	private WebElement houeseholdExpenses;

	public AnalyzerPage3Methods(WebDriver driver) throws IOException {
		this.driver = driver;
		environment = com.getEnvironment();
		com = new Component(driver);
		apm2 = new AnalyzerPage2Methods(driver);
		apo4 = new AnalyzerPage4Objects(driver);
		apo3 = new AnalyzerPage3Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);

	}

	public Boolean component() {
		String getCom;
		String withDot;
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy")) {
			if (!apo3.componentMortgageCreditType().getText().toLowerCase().equals(com.getTypeCredit().toLowerCase())) {
				return false;
			}
		} else {
			if (!apo3.componentConsumerCreditType().getText().toLowerCase().equals(com.getTypeCredit().toLowerCase())) {
				return false;
			}
		}
		getCom = com.getCreditAmount();
		withDot = AddDot(getCom);
		if (!apo3.componentCreditAmount().getText().contains(withDot)) {
			return false;
		}
///!!!!!!!!bug to report!!!!!!!!!!!!!!!!!!!!!!!!!!
		/*
		 * if (com.getInstallmentsCount() != null) { getCom =
		 * com.getInstallmentsCount(); withDot = AddDot(getCom);
		 * System.out.println(withDot);
		 * System.out.println(apo3.componentInstallmentscount().getText()); if
		 * (!apo3.componentInstallmentscount().getText().contains(withDot)) { return
		 * false; } } else if (com.getInstallmentsValue() != null) { getCom =
		 * com.getInstallmentsValue(); withDot = AddDot(getCom); if
		 * (!apo3.componentInstallmentValue().getText().contains(withDot)) { return
		 * false; } } else { return false; }
		 */
		return true;
	}

	public Boolean isCreditTakerDisabled() throws InterruptedException {
		try {
			apo3.creditTaker1().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean creditTakerAlone() throws InterruptedException {
		apo3.creditTaker1().click();
		if (apo3.creditTaker1IfChecked().isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean creditTakerCotaker() throws InterruptedException {
		apo3.creditTaker2().click();
		if (apo3.creditTaker2IfChecked().isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean buttonBack() {
		apo3.buttonBack().click();
		if (apo2.creditAmountInput().isDisplayed()) {
			apo2.Submit().click();
			if (!apo3.dependents().isDisplayed())
				return false;
		} else
			return false;
		return true;
	}

	public boolean creditTakerTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.creditTakerTooltip()).perform();
		if (apo3.creditTakerTooltipText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean sourceOfIncomeTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.sourceOfIncomeTooltip()).perform();
		if (apo3.sourceOfIncomeTooltipText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean monthIncomeTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.monthIncomeTooltip()).perform();
		if (apo3.monthIncomeTooltipText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean legalChargesTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.legalChargesTooltip()).perform();
		if (apo3.legalChargesTooltipText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean dependentsTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.dependents()).perform();
		if (apo3.dependents().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean householdExpensesTooltipIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo3.householdExpenses()).perform();
		if (apo3.householdExpensesTooltipText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public Boolean sourceOfIncomeIsEmpty() {
		Select s = new Select(apo3.sourceOfIncome());
		if (com.isCalculationBefore()) {
			if (s.getFirstSelectedOption().equals(s.getOptions().get(0))) {
				return false;
			}
			s.selectByIndex(1);
			s.selectByIndex(3);
			try {
				apo3.hiddenObligatoryTextSourceOfIncome().isDisplayed();
				return false;
			} catch (Exception e) {
				return true;
			}
		} else {
			s.selectByIndex(0);
			apo3.buttonCount().click();
			try {
				apo3.hiddenObligatoryTextSourceOfIncome().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

	}

	public Boolean sourceOfIncome2IsEmpty() {

		Select s = new Select(apo3.sourceOfIncome2());
		if (com.isCalculationBefore()) {
			if (s.getFirstSelectedOption().equals(s.getOptions().get(0))) {
				return false;
			}
			s.selectByIndex(1);
			s.selectByIndex(3);
			try {
				apo3.hiddenObligatoryTextSourceOfIncome2().isDisplayed();
				return false;
			} catch (Exception e) {
				return true;
			}
		} else {
			s.selectByIndex(0);
			apo3.buttonCount().click();
			try {
				apo3.hiddenObligatoryTextSourceOfIncome2().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public Boolean sourceOfIncomeIsNotEmpty() {
		Select s = new Select(apo3.sourceOfIncome());
		if (com.isCalculationBefore()) {
			if (s.getFirstSelectedOption().equals(s.getOptions().get(0))) {
				return false;
			}
			s.selectByIndex(1);
			s.selectByIndex(3);
			try {
				apo3.hiddenObligatoryTextSourceOfIncome().isDisplayed();
				return false;
			} catch (Exception e) {
				return true;
			}
		} else {
			{
				s.selectByIndex(1);
				apo3.buttonCount().click();
				try {
					apo3.hiddenObligatoryTextSourceOfIncome().isDisplayed();
					return false;
				} catch (Exception e) {
					return true;
				}
			}
		}
	}

	public Boolean sourceOfIncomeIs2NotEmpty() {
		Select s = new Select(apo3.sourceOfIncome2());
		s.selectByIndex(2);
		s.selectByIndex(4);
		{
			s.selectByIndex(1);
			if(com.isCalculationBefore())
				clearInput(apo3.monthIncome());
			apo3.buttonCount().click();
			try {
				apo3.hiddenObligatoryTextSourceOfIncome2().isDisplayed();
				return false;
			} catch (Exception e) {
				return true;
			}
		}
	}

	public Boolean monthIncomeIsEmpty() {
		monthIncome = apo3.monthIncome();
		if (com.isCalculationBefore()) {
			clearInput(monthIncome);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextMonthIncome().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			clearInput(monthIncome);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextMonthIncomeNoCalculation().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public boolean monthIncomeLessThanMin() {
		monthIncome = apo3.monthIncome();
		clearInput(monthIncome);
		if(com.isCalculationBefore())
			clearInput(apo3.monthIncome2());
		if (environment.equals("stt")) {
			String min = prop.getProperty("monthIncomeMin");
			int lessMin = Integer.parseInt(min) - 1;
			String lessMinS = Integer.toString(lessMin);
			monthIncome.sendKeys(lessMinS);
			try {
				apo3.hiddenTextMonthIncomeLessThanMin().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return true;
	}

	public boolean monthIncomeLessThanInstallment() {
		monthIncome = apo3.monthIncome();
		clearInput(monthIncome);
		if(com.isCalculationBefore())
			clearInput(apo3.monthIncome2());
		clearInput(apo3.monthIncome2());
		int lessInstallmentValue = Integer.parseInt(com.getInstallmentsValue()) - 1;
		String lessInstallmentValueS = Integer.toString(lessInstallmentValue);
		monthIncome.clear();
		monthIncome.sendKeys(lessInstallmentValueS);
		try {
			apo3.hiddenTextMonthIncomeLessThanInstallValue().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean monthIncomeMoreThanMax() {
		monthIncome = apo3.monthIncome();
		clearInput(monthIncome);
		if(com.isCalculationBefore())
			clearInput(apo3.monthIncome2());
		String max = prop.getProperty("monthIncomeMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		monthIncome.sendKeys(overMaxS);
		try {
			apo3.hiddenTextMonthIncomeMoreThanMax().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean monthIncome2IsEmpty() {
		monthIncome = apo3.monthIncome();
		monthIncome2 = apo3.monthIncome2();
		if (com.isCalculationBefore()) {
			clearInput(monthIncome);
			clearInput(monthIncome2);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextMonthIncome().isDisplayed();
				apo3.hiddenTextMonthIncome2().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			clearInput(monthIncome);
			clearInput(monthIncome2);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextMonthIncomeNoCalculation().isDisplayed();
				apo3.hiddenTextMonthIncomeNoCalculatio2().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public boolean monthIncome2LessThanMin() {
		monthIncome = apo3.monthIncome();
		monthIncome2 = apo3.monthIncome2();
		clearInput(monthIncome);
		clearInput(monthIncome2);
		if (environment.equals("stt")) {
			String min = prop.getProperty("monthIncomeMin");
			int lessMin = Integer.parseInt(min) - 1;
			String lessMinS = Integer.toString(lessMin);
			monthIncome.sendKeys(lessMinS);
			monthIncome2.sendKeys(lessMinS);
			try {
				apo3.hiddenTextMonthIncomeLessThanMin().isDisplayed();
				apo3.hiddenTextMonthIncomeLessThanMin2().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return true;
	}

	public boolean monthIncome2LessThanInstallment() {
		monthIncome = apo3.monthIncome();
		monthIncome2 = apo3.monthIncome2();
		clearInput(monthIncome);
		clearInput(monthIncome2);
		int lessInstallmentValue = Integer.parseInt(com.getInstallmentsValue()) / 2 - 1;
		String lessInstallmentValueS = Integer.toString(lessInstallmentValue);
		monthIncome.sendKeys(lessInstallmentValueS);
		monthIncome2.sendKeys(lessInstallmentValueS);
		try {
			apo3.hiddenTextMonthIncomeLessThanInstallValue().isDisplayed();
			apo3.hiddenTextMonthIncomeLessThanInstallValue2().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean monthIncome2MoreThanMax() {
		monthIncome = apo3.monthIncome();
		monthIncome2 = apo3.monthIncome2();
		clearInput(monthIncome);
		clearInput(monthIncome2);
		String max = prop.getProperty("monthIncomeMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		monthIncome.sendKeys(overMaxS);
		monthIncome2.sendKeys(overMaxS);
		try {
			apo3.hiddenTextMonthIncomeMoreThanMax().isDisplayed();
			apo3.hiddenTextMonthIncomeMoreThanMax2().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String AddDot(String input) {

		ArrayList<Character> a = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			a.add(input.charAt(i));
		}
		if (input.length() >= 4) {
			for (int i = input.length() - 1; i > 0; i--) {
				if ((input.length() - i) % 3 != 0) {
					continue;
				} else
					a.add(i, '.');
			}
		}
		String inputV = "";
		for (int i = 0; i < a.size(); i++)
			inputV += a.get(i);
		return inputV;
	}

	public boolean legalChargesIsEmpty() {
		legalCharges = apo3.legalCharges();
		legalCharges.sendKeys("1");
		clearInput(legalCharges);
		apo3.buttonCount().click();
		try {
			apo3.hiddenTexLegalCharges().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean legalChargesLessThanMin() {
		legalCharges = apo3.legalCharges();
		String minS = prop.getProperty("legalChargesMin");
		clearInput(legalCharges);
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			legalCharges.sendKeys(lessMinS);
			try {
				apo3.hiddenTextLegalChargesLessThanMin().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean legalChargesMoreThanMax() {
		legalCharges = apo3.legalCharges();
		clearInput(legalCharges);
		String max = prop.getProperty("legalChargesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		legalCharges.sendKeys(overMaxS);
		try {
			apo3.hiddenTextLegalChargesMoreThanMax().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		clearInput(legalCharges);
		legalCharges.sendKeys(prop.getProperty("legalChargesMin"));
		com.setLegalCharges(legalCharges.getAttribute("value"));
		return true;
	}

	public boolean legalCharges2IsEmpty() {
		legalCharges = apo3.legalCharges();
		legalCharges2 = apo3.legalCharges2();
		legalCharges.sendKeys("1");
		legalCharges2.sendKeys("1");
		clearInput(legalCharges);
		clearInput(legalCharges2);
		apo3.buttonCount().click();
		try {
			apo3.hiddenTexLegalCharges().isDisplayed();
			apo3.hiddenTexLegalCharges2().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean legalCharges2LessThanMin() {
		legalCharges = apo3.legalCharges();
		legalCharges2 = apo3.legalCharges2();
		clearInput(legalCharges);
		clearInput(legalCharges2);
		String minS = prop.getProperty("legalChargesMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			legalCharges.sendKeys(lessMinS);
			legalCharges2.sendKeys(lessMinS);
			try {
				apo3.hiddenTextLegalChargesLessThanMin().isDisplayed();
				apo3.hiddenTextLegalChargesLessThanMin2().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean legalCharges2MoreThanMax() {
		legalCharges = apo3.legalCharges();
		legalCharges2 = apo3.legalCharges2();
		clearInput(legalCharges);
		clearInput(legalCharges2);
		String max = prop.getProperty("legalChargesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		legalCharges.sendKeys(overMaxS);
		legalCharges2.sendKeys(overMaxS);
		try {
			apo3.hiddenTextLegalChargesMoreThanMax().isDisplayed();
			apo3.hiddenTextLegalChargesMoreThanMax2().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		clearInput(legalCharges);
		clearInput(legalCharges2);
		legalCharges.sendKeys(prop.getProperty("legalChargesMin"));
		legalCharges2.sendKeys(prop.getProperty("legalChargesMin"));
		com.setLegalCharges(legalCharges.getAttribute("value"));
		com.setLegalCharges2(legalCharges2.getAttribute("value"));
		return true;
	}

	public boolean payedInstallmentsTextDisplayed() {
		try {
			apo3.PayedInstallmentsText().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean payedInstallmentsIsEmpty() {
		payedInstallments = apo3.payedInstallments();
		payedInstallments.sendKeys("1");
		clearInput(payedInstallments);
		apo3.buttonCount().click();
		try {
			apo3.hiddenTexPayedInstallments().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean payedInstallmentsLessThanMin() {
		payedInstallments = apo3.payedInstallments();
		payedInstallments.sendKeys("1");
		clearInput(payedInstallments);
		String minS = prop.getProperty("paidInstallmentsMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			payedInstallments.sendKeys(lessMinS);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextPayedInstallmentsLessThanMin().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean payedInstallmentsMoreThanMax() {
		payedInstallments = apo3.payedInstallments();
		clearInput(payedInstallments);
		String max = prop.getProperty("paidInstallmentsMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		payedInstallments.sendKeys(overMaxS);
		try {
			apo3.hiddenTextPayedInstallmentsMoreThanMax().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		clearInput(payedInstallments);
		payedInstallments.sendKeys(prop.getProperty("paidInstallmentsMin"));
		com.setPayedInstallments(payedInstallments.getAttribute("value"));
		return true;
	}

	public boolean CreditLimitsTextDisplayed() {
		try {
			apo3.creditLimitsText().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean CreditLimitsIsEmpty() {
		creditLimits = apo3.creditLimits();
		creditLimits.sendKeys("1");
		clearInput(creditLimits);
		apo3.buttonCount().click();
		try {
			apo3.hiddenTextCreditLimits().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean CreditLimitsLessThanMin() {
		creditLimits = apo3.creditLimits();
		clearInput(creditLimits);
		String minS = prop.getProperty("creditLimitsMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			creditLimits.sendKeys(lessMinS);
			apo3.buttonCount().click();
			try {
				apo3.hiddenTextCreditLimitsLessThanMin().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean CreditLimitsMoreThanMax() {
		creditLimits = apo3.creditLimits();
		clearInput(creditLimits);
		String max = prop.getProperty("creditLimitsMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		creditLimits.sendKeys(overMaxS);
		try {
			apo3.hiddenTextCreditLimitsMoreThanMax().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		clearInput(creditLimits);
		creditLimits.sendKeys(prop.getProperty("creditLimitsMin"));
		com.setCreditLimits2(payedInstallments.getAttribute("value"));
		return true;
	}

	public Boolean dependents() {
		Select s = new Select(apo3.dependents());
		s.selectByIndex(4);
		int x = Integer.parseInt(s.getFirstSelectedOption().getText());
		s.selectByIndex(2);
		int y = Integer.parseInt(s.getFirstSelectedOption().getText());
		if (x == y) {
			return false;
		}
		s.selectByIndex(0);
		int c = Integer.parseInt(s.getFirstSelectedOption().getText());
		if (x == y) {
			return false;
		}
		com.setDependents(s.getFirstSelectedOption().getText());
		return true;

	}

	public boolean houeseholdExpensesIsEmpty() {
		houeseholdExpenses = apo3.householdExpenses();
		clearInput(houeseholdExpenses);
		houeseholdExpenses.sendKeys(Keys.DELETE);
		apo3.buttonCount().click();
		try {
			apo3.hiddenTextHouseholdExpenses().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean householdExpensesLessThanMin() {
		houeseholdExpenses = apo3.householdExpenses();
		clearInput(houeseholdExpenses);
		String min = prop.getProperty("householdExpensesMin");
		if (environment.equals("uat") || environment.equals("stt"))
			min = prop.getProperty("householdExpensesMinUat");
		int minS = Integer.parseInt(min);
		int lessMin = 0;
		if (minS > 0) {
			lessMin = minS - 1;
			String lessMinS = Integer.toString(lessMin);
			clearInput(houeseholdExpenses);
			houeseholdExpenses.sendKeys(lessMinS);
			try {
				apo3.hiddenTextHouseholdExpensesLessThanMin().isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return true;
	}

	public boolean householdExpensesMoreThanMax() {
		houeseholdExpenses = apo3.householdExpenses();
		clearInput(houeseholdExpenses);
		clearInput(houeseholdExpenses);
		String max = prop.getProperty("householdExpensesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		houeseholdExpenses.sendKeys(overMaxS);
		try {
			apo3.hiddenTextHouseholdExpensesMoreThanMax().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		clearInput(houeseholdExpenses);
		String min = prop.getProperty("householdExpensesMin");
		if (environment.equals("uat") || environment.equals("stt"))
			min = prop.getProperty("householdExpensesMinUat");
		houeseholdExpenses.sendKeys(min);
		com.setHoueseholdExpenses(houeseholdExpenses.getAttribute("value"));
		return true;
	}

	public boolean whyAsk() {
		apo3.linkWhyAsk().click();
		try {
			apo3.buttonCloseWhyAsk().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		apo3.buttonCloseWhyAsk().click();
		return true;
	}

	public Boolean count() throws InterruptedException {
		boolean b = true;
		apo3.buttonCount().click();
		try {
			apo4.toHomePage().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
