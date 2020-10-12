package analyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.javatuples.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.Base;
import base.Component;
import pageObjects.AnalizatorObjects;
import pageObjects.SignInObjects;

@SuppressWarnings("static-access")
public class Analyzer extends Base {
	private AnalizatorObjects ao;
	private WebDriver driver;
	private Component com;
	private WebElement hiddenTextEmpty;
	private String inputV;
	private String minHiddenText;
	private String maxHiddenText;
	private WebElement tooltipLocal;
	private WebElement tooltipText;
	private FileInputStream file;
	private SignInObjects signIn;
	private String environment;

	public Analyzer(WebDriver driver) throws IOException {
		this.driver = driver;
		com = new Component(driver);
		ao = new AnalizatorObjects(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);
		signIn = new SignInObjects(driver);
	}

	public void Zaloguj(String x, String y, String z) throws InterruptedException, IOException {
		environment = com.getEnvironment();
		String email = x;
		String pass = y;
		String pesel = z;

		signIn.CookiesComunnicateClose().click();
		signIn.Email().sendKeys(email);
		signIn.Password().sendKeys(pass);
		Thread.sleep(5000);

		if (environment.equals("prod") || environment.equals("stt")) {
			WebElement[] tab = signIn.getActivePeselNumbers();
			char[] peselNumber = Pesel(pesel);
			for (int i = 0; i < 11; i++) {
				if (tab[i] == null) {
					continue;
				} else {
					String peselI = Character.toString(peselNumber[i]);

					tab[i].sendKeys(peselI);
				}
			}
		}
		signIn.Submit().click();
		if (signIn.isElementPresent()) {
			signIn.closeAnotherSessionCheckbox().click();
			signIn.Submit().click();
		}
		signIn.ProfileSubmit().click();

	}

	public char[] Pesel(String pesel) {
		char[] peselNumber = new char[11];
		for (int i = 0; i < 11; i++) {
			peselNumber[i] = pesel.charAt(i);
		}
		return peselNumber;
	}

	public boolean wasCalculationBefore() throws InterruptedException, IOException {
		String s = ao.firstRadioSource().getAttribute("for");
		boolean b = true;
		if (s.contains("1b")) {
			com.setCalculationBefore(true);
			b = true;
		} else if (s.contains("1a")) {
			com.setCalculationBefore(false);
			b = false;
		} else
			b = false;
		return b;

	}

	public Pair<Boolean, String> lastCalculationDetails() throws InterruptedException, IOException {

		WebElement a = ao.firstRadioSource();
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		if (wasCalculationBefore()) {
			ao.detailsLastCalculation().click();
			com.setCreditChance(ao.chanceText().getText());
			com.setCreditAmount(ao.summaryCreditAmount().getText());
			com.setInstallmentsCount(ao.summaryInstallmentsCount().getText());
			ao.toHomePage().click();
			System.out.println("wracam na home page");
			Thread.sleep(5000);
			if (ao.isElementPresent(ao.firstRadioSource())) {
				if (!(ao.lastAmount().getText().contains(com.getCreditAmount())
						&& ao.lastChance().getText().contains(com.getCreditChance())
						&& ao.lastPeriod().getText().contains(com.getInstallmentsCount()))) {
					b = false;
					st = "Last calculation data are not equals with data from last calculation summary";
					p = Pair.with(b, st);
					return p;
				}
				return p;
			} else {
				b = false;
				st = "Back to a previous page doesn't work";
				p = Pair.with(b, st);
				return p;
			}
		}
		return p;

	}

	public Pair<Boolean, String> TypeCredit(String s) throws InterruptedException, IOException {

		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);

		if (com.isCalculationBefore()) {
			if (s.equals("consumer")) {
				ao.consumerCreditType().click();
				if (ao.consumerCreditTypeIfChecked().isSelected()) {
					com.setTypeCredit(ao.consumerCreditType().getText());
					ao.creditTypeSubmit().click();
				} else {
					b = false;
					st = "Consumer credit type is not selected";
					p = Pair.with(b, st);
					return p;
				}
			} else if (s.equals("mortgage")) {
				ao.mortgageCreditType().click();
				if (ao.consumerMortgageTypeIfChecked().isSelected()) {
					com.setTypeCredit(ao.mortgageCreditType().getText());
					ao.creditTypeSubmit().click();
				} else {
					b = false;
					st = "Mortgage credit type is not selected";
					p = Pair.with(b, st);
					return p;
				}
			} else {
				b = false;
				st = "Credit type is not checked";
				p = Pair.with(b, st);
				return p;
			}
		} else if (!com.isCalculationBefore()) {
			if (s.equals("consumer")) {
				ao.consumerCreditTypeNoCalculation().click();
				if (ao.consumerCreditTypeIfCheckedNoCalculation().isSelected()) {
					com.setTypeCredit(ao.consumerCreditTypeNoCalculation().getText());
					ao.creditTypeSubmitNoCalculation().click();
				} else {
					b = false;
					st = "Consumer credit type is not selected";
					p = Pair.with(b, st);
					return p;
				}
			} else if (s.equals("mortgage")) {
				ao.mortgageCreditTypeNoCalculation().click();
				if (ao.consumerMortgageTypeIfCheckedNoCalculation().isSelected()) {
					com.setTypeCredit(ao.mortgageCreditTypeNoCalculation().getText());
					ao.creditTypeSubmitNoCalculation().click();
				} else {
					b = false;
					st = "Mortgage credit type is not selected";
					p = Pair.with(b, st);
					return p;
				}
			} else {
				b = false;
				st = "No credit type is checked";
				p = Pair.with(b, st);
				return p;
			}
		}

