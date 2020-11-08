package analyzer;

import java.io.FileInputStream;
import java.io.IOException;

import org.javatuples.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage4Objects;
import pageObjects.SignInObjects;

@SuppressWarnings("static-access")
public class AnalyzerPage1Methods extends Base {
	private AnalyzerPage1Objects apo1;
	private AnalyzerPage4Objects apo4;
	private WebDriverWait w;
	private Component com;
	private FileInputStream file;

	public AnalyzerPage1Methods(WebDriver driver) throws IOException {
		this.driver = driver;
		com = new Component(driver);
		apo1 = new AnalyzerPage1Objects(driver);
		apo4 = new AnalyzerPage4Objects(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);

	}

	public boolean wasCalculationBefore() throws InterruptedException, IOException {
		String s = apo1.firstRadioSource().getAttribute("for");
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

	public Boolean lastCalculationDetails() throws InterruptedException, IOException {

		WebElement a = apo1.firstRadioSource();
		boolean b = true;
		if (wasCalculationBefore()) {
			apo1.detailsLastCalculation().click();
			com.setCreditChance(apo4.chanceText().getText());
			com.setCreditAmount(apo4.summaryCreditAmount().getText());
			com.setInstallmentsCount(apo4.summaryInstallmentsCount().getText());
			apo4.toHomePage().click();
			if (apo1.firstRadioSource().isDisplayed()) {
				if (!(apo1.lastAmount().getText().contains(com.getCreditAmount())
						&& apo1.lastChance().getText().contains(com.getCreditChance())
						&& apo1.lastPeriod().getText().contains(com.getInstallmentsCount()))) {
					b = false;
				}
			} else
				b = false;
		}
		return b;
	}

	public Boolean TypeCreditIfWasCalculation(String s) throws InterruptedException, IOException {

		boolean b = true;

		if (s.equals("consumer")) {
			apo1.consumerCreditType().click();
			if (apo1.consumerCreditTypeIfChecked().isSelected()) {
				com.setTypeCredit(apo1.consumerCreditType().getText());
			} else {
				b = false;
				// return b;
			}
		} else if (s.equals("mortgage")) {
			apo1.mortgageCreditType().click();
			if (apo1.consumerMortgageTypeIfChecked().isSelected()) {
				com.setTypeCredit(apo1.mortgageCreditType().getText());
			} else {
				b = false;
				// return b;
			}
		} else {
			b = false;
			// return b;
		}
		return b;

	}

	public Boolean TypeCreditIfNoCalculation(String s) throws InterruptedException, IOException {

		boolean b = true;

		if (s.equals("consumer")) {
			apo1.consumerCreditTypeNoCalculation().click();
			if (apo1.consumerCreditTypeIfCheckedNoCalculation().isSelected()) {
				com.setTypeCredit(apo1.consumerCreditTypeNoCalculation().getText());
				//apo1.creditTypeSubmitNoCalculation().click();
			} else
				b = false;
		} else if (s.equals("mortgage")) {
			apo1.mortgageCreditTypeNoCalculation().click();
			if (apo1.consumerMortgageTypeIfCheckedNoCalculation().isSelected()) {
				com.setTypeCredit(apo1.mortgageCreditTypeNoCalculation().getText());
			//	apo1.creditTypeSubmitNoCalculation().click();
			} else {
				b = false;
			}
		} else {
			b = false;
		}
		return b;

	}

	public Boolean FollowButton() throws InterruptedException, IOException {
		Boolean b = true;

		if (wasCalculationBefore()) {
			if (!apo1.creditTypeSubmit().isDisplayed())
				b = false;
			apo1.creditTypeSubmit().click();
			if (!driver.getTitle().contains("Analizator"))
				b = false;
		} else {
			if (!apo1.creditTypeSubmitNoCalculation().isDisplayed())
				b = false;
			apo1.creditTypeSubmitNoCalculation().click();
			if (!driver.getTitle().contains("Analizator"))
				b = false;
		}
		return true;
	}

}
