package analyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.javatuples.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.AnalyzerPage3Objects;

public class AnalyzerPage2Methods extends Base {

	private AnalyzerPage1Objects apo1;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage3Objects apo3;
	private AnalyzerPage1Methods apm1;
	private WebDriverWait w;
	private Component com;
	private FileInputStream file;
	private String inputV;
	private WebElement hiddenTextEmpty;
	WebElement text;
	String maxValueAmount;
	String minValueAmount;
	String minValueInstallmentsCount;
	String maxValueInstallmentsCount;
	String minValueInstallmentsValue;
	String maxValueInstallmentsValue;
	WebElement creditAmountInput;
	WebElement creditInstallmentsInput;

	public AnalyzerPage2Methods(WebDriver driver) throws IOException {
		this.driver = driver;
		com = new Component(driver);
		apo1 = new AnalyzerPage1Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
		apo3 = new AnalyzerPage3Objects(driver);
		apm1 = new AnalyzerPage1Methods(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);

	}

	public void StepsPage1(int i) throws InterruptedException, IOException {
		boolean b = apm1.wasCalculationBefore();
		if (i == 1) {
			if (b) {
				apo1.consumerCreditType().click();
				com.setTypeCredit(apo1.consumerCreditType().getText());
				apo1.creditTypeSubmit().click();
			} else {
				apo1.consumerCreditTypeNoCalculation().click();
				apo1.creditTypeSubmitNoCalculation().click();
			}
		} else {
			if (b) {
				apo1.mortgageCreditType().click();
				com.setTypeCredit(apo1.mortgageCreditType().getText());
				apo1.creditTypeSubmit().click();
			} else {
				apo1.mortgageCreditTypeNoCalculation().click();
				com.setTypeCredit(apo1.mortgageCreditTypeNoCalculation().getText());
				apo1.creditTypeSubmitNoCalculation().click();
			}
		}
	}

	public Boolean AgreeCheckbox() throws InterruptedException {
		/*if (com.isCalculationBefore()) {
			if (apo2.analyzerCheckboxDisabled())
				return false;
			else
				return true;

		} else {
			if (apo2.analyzerCheckboxDisabled()) {
				apo2.analyzerCheckbox().click();
				if (!apo2.analyzerCheckboxIfChecked().isSelected()) {
					return false;
				}
				return true;
			} else
				return false;
		}*/
		
		if (com.isCalculationBefore()) {
			try {
				apo2.analyzerCheckbox().isDisplayed();
				return false;
			}
			catch(Exception e) {
				return true;
			}
		} else {
			try {
				apo2.analyzerCheckbox().isDisplayed();
				apo2.analyzerCheckbox().click();
				if (!apo2.analyzerCheckboxIfChecked().isSelected()) {
					return false;
				}
				return true;
			}
			catch(Exception e) {
				return false;
			}
		}
	}

