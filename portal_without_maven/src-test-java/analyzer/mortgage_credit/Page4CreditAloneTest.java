package analyzer.mortgage_credit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import analyzer.AnalyzerPage1Methods;
import analyzer.AnalyzerPage2Methods;
import analyzer.AnalyzerPage3Methods;
import analyzer.AnalyzerPage4Methods;
import analyzer.SignIn;
import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.AnalyzerPage3Objects;
import pageObjects.SignInObjects;

public class Page4CreditAloneTest extends Base {
	private SignInObjects signIn;
	private Component com;
	private FileInputStream file;
	private SignIn si;
	private String environment;
	private AnalyzerPage1Objects apo1;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage3Objects apo3;
	private AnalyzerPage1Methods apm1;
	private AnalyzerPage2Methods apm2;
	private AnalyzerPage3Methods apm3;
	private AnalyzerPage4Methods apm4;

	@Parameters({ "environment" })
	@BeforeTest
	public void a_initialize(String param) throws IOException, InterruptedException {
		
		if (param.equals("uat")) {
			com.setEnvironment("uat");
		} else if (param.equals("prod")) {
			com.setEnvironment("prod");
		} else if (param.equals("stt")) {
			com.setEnvironment("stt");
		}
		driver = initializeDriver("Logowanie");
		signIn = new SignInObjects(driver);
		com = new Component(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);
		si = new SignIn(driver);
		apm1 = new AnalyzerPage1Methods(driver);
		apm2 = new AnalyzerPage2Methods(driver);
		apm3 = new AnalyzerPage3Methods(driver);
		apm4 = new AnalyzerPage4Methods(driver);
		apo1 = new AnalyzerPage1Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
		apo3 = new AnalyzerPage3Objects(driver);
	}

	@BeforeTest
	public void ab_PreviousSteps() throws InterruptedException, IOException {
		environment = com.getEnvironment();
		si.Zaloguj(Base.email, Base.pass, Base.pesel);
		if (apm1.wasCalculationBefore()) {
			apo1.mortgageCreditType().click();
			com.setTypeCredit(apo1.mortgageCreditType().getText());
			apo1.creditTypeSubmit().click();
			try{
				apo2.creditAmountInput().isDisplayed();
			}
			catch(Exception e) {
				System.out.println("wyj¹tek");
			}
		} else {
			apo1.mortgageCreditTypeNoCalculation().click();
			com.setTypeCredit(apo1.mortgageCreditTypeNoCalculation().getText());
			apo1.creditTypeSubmitNoCalculation().click();
			try{
				apo2.creditAmountInput().isDisplayed();
			}
			catch(Exception e) {
				System.out.println("wyj¹tek");
			}
		}
		apm2.AgreeCheckbox();
		String s = apo2.CreditAmountMin().getAttribute("data-value");
		int creditAmountInt = Integer.parseInt(s);
		int creditAmountToInt = creditAmountInt * 3;
		String creditAmountToString = String.valueOf(creditAmountToInt);
		clearInput(apo2.creditAmountInput());
		apo2.creditAmountInput().sendKeys(creditAmountToString);
		com.setCreditAmount(creditAmountToString);
		apo2.InstallmentsValue().click();
		int installmentValueInt = creditAmountToInt / 20;
		clearInput(apo2.CreditInstallmentsInput());
		String installmentValueToString = String.valueOf(installmentValueInt);
		apo2.CreditInstallmentsInput().sendKeys(installmentValueToString);
		com.setInstallmentsValue(installmentValueToString);
		apo2.Submit().click();
		try{
			apo3.monthIncome().isDisplayed();
		}
		catch(Exception e) {
			System.out.println("wyj¹tek");
		}
		Select se = new Select(apo3.sourceOfIncome());
		se.selectByIndex(1);
		clearInput(apo3.monthIncome());
		apo3.monthIncome().sendKeys(prop.getProperty("monthIncomeMax"));
		clearInput(apo3.legalCharges());
		apo3.legalCharges().sendKeys(prop.getProperty("legalChargesMin"));
		clearInput(apo3.dependents());
		apo3.dependents().sendKeys(Integer.toString(0));
		String min = prop.getProperty("householdExpensesMin");
		if (environment.equals("uat") || environment.equals("stt"))
			min = prop.getProperty("householdExpensesMinUat");
		clearInput(apo3.householdExpenses());
		apo3.householdExpenses().sendKeys(min);
		apo3.buttonCount().click();
		System.setProperty("user.timezone", "UTC");
		Date currentDate = new Date();
		com.setStartCountDate(currentDate);
	}

	@Test
	public void a_creditCriteriaSummary() {
		Assert.assertTrue(apm4.creditCriteriaSummary());
	}

	@Test
	public void b_punctualityPaymentSeeMore() {
		Assert.assertTrue(apm4.punctualityPaymentSeeMore());
	}

	@Test
	public void c_punctualityPaymentSeeLess() {
		Assert.assertTrue(apm4.punctualityPaymentSeeLess());
	}

	@Test
	public void d_scoringSeeLess() {
		Assert.assertTrue(apm4.scoringSeeLess());
	}

	@Test
	public void e_scoringSeeMore() {
		Assert.assertTrue(apm4.scoringSeeMore());
	}

	@Test
	public void f_budgetChargeSeeLess() {
		Assert.assertTrue(apm4.budgetChargeSeeLess());
	}

	@Test
	public void h_budgetChargeSeeMore() {
		Assert.assertTrue(apm4.budgetChargeSeeMore());
	}

	@Test
	public void i_creditSumSeeLess() {
		Assert.assertTrue(apm4.creditSumSeeLess());
	}

	@Test
	public void j_creditSumSeeMore() {
		Assert.assertTrue(apm4.creditSumSeeMore());
	}

	@Test
	public void k_compareDate() throws Exception {
		Assert.assertTrue(apm4.compareDate());
	}

	@Test
	public void l_verifyIcon() {
		Assert.assertTrue(apm4.verifyIcon());
	}

	@Test
	public void m_countAnotherCreditButton() {
		Assert.assertTrue(apm4.countAnotherCreditButton());
	}

	@Test
	public void n_homePage() {
		Assert.assertTrue(apm4.homePage());
	}
	
	@AfterTest
	public void CLose() {
		driver.close();
	}
}
