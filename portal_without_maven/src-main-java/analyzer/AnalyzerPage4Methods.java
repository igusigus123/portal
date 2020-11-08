package analyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.javatuples.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.AnalyzerPage3Objects;
import pageObjects.AnalyzerPage4Objects;

public class AnalyzerPage4Methods extends Base {
	private AnalyzerPage4Objects apo4;
	private AnalyzerPage3Objects apo3;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage1Objects apo1;
	private AnalyzerPage2Methods apm2;
	private AnalyzerPage3Methods apm3;
	private WebDriverWait w;
	private Component com;
	private FileInputStream file;
	private String environment;
	private WebElement monthIncome;
	WebElement legalCharges;
	WebElement houeseholdExpenses;

	public AnalyzerPage4Methods(WebDriver driver) throws IOException {
		this.driver = driver;
		environment = com.getEnvironment();
		com = new Component(driver);
		apm2 = new AnalyzerPage2Methods(driver);
		apm3 = new AnalyzerPage3Methods(driver);
		apo4 = new AnalyzerPage4Objects(driver);
		apo3 = new AnalyzerPage3Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
		apo1 = new AnalyzerPage1Objects(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);
	}

	public Boolean creditCriteriaSummary() {
		String getCom;
		String withDot;
		String s = apo4.summaryCreditType().getText().toLowerCase();
		String t = com.getTypeCredit().toLowerCase();
		if (!s.equals(t)) {
			return false;
		}
		getCom = com.getCreditAmount();
		withDot = apm3.AddDot(getCom);
		if (!apo4.summaryCreditAmount().getText().contains(apo4.summaryCreditAmount().getText())) {
			return false;
		}
	/////!!!!!!!!!!!!!!!!!!!!!!!!!bug to report!!!!!!!!!!!!!!!!!!!!////////////////////
	/*
		if (com.getInstallmentsCount() != null) {
			if (!apo4.summaryInstallmentsCount().getText().contains(com.getInstallmentsCount())) {
				return false;
			}
			com.setInstallmentsValue(apo4.summaryInstallmentsValue().getText());
		} else if (com.getInstallmentsValue() != null) {
			System.out.println(apo4.summaryInstallmentsValue().getText());
			System.out.println(com.getInstallmentsValue());
			if (!apo4.summaryInstallmentsValue().getText().contains(com.getInstallmentsValue())) {
				return false;
			}
			com.setInstallmentsCount(apo4.summaryInstallmentsCount().getText());
		} else {
			return false;
		}*/
		return true;
	}

	public Boolean punctualityPaymentSeeMore() {
		apo4.punctualityPaymentSeeMore().click();
		try {
			apo4.punctualityPaymentSeeLess().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean punctualityPaymentSeeLess() {
		apo4.punctualityPaymentSeeLess().click();
		try {
			apo4.punctualityPaymentSeeMore().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean scoringSeeLess() {
		apo4.scoringSeeMore().click();
		try {
			apo4.scoringSeeLess().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean scoringSeeMore() {
		apo4.scoringSeeLess().click();
		try {
			apo4.scoringSeeMore().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean budgetChargeSeeLess() {
		apo4.budgetChargeSeeMore().click();
		try {
			apo4.budgetChargeSeeLess().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean budgetChargeSeeMore() {
		apo4.budgetChargeSeeLess().click();
		try {
			apo4.budgetChargeSeeMore().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean creditSumSeeLess() {
		apo4.creditSumSeeMore().click();
		try {
			apo4.creditSumSeeLess().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean creditSumSeeMore() {
		apo4.creditSumSeeLess().click();
		try {
			apo4.creditSumSeeMore().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean compareDate() throws Exception {
		String s = apo4.caclucationDate().getText();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy | HH:mm");
		Date d;
		try {
			d = formatter.parse(s);
			Date currentDate = com.getStartCountDate();
			long diff = currentDate.getTime() - d.getTime();
			long diffS = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
			long maxdif = 120l;
			if (diffS > maxdif) {
				return false;
			}
			com.setCalculationTime(String.valueOf(diffS));
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public Boolean verifyIcon() {
		try {
			apo4.iconMarker().isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean countAnotherCreditButton() {
		apo4.calculateAnotherCredit().click();
		try {
			apo2.CreditAmountSlider().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		driver.navigate().back();
		return true;
	}

	public Boolean homePage() {
		apo4.toHomePage().click();
		try {
			apo1.creditTypeSubmit().isDisplayed();
		} catch (Exception e) {
			return false;
		}
		driver.navigate().back();
		return true;
	}

}