	public boolean typeCreditLink() {
		int i = 0;
		if (com.getTypeCredit().equals("Konsumpcyjny"))
			i = 1;
		else if (com.getTypeCredit().equals("Mieszkaniowy"))
			i = 2;
		try {
			apo2.correctTypeCredit(i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean PropertyInputVisible() {
		return apo2.propertyValueInputDisabled();
	}
	
	public Boolean relationAmountProperty() {
		WebElement text;
		String minProperty = apo2.propertyValueInput().getAttribute("min");
		String maxProperty = apo2.propertyValueInput().getAttribute("max");
		String maxValueAmount = apo2.CreditAmountMax().getAttribute("data-value");
		WebElement creditAmountInput = apo2.creditAmountInput();
		WebElement propertyValueInput = apo2.propertyValueInput();
		propertyValueInput.clear();
		creditAmountInput.clear();
		propertyValueInput.sendKeys(minProperty);
		creditAmountInput.sendKeys(maxValueAmount);
		apo2.Submit().click();
		text = apo2.hiddenRelationCreditPropertyTextAmount();
		if (!text.getText().contains("80%")) {
			return false;
		}
		propertyValueInput.clear();
		creditAmountInput.clear();
		propertyValueInput.sendKeys(maxProperty);
		return true;
	}

	public Boolean SliderVerify(WebElement sliderPoint, WebElement slider, WebElement inputValue, WebElement min,
			WebElement max) throws InterruptedException, IOException {
		if (sliderPoint.isDisplayed()) {
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
				return false;
			}
			sliderPointX = sliderPoint.getLocation().getX();
			int sliderMax = sliderWidth - sliderPointX + slider.getLocation().getX();
			builder.moveToElement(sliderPoint).click().dragAndDropBy(sliderPoint, sliderMax, 0).build().perform();
			input = inputValue.getAttribute("value");
			inputV = CountInputValue(input);
			String maxValue = max.getAttribute("data-value");
			if (!inputV.equals(maxValue)) {
				return false;
			}
			return true;
		} else {
			return false;
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

	public Boolean EmptyInput(WebElement input, String s) throws InterruptedException {
		String title1 = driver.getTitle();
		clearInput(input);
		if (s == "Amount")
			hiddenTextEmpty = apo2.HiddenObligatoryTextAmount();
		else if (s == "Installments")
			hiddenTextEmpty = apo2.HiddenObligatoryTextInstallments();
		else if (s == "Property")
			hiddenTextEmpty = apo2.hiddenObligatoryTextPropertyValue();
		String text = hiddenTextEmpty.getText();
		if (!hiddenTextEmpty.isDisplayed()) {
			return false;
		}
		apo2.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			return false;
		}
		return true;
	}

	public Boolean MinValueInputLess(WebElement input, WebElement minValue, String s) {
		String minV;
		int min;
		String title1 = driver.getTitle();
		if (s == "Property") {
			minV = input.getAttribute("min");
		} else {
			minV = minValue.getAttribute("data-value");
		}
		min = Integer.parseInt(minV) - 1;

		input.clear();
		input.sendKeys(Integer.toString(min));
		String minHiddenText;
		if (s == "Amount") {
			minHiddenText = apo2.HiddenMinTextAmount().getText();
			if (!apo2.HiddenMinTextAmount().isDisplayed()) {
				return false;
			}
		} else if (s == "Installtments") {
			minHiddenText = apo2.hiddenMinTextInstallments().getText();
			if (!apo2.hiddenMinTextInstallments().isDisplayed()) {
				return false;
			}
		} else if (s == "Property") {
			minHiddenText = apo2.hiddenMinTextPropertyValue().getText();
			if (!apo2.hiddenMinTextPropertyValue().isDisplayed()) {
				return false;
			}
		}
		apo2.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			return false;
		}
		return true;

	}

	public Boolean MaxValueInputMore(WebElement input, WebElement maxValue, String s) {
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
		String maxHiddenText;
		if (s == "Amount") {
			maxHiddenText = apo2.hiddenMaxTextAmount().getText();
			if (!apo2.hiddenMaxTextAmount().isDisplayed()) {
				return false;
			}
		} else if (s == "Installtments") {
			maxHiddenText = apo2.hiddenMaxTextInstallments().getText();
			if (!apo2.hiddenMaxTextInstallments().isDisplayed()) {
				return false;
			}
		} else if (s == "Property") {
			maxHiddenText = apo2.hiddenMaxTextPropertyValue().getText();
			if (!apo2.hiddenMaxTextPropertyValue().isDisplayed()) {
				return false;
			}
		}
		apo2.Submit().click();
		String title2 = driver.getTitle();
		if (!title1.equals(title2)) {
			return false;
		}
		return true;
	}

	public WebElement InstalltmentsCountRadio() {
		WebElement installtmentsCount = apo2.InstallmentsCount();
		WebElement installtmentsCountIfChecked = apo2.InstallmentsCountIfChecked();
		installtmentsCount.click();
		return installtmentsCountIfChecked;
	}

	public WebElement InstalltmentsValueRadio() {
		WebElement installtmentsValue = apo2.InstallmentsValue();
		WebElement installtmentsValueIfChecked = apo2.InstallmentsValueIfChecked();
		installtmentsValue.click();
		return installtmentsValueIfChecked;
	}

	public void relationAmountInstallmentsValues() {

		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy".toLowerCase())) {
			String maxProperty = apo2.propertyValueInput().getAttribute("max");
			maxValueAmount = String.valueOf((Integer.parseInt(maxProperty) * 0.8));
		} else {
			maxValueAmount = apo2.CreditAmountMax().getAttribute("data-value");
		}
		minValueAmount = apo2.CreditAmountMin().getAttribute("data-value");

		apo2.InstallmentsCount().click();
		minValueInstallmentsCount = apo2.CreditInstallmentsMin().getAttribute("data-value");
		maxValueInstallmentsCount = apo2.CreditInstallmentsMax().getAttribute("data-value");
		apo2.InstallmentsValue().click();
		minValueInstallmentsValue = apo2.CreditInstallmentsMin().getAttribute("data-value");
		maxValueInstallmentsValue = apo2.CreditInstallmentsMax().getAttribute("data-value");

		creditAmountInput = apo2.creditAmountInput();
		creditInstallmentsInput = apo2.CreditInstallmentsInput();

	}

	public boolean RelationInstallmentsMLessThanMin() {
		relationAmountInstallmentsValues();
		// count of installments more than maximum
		// count of installments less than minimum
		creditAmountInput.clear();
		creditAmountInput.sendKeys(minValueAmount);
		apo2.InstallmentsCount().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(maxValueInstallmentsCount);
		apo2.Submit().click();
		text = apo2.lessThanMinInstallment();
		if (!text.getText().contains("Przy podanej liczbie") & text.getText().contains("minimum")) {
			return false;
		}
		return true;
	}

	public boolean RelationInstallmentsMoreThanMax() {
		relationAmountInstallmentsValues();
		// count of installments more than maximum
		creditAmountInput.clear();
		creditAmountInput.sendKeys(maxValueAmount);
		apo2.InstallmentsCount().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(minValueInstallmentsCount);
		apo2.Submit().click();
		text = apo2.moreThanMaksInstallment();
		if (!(text.getText().contains("Przy podanej liczbie") & text.getText().contains("maksimum"))) {
			return false;
		}
		return true;
	}

	public boolean RelationInstallmentsTooSmall() {
		relationAmountInstallmentsValues();
		// too small installment
		creditAmountInput.clear();
		creditAmountInput.sendKeys(maxValueAmount);
		apo2.InstallmentsValue().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(minValueInstallmentsValue);
		apo2.Submit().click();
		text = apo2.tooSmallInstallment();
		if (!text.getText().contains("Zbyt niska rata")) {
			return false;
		}
		return true;
	}

	public boolean RelationInstallmentsTooLarge() {
		relationAmountInstallmentsValues();
		// too large installment
		creditAmountInput.clear();
		creditAmountInput.sendKeys(minValueAmount);
		apo2.InstallmentsValue().click();
		creditInstallmentsInput.clear();
		creditInstallmentsInput.sendKeys(maxValueInstallmentsValue);
		apo2.Submit().click();
		text = apo2.tooLargeInstallment();
		if (!text.getText().contains("Zbyt wysoka rata")) {
			return false;
		}
		return true;
	}

	public boolean tooltipAmountIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo2.tooltipAmount()).perform();
		if (apo2.tooltipAmountText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean tooltipHowToPayIsNotEmpty() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apo2.tooltipHowToPay()).perform();
		if (apo2.tooltipHowToPayText().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public Boolean amountCreditCriteriaSubmit() {
		boolean b = true;
		WebElement input;
		int min;
		String title1 = driver.getCurrentUrl();
		String amountValue = "";
		WebElement input2 = apo2.CreditInstallmentsInput();
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy")) {
			int propertyValueInt = Integer.parseInt(apo2.propertyValueInput().getAttribute("max")) / 2;
			String propertyValue = String.valueOf(propertyValueInt);
			input = apo2.propertyValueInput();
			input.clear();
			input.sendKeys(propertyValue);
			com.setPropertyValue(input.getAttribute("value"));
			int amountValueInt = propertyValueInt / 2;
			amountValue = String.valueOf(amountValueInt);
			input = apo2.creditAmountInput();
			input.clear();
			input.sendKeys(amountValue);
			com.setCreditAmount(input.getAttribute("value"));
			apo2.InstallmentsCount().click();
			String ValueMaxV = apo2.CreditInstallmentsMax().getAttribute("data-value");
			int max = Integer.parseInt(ValueMaxV);
			input2 = apo2.CreditInstallmentsInput();
			input2.clear();
			input2.sendKeys(Integer.toString(max));
		}
		if (com.getTypeCredit().toLowerCase().equals("konsumpcyjny")) {

			amountValue = String.valueOf(apo2.CreditAmountMin().getAttribute("data-value"));
			input = apo2.creditAmountInput();
			input.clear();
			input.sendKeys(amountValue);
			com.setCreditAmount(input.getAttribute("value"));
			String ValueminV = apo2.CreditInstallmentsMin().getAttribute("data-value");
			min = Integer.parseInt(ValueminV);
			input2 = apo2.CreditInstallmentsInput();
			input2.clear();
			input2.sendKeys(Integer.toString(min));
		}
		if (apo2.InstallmentsCountIfChecked().isSelected()) {
			com.setInstallmentsCount(input2.getAttribute("value"));
			apo2.Submit().click();
			apo3.buttonBack().click();
			apo2.InstallmentsValue().click();
			com.setInstallmentsValue(input2.getAttribute("value"));
		} else if (apo2.InstallmentsValueIfChecked().isSelected()) {
			com.setInstallmentsValue(input2.getAttribute("value"));
			apo2.Submit().click();
			apo3.buttonBack().click();
			apo2.InstallmentsCount().click();
			com.setInstallmentsCount(input2.getAttribute("value"));
		}
		apo2.Submit().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (com.getTypeCredit().toLowerCase().equals("mieszkaniowy"))
			apo3.componentMortgageCreditType();
		else
			apo3.componentConsumerCreditType();
		String title2 = driver.getCurrentUrl();
		if (title1.equals(title2))
			b = false;
		return b;
	}
}