		return p;

	}

	public Pair<Boolean, String> SliderVerify(WebElement sliderPoint, WebElement slider, WebElement inputValue,
			WebElement min, WebElement max) throws InterruptedException, IOException {
		String st = "";
		boolean b = true;
		Pair<Boolean, String> p = Pair.with(b, st);

		if (ao.isElementPresent(sliderPoint)) {
			Dimension sliderPointSize = sliderPoint.getSize();
			int sliderPointWidth = sliderPointSize.getWidth();
			int sliderPointX = sliderPoint.getLocation().getX();
			Dimension sliderSize = slider.getSize();
			int sliderWidth = sliderSize.getWidth();
			int sliderMin = sliderPointX - slider.getLocation().getX() + sliderPointWidth;
			Actions builder = new Actions(driver);
			builder.moveToElement(sliderPoint).click().dragAndDropBy(sliderPoint, -sliderMin, 0).build().perform();
			String input = inputValue.getAttribute("value");
			String inputV = CountInputValue(input);
			String minValue = min.getAttribute("data-value");
			if (!inputV.equals(minValue)) {
				b = false;
				st = "No min value";
				p = Pair.with(b, st);
				return p;
			}
			sliderPointX = sliderPoint.getLocation().getX();
			int sliderMax = sliderWidth - sliderPointX + slider.getLocation().getX();
			builder.moveToElement(sliderPoint).click().dragAndDropBy(sliderPoint, sliderMax, 0).build().perform();
			input = inputValue.getAttribute("value");
			inputV = CountInputValue(input);
			String maxValue = max.getAttribute("data-value");
			if (!inputV.equals(maxValue)) {
				b = false;
				st = "No max value";
				p = Pair.with(b, st);
				return p;
			}
			return p;
		} else {
			b = false;
			st = "Slider is not displayed";
			p = Pair.with(b, st);
			p.getValue0();
			p.getValue1();
			return p;
		}
	}

	public String CountInputValue(String input) {
		inputV = "";
		ArrayList<Character> a = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			a.add(input.charAt(i));
		}
		for (int i = 0; i < a.size(); i++) {
			if (Character.isDigit(a.get(i)) && a.get(i) != null) {
				inputV += a.get(i);
			} else
				continue;
		}
		return inputV;
	}

	public Pair<Boolean, String> EmptyInput(WebElement input, String s) throws InterruptedException {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		String title1 = driver.getTitle();
		clearInput(input);
		if (s == "Amount")
			hiddenTextEmpty = ao.HiddenObligatoryTextAmount();
		else if (s == "Installments")
			hiddenTextEmpty = ao.HiddenObligatoryTextInstallments();
		else if (s == "Property")
			hiddenTextEmpty = ao.hiddenObligatoryTextPropertyValue();
		String text = hiddenTextEmpty.getText();
		if (!ao.isElementPresent(hiddenTextEmpty)) {
			b = false;
			st = "Warning about an empty input is invisible";
			p = Pair.with(b, st);
			return p;
		}
		ao.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			b = false;
			st = "Click on the submit without value direct to a new site";
			p = Pair.with(b, st);
			return p;
		}
		return p;
	}

	public void clearInput(WebElement input) {
		int j = input.getAttribute("value").length();
		for (int i = 0; i < j; i++) {
			input.sendKeys(Keys.BACK_SPACE);
		}

	}

	public Pair<Boolean, String> MinValueInputLess(WebElement input, WebElement minValue, String s) {
		boolean b = true;
		String st = "";
		String minV;
		int min;
		Pair<Boolean, String> p = Pair.with(b, st);
		String title1 = driver.getTitle();
		if (s == "Property") {
			minV = input.getAttribute("min");
		} else {
			minV = minValue.getAttribute("data-value");
		}
		min = Integer.parseInt(minV) - 1;

		input.clear();
		input.sendKeys(Integer.toString(min));
		if (s == "Amount") {
			minHiddenText = ao.HiddenMinTextAmount().getText();
			if (!ao.isElementPresent(ao.HiddenMinTextAmount())) {
				b = false;
				st = "value less than min -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		} else if (s == "Installtments") {
			minHiddenText = ao.hiddenMinTextInstallments().getText();
			if (!ao.isElementPresent(ao.hiddenMinTextInstallments())) {
				b = false;
				st = "value less than min -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		} else if (s == "Property") {
			minHiddenText = ao.hiddenMinTextPropertyValue().getText();
			if (!ao.isElementPresent(ao.hiddenMinTextPropertyValue())) {
				b = false;
				st = "value less than min -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		}
		ao.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			b = false;
			st = "Click on the submit with value less than minimum value direct to a new site";
			p = Pair.with(b, st);
			return p;
		}
		return p;

	}

	public Pair<Boolean, String> MaxValueInputMore(WebElement input, WebElement maxValue, String s) {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		String maxV;
		int max;
		String title1 = driver.getTitle();
		if (s == "Property") {
			maxV = input.getAttribute("max");
		} else
			maxV = maxValue.getAttribute("data-value");
		max = Integer.parseInt(maxV) + 1;
		input.clear();
		input.sendKeys(Integer.toString(max));
		if (s == "Amount") {
			maxHiddenText = ao.hiddenMaxTextAmount().getText();
			if (!ao.isElementPresent(ao.hiddenMaxTextAmount())) {
				b = false;
				st = "value more than max -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		} else if (s == "Installtments") {
			maxHiddenText = ao.hiddenMaxTextInstallments().getText();
			if (!ao.isElementPresent(ao.hiddenMaxTextInstallments())) {
				b = false;
				st = "value more than max -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		} else if (s == "Property") {
			maxHiddenText = ao.hiddenMaxTextPropertyValue().getText();
			if (!ao.isElementPresent(ao.hiddenMaxTextPropertyValue())) {
				b = false;
				st = "value more than max -  text invisible";
				p = Pair.with(b, st);
				return p;
			}
		}
		ao.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			b = false;
			st = "Click on the submit with value more than maximum value direct to a new site";
			p = Pair.with(b, st);
			return p;
		}
		return p;
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

	public Pair<Boolean, String> relationAmountProperty() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement text;
		String minProperty = ao.propertyValueInput().getAttribute("min");
		String maxProperty = ao.propertyValueInput().getAttribute("max");
		String maxValueAmount = ao.CreditAmountMax().getAttribute("data-value");
		WebElement creditAmountInput = ao.creditAmountInput();
		WebElement propertyValueInput = ao.propertyValueInput();
		propertyValueInput.clear();
		creditAmountInput.clear();
		propertyValueInput.sendKeys(minProperty);
		creditAmountInput.sendKeys(maxValueAmount);
		ao.Submit().click();
		text = ao.hiddenRelationCreditPropertyTextAmount();
		if (!text.getText().contains("80%")) {
			b = false;
			st = "Incorrect text about relation between credit amount and property value";
			p = Pair.with(b, st);
			return p;
		}
		propertyValueInput.clear();
		creditAmountInput.clear();
		propertyValueInput.sendKeys(maxProperty);
		return p;
	}

	public Pair<Boolean, String> relationAmountInstallments() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement text;
		String maxValueAmount = "";
		// System.out.println(com.getTypeCredit());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy".toLowerCase())) {
			String maxProperty = ao.propertyValueInput().getAttribute("max");
			maxValueAmount = String.valueOf((Integer.parseInt(maxProperty) * 0.8));
		} else if (com.getTypeCredit().toLowerCase().equals("konsumpcyjny"))
			maxValueAmount = ao.CreditAmountMax().getAttribute("data-value");
		else {
			b = false;
			st = "Credit type is no checked";
			p = Pair.with(b, st);
			return p;
		}
		String minValueAmount = ao.CreditAmountMin().getAttribute("data-value");

		ao.InstallmentsCount().click();
		String minValueInstallmentsCount = ao.CreditInstallmentsMin().getAttribute("data-value");
		String maxValueInstallmentsCount = ao.CreditInstallmentsMax().getAttribute("data-value");
		ao.InstallmentsValue().click();
		String minValueInstallmentsValue = ao.CreditInstallmentsMin().getAttribute("data-value");
		String maxValueInstallmentsValue = ao.CreditInstallmentsMax().getAttribute("data-value");

		WebElement creditAmountInput = ao.creditAmountInput();
		WebElement creditInstallmentsInput = ao.CreditInstallmentsInput();

		// count of installments more than maximum
		creditAmountInput.clear();
		creditAmountInput.sendKeys(maxValueAmount);
		ao.InstallmentsCount().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(minValueInstallmentsCount);
		ao.Submit().click();
		text = ao.moreThanMaksInstallment();
		if (!(text.getText().contains("Przy podanej liczbie") & text.getText().contains("maksimum"))) {
			b = false;
			st = "Incorrect text about maximum installment value";
			p = Pair.with(b, st);
			return p;
		}

		// count of installments less than minimum
		creditAmountInput.clear();
		creditAmountInput.sendKeys(minValueAmount);
		ao.InstallmentsCount().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(maxValueInstallmentsCount);
		ao.Submit().click();
		text = ao.lessThanMinInstallment();
		if (!text.getText().contains("Przy podanej liczbie") & text.getText().contains("minimum")) {
			b = false;
			st = "Incorrect text about maximum installment value";
			p = Pair.with(b, st);
			return p;
		}

		// too small installment
		creditAmountInput.clear();
		creditAmountInput.sendKeys(maxValueAmount);
		ao.InstallmentsValue().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(minValueInstallmentsValue);
		ao.Submit().click();
		text = ao.tooSmallInstallment();
		if (!text.getText().contains("Zbyt niska rata")) {
			b = false;
			st = "Incorrect text about too small installment";
			p = Pair.with(b, st);
			return p;
		}

		// too large installment
		creditAmountInput.clear();
		creditAmountInput.sendKeys(minValueAmount);
		ao.InstallmentsValue().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(maxValueInstallmentsValue);
		ao.Submit().click();
		text = ao.tooLargeInstallment();
		if (!text.getText().contains("Zbyt wysoka rata")) {
			b = false;
			st = "Incorrect text about too large installment";
			p = Pair.with(b, st);
			return p;
		}
		return p;

	}

	public Pair<Boolean, String> checkbox() throws InterruptedException {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		if (ao.isElementPresent(ao.analyzerCheckbox())) {
			ao.analyzerCheckbox().click();
			if (!ao.analyzerCheckboxIfChecked().isSelected()) {
				b = false;
				st = "The checkbox is not selected";
				p = Pair.with(b, st);
				return p;
			}
		}
		return p;

	}

	public Pair<Boolean, WebElement> getTooltipText(String s) {
		WebElement tooltipLocal1 = tooltip(s);
		moveToTooltip(tooltipLocal1);
		Pair<Boolean, WebElement> p = Pair.with(tooltipText(s).getValue0(), tooltipText(s).getValue1());
		return p;
	}

	public WebElement tooltip(String s) {
		if (s.equals("tooltipAmount")) {
			tooltipLocal = ao.tooltipAmount();
		} else if (s.equals("tooltipHowToPay")) {
			tooltipLocal = ao.tooltipHowToPay();

		} else if (s.equals("sourceOfIncomeTooltip")) {
			tooltipLocal = ao.sourceOfIncomeTooltip();

		} else if (s.equals("monthIncomeTooltip")) {
			tooltipLocal = ao.monthIncomeTooltip();

		} else if (s.equals("legalChargesTooltip")) {
			tooltipLocal = ao.legalChargesTooltip();

		} else if (s.equals("dependentsTooltip")) {
			tooltipLocal = ao.dependentsTooltip();

		} else if (s.equals("householdExpensesTooltip")) {
			tooltipLocal = ao.householdExpensesTooltip();

		} else if (s.equals("scoreTooltip")) {
			tooltipLocal = ao.scoreTooltip();

		} else if (s.equals("punctualityPaymentTooltip")) {
			tooltipLocal = ao.punctualityPaymentTooltip();

		} else if (s.equals("scoringTooltip")) {
			tooltipLocal = ao.scoringTooltip();

		} else if (s.equals("budgetChargeTooltip")) {
			tooltipLocal = ao.budgetChargeTooltip();

		} else if (s.equals("creditSumTooltip")) {
			tooltipLocal = ao.creditSumTooltip();

		} else if (s.equals("propertyValueTooltip")) {
			tooltipLocal = ao.tooltipPropertyValue();

		} else if (s.equals("creditTakerTooltip")) {
			tooltipLocal = ao.creditTakerTooltip();

		}

		return tooltipLocal;

	}

	public void moveToTooltip(WebElement tooltip) {
		Actions actions = new Actions(driver);
		actions.moveToElement(tooltip).perform();

	}

	public Pair<Boolean, WebElement> tooltipText(String s) {
		boolean b = true;
		Pair<Boolean, WebElement> p = Pair.with(b, tooltipText);

		AnalizatorObjects ao = new AnalizatorObjects(driver);
		if (s.equals("tooltipAmount")) {
			tooltipText = ao.tooltipAmountText();
			com.setTooltipAmount(tooltipText.getText());
		} else if (s.equals("tooltipHowToPay")) {
			tooltipText = ao.tooltipHowToPayText();
			com.setTooltipHowToPay(tooltipText.getText());
		} else if (s.equals("sourceOfIncomeTooltip")) {
			tooltipText = ao.sourceOfIncomeTooltipText();
			com.setSourceOfIncomeTooltip(tooltipText.getText());
		} else if (s.equals("monthIncomeTooltip")) {
			tooltipText = ao.monthIncomeTooltipText();
			com.setMonthIncomeTooltip(tooltipText.getText());
		} else if (s.equals("legalChargesTooltip")) {
			tooltipText = ao.legalChargesTooltipText();
			com.setLegalChargesTooltip(tooltipText.getText());
		} else if (s.equals("dependentsTooltip")) {
			tooltipText = ao.dependentsTooltipText();
			com.setDependentsTooltip(tooltipText.getText());
		} else if (s.equals("householdExpensesTooltip")) {
			tooltipText = ao.householdExpensesTooltipText();
			com.setHouseholdExpensesTooltip(tooltipText.getText());
		} else if (s.equals("scoreTooltip")) {
			tooltipText = ao.scoreTooltipText();
			com.setScoreTooltip(tooltipText.getText());
		} else if (s.equals("punctualityPaymentTooltip")) {
			tooltipText = ao.punctualityPaymentTooltipText();
			com.setPunctualityPaymentTooltip(tooltipText.getText());
		} else if (s.equals("scoringTooltip")) {
			tooltipText = ao.scoringTooltipText();
			com.setScoringTooltip(tooltipText.getText());
		} else if (s.equals("budgetChargeTooltip")) {
			tooltipText = ao.budgetChargeTooltipText();
			com.setBudgetChargeTooltip(tooltipText.getText());
		} else if (s.equals("creditSumTooltip")) {
			tooltipText = ao.creditSumTooltipText();
			com.setCreditSumTooltip(tooltipText.getText());
		} else if (s.equals("propertyValueTooltip")) {
			tooltipText = ao.tooltipPropertyValueText();
			com.setPropertyValueTooltip(tooltipText.getText());
		} else if (s.equals("creditTakerTooltip")) {
			tooltipText = ao.creditTakerTooltipText();
			com.setCreditTakerTooltip(tooltipText.getText());
		}
		if (tooltipText.getText().isEmpty()) {
			b = false;
			p = Pair.with(b, tooltipText);
			return p;
		}

		return p;
	}

	public Boolean amountCreditCriteriaSubmit() {
		boolean b = true;
		WebElement input;
		int min;
		String title1 = driver.getCurrentUrl();
		String amountValue = "";
		WebElement input2 = ao.CreditInstallmentsInput();
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy")) {
			int propertyValueInt = Integer.parseInt(ao.propertyValueInput().getAttribute("max")) / 2;
			String propertyValue = String.valueOf(propertyValueInt);
			input = ao.propertyValueInput();
			input.clear();
			input.sendKeys(propertyValue);
			com.setPropertyValue(input.getAttribute("value"));
			int amountValueInt = propertyValueInt / 2;
			amountValue = String.valueOf(amountValueInt);
			input = ao.creditAmountInput();
			input.clear();
			input.sendKeys(amountValue);
			com.setCreditAmount(input.getAttribute("value"));
			ao.InstallmentsCount().click();
			String ValueMaxV = ao.CreditInstallmentsMax().getAttribute("data-value");
			int max = Integer.parseInt(ValueMaxV);
			input2 = ao.CreditInstallmentsInput();
			input2.clear();
			input2.sendKeys(Integer.toString(max));
		}
		if (com.getTypeCredit().toLowerCase().equals("konsumpcyjny")) {

			amountValue = String.valueOf(ao.CreditAmountMin().getAttribute("data-value"));
			input = ao.creditAmountInput();
			input.clear();
			input.sendKeys(amountValue);
			com.setCreditAmount(input.getAttribute("value"));
			String ValueminV = ao.CreditInstallmentsMin().getAttribute("data-value");
			min = Integer.parseInt(ValueminV);
			input2 = ao.CreditInstallmentsInput();
			input2.clear();
			input2.sendKeys(Integer.toString(min));
		}
		if (ao.InstallmentsCountIfChecked().isSelected()) {
			com.setInstallmentsCount(input2.getAttribute("value"));
			ao.Submit().click();
			ao.buttonBack().click();
			ao.InstallmentsValue().click();
			com.setInstallmentsValue(input2.getAttribute("value"));
		} else if (ao.InstallmentsValueIfChecked().isSelected()) {
			com.setInstallmentsValue(input2.getAttribute("value"));
			ao.Submit().click();
			ao.buttonBack().click();
			ao.InstallmentsCount().click();
			com.setInstallmentsCount(input2.getAttribute("value"));
		}
		ao.Submit().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			ao.componentMortgageCreditType();
		else
			ao.componentConsumerCreditType();
		String title2 = driver.getCurrentUrl();
		if (title1.equals(title2))
			b = false;
		return b;
	}

	public Pair<Boolean, String> component() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy")) {
			if (!ao.componentPropertyValue().getText().equals((com.getPropertyValue()))) {
				b = false;
				st = "The credit type in component is different than the chosen credit type ";
				p.with(b, st);
			}
			if (!ao.componentMortgageCreditType().getText().toLowerCase().equals(com.getTypeCredit().toLowerCase())) {
				b = false;
				st = "The credit type in component is different than the chosen credit type ";
				p.with(b, st);
			}
		} else {
			if (!ao.componentConsumerCreditType().getText().toLowerCase().equals(com.getTypeCredit().toLowerCase())) {
				b = false;
				st = "The credit type in component is different than the chosen credit type ";
				p.with(b, st);
			}
		}
		if (!com.getCreditAmount().contains(ao.componentCreditAmount().getText())) {
			b = false;
			st = "The credit amount in component is different than the chosen credit amount ";
			p.with(b, st);
		}
		if (com.getInstallmentsCount() != null) {
			if (!ao.componentInstallmentscount().getText().contains(com.getInstallmentsCount())) {
				b = false;
				st = "The installments count in component is different than the chosen installments count";
				p.with(b, st);
			}
		} else if (com.getInstallmentsValue() != null) {
			if (!ao.componentInstallmentValue().getText().contains(com.getInstallmentsValue())) {
				b = false;
				st = "The installment value in component is different than the chosen installment value";
				p.with(b, st);
			}
		} else {
			b = false;
			st = "An installment value and installments count are empty";
			p.with(b, st);
		}
		return p;
	}

	public Pair<Boolean, String> creditTaker(String st) throws InterruptedException {
		boolean b = true;
		String s = "";
		Pair<Boolean, String> p = Pair.with(b, s);

		if (st.equals("creditTakerAlone")) {
			ao.creditTaker1().click();
			if (ao.creditTaker1IfChecked().isSelected()) {
				com.setCreditTaker(ao.creditTaker1().getText());
			} else {
				b = false;
				s = "Credit taker alone is not selected";
				p = Pair.with(b, s);
				return p;
			}
		} else if (st.equals("coCreditTaker")) {
			ao.creditTaker2().click();
			if (ao.creditTaker2IfChecked().isSelected()) {
				com.setCreditTaker(ao.creditTaker2().getText());
				if (!ao.ifcreditTakerTextEnabled()) {
					b = false;
					s = "co-credit-taker values are not presented";
					p = Pair.with(b, s);
					return p;
				}
			} else {
				b = false;
				s = "co-credit-taker is not selected";
				p = Pair.with(b, s);
				return p;
			}

		} else {
			b = false;
			s = "Credit taker is not checked";
			p = Pair.with(b, s);
			return p;
		}
		return p;
	}

	public Pair<Boolean, String> sourceOfIncome() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		Select s = new Select(ao.sourceOfIncome());
		if (com.isCalculationBefore()) {
			if (s.getFirstSelectedOption().equals(s.getOptions().get(0))) {
				b = false;
				st = "There wasn't selected any option of the source of income in the earlier done calculation";
				p = Pair.with(b, st);
				return p;
			}
			s.selectByIndex(1);
			s.selectByIndex(3);
			if (ao.hiddenObligatoryTextSourceOfIncome().getText().isEmpty()) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is incorrectly visible";
				p = Pair.with(b, st);
				return p;
			}
		} else {
			s.selectByIndex(0);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenObligatoryTextSourceOfIncome())) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is not visible";
				p = Pair.with(b, st);
				return p;
			}
			s.selectByIndex(1);
			s.selectByIndex(3);
			if (ao.hiddenObligatoryTextSourceOfIncome().getText().isEmpty()) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is incorrectly visible";
				p = Pair.with(b, st);
				return p;
			}
		}
		com.setSourceOfIncome(s.getFirstSelectedOption().getText());
		return p;
	}

	public Pair<Boolean, String> sourceOfIncome2() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		Select s = new Select(ao.sourceOfIncome2());
		if (com.isCalculationBefore()) {
			if (s.getFirstSelectedOption().equals(s.getOptions().get(0))) {
				b = false;
				st = "There wasn't selected any option of the source of income in the earlier done calculation";
				p = Pair.with(b, st);
				return p;
			}
			s.selectByIndex(2);
			s.selectByIndex(4);
			if (ao.hiddenObligatoryTextSourceOfIncome2().getText().isEmpty()) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is incorrectly visible";
				p = Pair.with(b, st);
				return p;
			}
		} else {
			s.selectByIndex(0);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenObligatoryTextSourceOfIncome2())) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is not visible";
				p = Pair.with(b, st);
				return p;
			}
			s.selectByIndex(2);
			s.selectByIndex(4);
			if (ao.hiddenObligatoryTextSourceOfIncome2().getText().isEmpty()) {
				b = false;
				st = "Hidden text about user has to select one option of the source of income is incorrectly visible";
				p = Pair.with(b, st);
				return p;
			}
		}
		com.setSourceOfIncome2(s.getFirstSelectedOption().getText());
		return p;
	}

	public Pair<Boolean, String> monthIncome() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement monthIncome = ao.monthIncome();
		if (com.isCalculationBefore()) {
			clearInput(monthIncome);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenTextMonthIncome())) {
				b = false;
				st = "The warning about month income is empty is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		} else {
			clearInput(monthIncome);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenTextMonthIncomeNoCalculation())) {
				b = false;
				st = "The warning about month income is empty is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		String min = prop.getProperty("monthIncomeMin");
		int lessMin = Integer.parseInt(min) - 1;
		String lessMinS = Integer.toString(lessMin);
		monthIncome.sendKeys(lessMinS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanMin())) {
			b = false;
			st = "The warning about the value is less than minimum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome);
		int lessInstallmentValue = Integer.parseInt(com.getInstallmentsValue()) - 1;
		String lessInstallmentValueS = Integer.toString(lessInstallmentValue);
		monthIncome.clear();
		monthIncome.sendKeys(lessInstallmentValueS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanInstallValue())) {
			b = false;
			st = "The warning about the value is less than the installment value is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome);
		String max = prop.getProperty("monthIncomeMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		monthIncome.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeMoreThanMax())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome);
		monthIncome.sendKeys(max);
		com.setMonthIncome(monthIncome.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> monthIncome2() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement monthIncome = ao.monthIncome();
		WebElement monthIncome2 = ao.monthIncome2();
		if (com.isCalculationBefore()) {
			clearInput(monthIncome);
			clearInput(monthIncome2);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenTextMonthIncome()) || !ao.isElementPresent(ao.hiddenTextMonthIncome2())) {
				b = false;
				st = "The warning about empty month income is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		} else {
			clearInput(monthIncome);
			clearInput(monthIncome2);
			ao.buttonCount().click();
			if (!ao.isElementPresent(ao.hiddenTextMonthIncomeNoCalculation())
					|| !ao.isElementPresent(ao.hiddenTextMonthIncomeNoCalculatio2())) {
				b = false;
				st = "The warning about empty month income is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		String min = prop.getProperty("monthIncomeMin");
		int lessMin = Integer.parseInt(min) - 1;
		String lessMinS = Integer.toString(lessMin);
		monthIncome.sendKeys(lessMinS);
		monthIncome2.sendKeys(lessMinS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanMin())
				|| !ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanMin2())) {
			b = false;
			st = "The warning about the value is less than minimum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome);
		clearInput(monthIncome2);
		int lessInstallmentValue = Integer.parseInt(com.getInstallmentsValue()) / 2 - 1;
		String lessInstallmentValueS = Integer.toString(lessInstallmentValue);
		// monthIncome2.clear();
		monthIncome.sendKeys(lessInstallmentValueS);
		monthIncome2.sendKeys(lessInstallmentValueS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanInstallValue())
				|| !ao.isElementPresent(ao.hiddenTextMonthIncomeLessThanInstallValue2())) {
			b = false;
			st = "The warning about the value is less than the installment value is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome);
		clearInput(monthIncome2);
		String max = prop.getProperty("monthIncomeMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		monthIncome.sendKeys(overMaxS);
		monthIncome2.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextMonthIncomeMoreThanMax())
				|| !ao.isElementPresent(ao.hiddenTextMonthIncomeMoreThanMax2())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(monthIncome2);
		clearInput(monthIncome);
		monthIncome.sendKeys(max);
		monthIncome2.sendKeys(max);
		com.setMonthIncome(monthIncome.getAttribute("value"));
		com.setMonthIncome2(monthIncome2.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> legalCharges() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement legalCharges = ao.legalCharges();
		legalCharges.sendKeys("1");
		clearInput(legalCharges);
		ao.buttonCount().click();
		if (!ao.isElementPresent(ao.hiddenTexLegalCharges())) {
			b = false;
			st = "The warning about legal charges is empty is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		String minS = prop.getProperty("legalChargesMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			legalCharges.sendKeys(lessMinS);
			if (!ao.isElementPresent(ao.hiddenTextLegalChargesLessThanMin())) {
				b = false;
				st = "The warning about the value is less than minimum is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		clearInput(legalCharges);
		String max = prop.getProperty("legalChargesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		legalCharges.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextLegalChargesMoreThanMax())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(legalCharges);
		legalCharges.sendKeys("0");
		com.setLegalCharges(legalCharges.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> legalCharges2() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement legalCharges = ao.legalCharges();
		WebElement legalCharges2 = ao.legalCharges2();
		legalCharges.sendKeys("1");
		legalCharges2.sendKeys("1");
		clearInput(legalCharges);
		clearInput(legalCharges2);
		ao.buttonCount().click();
		if (!ao.isElementPresent(ao.hiddenTexLegalCharges())) {
			b = false;
			st = "The warning about legal charges is empty is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		String minS = prop.getProperty("legalChargesMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			legalCharges.sendKeys(lessMinS);
			legalCharges2.sendKeys(lessMinS);
			if (!ao.isElementPresent(ao.hiddenTextLegalChargesLessThanMin())
					|| !ao.isElementPresent(ao.hiddenTextLegalChargesLessThanMin2())) {
				b = false;
				st = "The warning about the value is less than minimum is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		clearInput(legalCharges);
		clearInput(legalCharges2);
		String max = prop.getProperty("legalChargesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		legalCharges.sendKeys(overMaxS);
		legalCharges2.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextLegalChargesMoreThanMax())
				|| !ao.isElementPresent(ao.hiddenTextLegalChargesMoreThanMax2())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(legalCharges);
		clearInput(legalCharges2);
		legalCharges.sendKeys("0");
		legalCharges2.sendKeys("0");
		com.setLegalCharges(legalCharges.getAttribute("value"));
		com.setLegalCharges2(legalCharges2.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> payedInstallments() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement payedInstallments = ao.payedInstallments();
		payedInstallments.sendKeys("1");
		clearInput(payedInstallments);
		ao.buttonCount().click();
		if (!ao.isElementPresent(ao.hiddenTexPayedInstallments())) {
			b = false;
			st = "The warning about payed installments is empty is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		String minS = prop.getProperty("paidInstallmentsMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			payedInstallments.sendKeys(lessMinS);
			if (!ao.isElementPresent(ao.hiddenTextPayedInstallmentsLessThanMin())) {
				b = false;
				st = "The warning about the value is less than minimum is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		clearInput(payedInstallments);
		String max = prop.getProperty("paidInstallmentsMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		payedInstallments.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextPayedInstallmentsMoreThanMax())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(payedInstallments);
		payedInstallments.sendKeys("0");
		com.setPayedInstallments2(payedInstallments.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> creditLimits() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement creditLimits = ao.creditLimits();
		creditLimits.sendKeys("1");
		clearInput(creditLimits);
		ao.buttonCount().click();
		if (!ao.isElementPresent(ao.hiddenTextCreditLimits())) {
			b = false;
			st = "The warning about credit limits is empty is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		String minS = prop.getProperty("creditLimitsMin");
		int min = Integer.parseInt(minS);
		int lessMin = 0;
		if (min > 0) {
			lessMin = Integer.parseInt(minS) - 1;
			String lessMinS = Integer.toString(lessMin);
			creditLimits.sendKeys(lessMinS);
			if (!ao.isElementPresent(ao.hiddenTextCreditLimitsLessThanMin())) {
				b = false;
				st = "The warning about the value is less than minimum is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		clearInput(creditLimits);
		String max = prop.getProperty("creditLimitsMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		creditLimits.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextCreditLimitsMoreThanMax())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(creditLimits);
		creditLimits.sendKeys("0");
		com.setCreditLimits2(creditLimits.getAttribute("value"));
		return p;
	}

	public Pair<Boolean, String> dependents() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		Select s = new Select(ao.dependents());
		s.selectByIndex(4);
		int x = Integer.parseInt(s.getFirstSelectedOption().getText());
		s.selectByIndex(2);
		int y = Integer.parseInt(s.getFirstSelectedOption().getText());
		if (x == y) {
			b = false;
			st = "Selected value is not changed";
			 p = Pair.with(b, st);
			 return p;
		}
		s.selectByIndex(0);
		int c = Integer.parseInt(s.getFirstSelectedOption().getText());
		if (x == y) {
			b = false;
			st = "Selected value is not changed";
			 p = Pair.with(b, st);
			 return p;
		}
		com.setDependents(s.getFirstSelectedOption().getText());
		return p;

	}

	public Pair<Boolean, String> houeseholdExpenses() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		WebElement houeseholdExpenses = ao.householdExpenses();
		clearInput(houeseholdExpenses);
		houeseholdExpenses.sendKeys(Keys.DELETE);
		ao.buttonCount().click();
		if (!ao.isElementPresent(ao.hiddenTextHouseholdExpenses())) {
			b = false;
			st = "The warning about household expenses is empty is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		String min = prop.getProperty("householdExpensesMin");
		if (environment.equals("uat") || environment.equals("stt"))
			min = prop.getProperty("householdExpensesMinUat");
		System.out.println(min);
		int minS = Integer.parseInt(min);
		int lessMin = 0;
		if (minS > 0) {
			lessMin = minS - 1;
			String lessMinS = Integer.toString(lessMin);
			clearInput(houeseholdExpenses);
			houeseholdExpenses.sendKeys(lessMinS);
			if (!ao.isElementPresent(ao.hiddenTextHouseholdExpensesLessThanMin())) {
				b = false;
				st = "The warning about the value is less than minimum is not displayed";
				p = Pair.with(b, st);
				return p;
			}
		}
		clearInput(houeseholdExpenses);
		String max = prop.getProperty("householdExpensesMax");
		int overMax = Integer.parseInt(max) + 1;
		String overMaxS = Integer.toString(overMax);
		houeseholdExpenses.sendKeys(overMaxS);
		if (!ao.isElementPresent(ao.hiddenTextHouseholdExpensesMoreThanMax())) {
			b = false;
			st = "The warning about the value is more than maximum is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		clearInput(houeseholdExpenses);
		houeseholdExpenses.sendKeys(min);
		com.setHoueseholdExpenses(houeseholdExpenses.getAttribute("value"));
		return p;

	}

	public Boolean count() throws InterruptedException {
		boolean b = true;
		ao.buttonCount().click();
		System.setProperty("user.timezone", "UTC");
		Date currentDate = new Date();
		com.setStartCountDate(currentDate);
		Thread.sleep(5000);
		if (!ao.isElementPresent(ao.toHomePage()))
			b = false;
		return b;
	}

	//////////////////// summary/////////////////////////////////
	public Pair<Boolean, String> creditCriteriaSummary() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		String str = com.getCreditChance();
		if (!str.contains(ao.chanceText().getText())) {
			b = false;
			st = "Chance text has an unpredicted value";
			p = Pair.with(b, st);
		}
		com.setCreditChance(ao.chanceText().getText());
		String s = ao.summaryCreditType().getText().toLowerCase();
		String t = com.getTypeCredit().toLowerCase();
		if (!s.equals(t)) {
			b = false;
			st = "A credit type in the summary is not equal with the chosen credit type";
			p = Pair.with(b, st);
			return p;
		}
		if (!com.getCreditAmount().contains(ao.summaryCreditAmount().getText())) {
			b = false;
			st = "A credit amount in the summary is not equal with the chosen credit amount";
			p = Pair.with(b, st);
			return p;
		}
		if (com.getInstallmentsCount() != null) {
			if (!ao.summaryInstallmentsCount().getText().contains(com.getInstallmentsCount())) {
				b = false;
				st = "Installments count in the summary is not equal with the chosen installments count";
				p = Pair.with(b, st);
				return p;
			}
			com.setInstallmentsValue(ao.summaryInstallmentsValue().getText());
		} else if (com.getInstallmentsValue() != null) {
			if (!ao.summaryInstallmentsValue().getText().contains(com.getInstallmentsValue())) {
				b = false;
				st = "An installment value in the summary is not equal with the chosen installment value";
				p = Pair.with(b, st);
				return p;
			}
			com.setInstallmentsCount(ao.summaryInstallmentsCount().getText());
		} else {
			b = false;
			st = "An installment value and installments count are empty";
			p = Pair.with(b, st);
			return p;
		}
		return p;
	}

	public Pair<Boolean, String> punctualityPayment() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		ao.punctualityPaymentSeeMore().click();
		if (!ao.isElementPresent(ao.punctualityPaymentSeeLess())) {
			b = false;
			st = "See less link in the punctuality payment container is not displayed";
			p = Pair.with(b, st);
		}
		ao.punctualityPaymentSeeLess().click();
		if (!ao.isElementPresent(ao.punctualityPaymentSeeMore())) {
			b = false;
			st = "See more link in the punctuality payment container is not displayed";
			p = Pair.with(b, st);
		}
		return p;
	}

	public Pair<Boolean, String> scoring() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		ao.scoringSeeMore().click();
		if (!ao.isElementPresent(ao.scoringSeeLess())) {
			b = false;
			st = "See less link in the scoring container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		ao.scoringSeeLess().click();
		if (!ao.isElementPresent(ao.scoringSeeMore())) {
			b = false;
			st = "See more link in the scoring container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		return p;
	}

	public Pair<Boolean, String> budgetCharge() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		ao.budgetChargeSeeMore().click();
		if (!ao.isElementPresent(ao.budgetChargeSeeLess())) {
			b = false;
			st = "See less link in the budget charge container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		ao.budgetChargeSeeLess().click();
		if (!ao.isElementPresent(ao.budgetChargeSeeMore())) {
			b = false;
			st = "See more link in the budget charge container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		return p;
	}

	public Pair<Boolean, String> creditSum() {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		ao.creditSumSeeMore().click();
		if (!ao.isElementPresent(ao.creditSumSeeLess())) {
			b = false;
			st = "See less link in the credit sum container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		ao.creditSumSeeLess().click();
		if (!ao.isElementPresent(ao.creditSumSeeMore())) {
			b = false;
			st = "See more link in the credit sum container is not displayed";
			p = Pair.with(b, st);
			return p;
		}
		return p;
	}

	public Pair<Boolean, String> compareDate() throws Exception {
		boolean b = true;
		String st = "";
		Pair<Boolean, String> p = Pair.with(b, st);
		String s = ao.caclucationDate().getText();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy | HH:mm");
		Date d;
		try {
			d = formatter.parse(s);
			Date currentDate = com.getStartCountDate();
			long diff = currentDate.getTime() - d.getTime();
			long diffS = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
			long maxdif = 120l;
			if (diffS > maxdif) {
				b = false;
				st = "See more link in the credit sum container is not displayed";
				p = Pair.with(b, st);
				return p;
			}
			com.setCalculationTime(String.valueOf(diffS));
			return p;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			b = false;
			st = "See more link in the credit sum container is not displayed";
			p = Pair.with(b, st);
			e.printStackTrace();
			
		}
		return p;
	}

	public Boolean verifyIcon() {
		boolean b = true;
		if (!ao.isElementPresent(ao.iconMarker()))
			b = false;
		return b;
	}

	public Boolean countAnotherCredit() {
		boolean b = true;
		ao.calculateAnotherCredit().click();
		if (!ao.isElementPresent(ao.CreditAmountSlider()))
			b = false;
		driver.navigate().back();
		return b;
	}

	public Boolean homePage() {
		boolean b = true;
		ao.toHomePage().click();
		if (!ao.isElementPresent(ao.creditTypeSubmit()))
			b = false;
		driver.navigate().back();
		return b;
	}

	public void getComponentData() {

		if (com.isCalculationBefore()) {
			Reporter.log("Czy jest zapamiÍtana wczeúniejsza kalkulacja: tak");
		} else
			Reporter.log("Nie ma informacji o poprzedniej kalkulacji");
		Reporter.log("Typ kredytu: " + com.getTypeCredit());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("WartoúÊ nieruchomoúci: " + com.getPropertyValue());
		Reporter.log("Kwota kredytu: " + com.getCreditAmount());
		Reporter.log("Liczba rat: " + com.getInstallmentsCount());
		Reporter.log("WysokoúÊ raty: " + com.getInstallmentsValue());
		Reporter.log("èrÛd≥o dochodu: " + com.getSourceOfIncome());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("Kredyt brany: " + com.getCreditTaker());
		Reporter.log("DochÛd miesiÍczny: " + com.getMonthIncome());
		Reporter.log("Obciπøenia prawne: " + com.getLegalCharges());
		Reporter.log("Sp≥acane raty: " + com.getPayedInstallments());
		Reporter.log("Limity kredytowe: " + com.getCreditLimits());
		Reporter.log("Wydatki gospodarstwa domowego: " + com.getHoueseholdExpenses());
		Reporter.log("Czas obliczenia kalkulacji (w sekundach): " + com.getCalculationTime());
		Reporter.log("Szansa na kredyt: " + com.getCreditChance());
		Reporter.log("Tooltip tekst (kwota kredytu): " + com.getTooltipAmount());
		Reporter.log("Tooltip tekst (jak chcesz sp≥acaÊ kredyt): " + com.getTooltipHowToPay());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("Tooltip tekst (kredyt ze wspÛ≥kredytobiorcπ): " + com.getCreditTakerTooltip());
		Reporter.log("Tooltip tekst (ürÛd≥o dochodu): " + com.getSourceOfIncomeTooltip());
		Reporter.log("Tooltip tekst (dochÛd miesiÍczny): " + com.getMonthIncomeTooltip());
		Reporter.log("Tooltip tekst (obciπøenia prawne): " + com.getLegalChargesTooltip());
		Reporter.log("Tooltip tekst (osoby na utrzymaniu): " + com.getDependentsTooltip());
		Reporter.log("Tooltip tekst (wydatki gospodarstwa domowego): " + com.getHouseholdExpensesTooltip());
		Reporter.log("Tooltip tekst (szanse na kredyt): " + com.getScoreTooltip());
		Reporter.log("Tooltip tekst (terminowoúÊ sp≥at): " + com.getPunctualityPaymentTooltip());
		Reporter.log("Tooltip tekst (ocena punktowa): " + com.getScoringTooltip());
		Reporter.log("Tooltip tekst (obciπøenie wydatkami): " + com.getBudgetChargeTooltip());
		Reporter.log("Tooltip tekst (suma kredytÛw): " + com.getCreditSumTooltip());
	}

	public void getComponentDataWithCotaker() {

		if (com.isCalculationBefore()) {
			Reporter.log("Czy jest zapamiÍtana wczeúniejsza kalkulacja: tak");
		} else
			Reporter.log("Nie ma informacji o poprzedniej kalkulacji");
		Reporter.log("Typ kredytu: " + com.getTypeCredit());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("WartoúÊ nieruchomoúci: " + com.getPropertyValue());
		Reporter.log("Kwota kredytu: " + com.getCreditAmount());
		Reporter.log("Liczba rat: " + com.getInstallmentsCount());
		Reporter.log("WysokoúÊ raty: " + com.getInstallmentsValue());
		Reporter.log("èrÛd≥o dochodu: " + com.getSourceOfIncome());
		Reporter.log("èrÛd≥o dochodu wspÛ≥kredytobiorcy: " + com.getSourceOfIncome2());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("Kredyt brany: " + com.getCreditTaker());
		Reporter.log("DochÛd miesiÍczny: " + com.getMonthIncome());
		Reporter.log("DochÛd miesiÍczny wspÛ≥kredytobiorcy: " + com.getMonthIncome2());
		Reporter.log("Obciπøenia prawne: " + com.getLegalCharges());
		Reporter.log("Obciπøenia prawne wspÛ≥kredytobiorcy: " + com.getLegalCharges2());
		Reporter.log("Sp≥acane raty: " + com.getPayedInstallments());
		Reporter.log("Sp≥acane raty wspÛ≥kredytobiorcy: " + com.getPayedInstallments2());
		Reporter.log("Limity kredytowe: " + com.getCreditLimits());
		Reporter.log("Limity kredytowe wspÛ≥kredytobiorcy: " + com.getCreditLimits2());
		Reporter.log("Wydatki gospodarstwa domowego: " + com.getHoueseholdExpenses());
		Reporter.log("Czas obliczenia kalkulacji (w sekundach): " + com.getCalculationTime());
		Reporter.log("Szansa na kredyt: " + com.getCreditChance());
		Reporter.log("Tooltip tekst (kwota kredytu): " + com.getTooltipAmount());
		Reporter.log("Tooltip tekst (jak chcesz sp≥acaÊ kredyt): " + com.getTooltipHowToPay());
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			Reporter.log("Tooltip tekst (kredyt ze wspÛ≥kredytobiorcπ): " + com.getCreditTakerTooltip());
		Reporter.log("Tooltip tekst (ürÛd≥o dochodu): " + com.getSourceOfIncomeTooltip());
		Reporter.log("Tooltip tekst (dochÛd miesiÍczny): " + com.getMonthIncomeTooltip());
		Reporter.log("Tooltip tekst (obciπøenia prawne): " + com.getLegalChargesTooltip());
		Reporter.log("Tooltip tekst (osoby na utrzymaniu): " + com.getDependentsTooltip());
		Reporter.log("Tooltip tekst (wydatki gospodarstwa domowego): " + com.getHouseholdExpensesTooltip());
		Reporter.log("Tooltip tekst (szanse na kredyt): " + com.getScoreTooltip());
		Reporter.log("Tooltip tekst (terminowoúÊ sp≥at): " + com.getPunctualityPaymentTooltip());
		Reporter.log("Tooltip tekst (ocena punktowa): " + com.getScoringTooltip());
		Reporter.log("Tooltip tekst (obciπøenie wydatkami): " + com.getBudgetChargeTooltip());
		Reporter.log("Tooltip tekst (suma kredytÛw): " + com.getCreditSumTooltip());
	}
}
