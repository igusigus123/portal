package analyzer.consumer_credit;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import analyzer.AnalyzerPage1Methods;
import analyzer.AnalyzerPage2Methods;
import analyzer.AnalyzerPage3Methods;
import analyzer.SignIn;
import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.AnalyzerPage3Objects;
import pageObjects.SignInObjects;

public class Page3Test extends Base {
	private SignInObjects signIn;
	private Component com;
	private FileInputStream file;
	private SignIn si;
	private AnalyzerPage1Objects apo1;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage3Objects apo3;
	private AnalyzerPage1Methods apm1;
	private AnalyzerPage2Methods apm2;
	private AnalyzerPage3Methods apm3;

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
		apo1 = new AnalyzerPage1Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
		apo3 = new AnalyzerPage3Objects(driver);
	}

	@BeforeTest
	public void ab_PreviousSteps() throws InterruptedException, IOException {

		si.Zaloguj(Base.email, Base.pass, Base.pesel);
		if (apm1.wasCalculationBefore()) {
			apo1.consumerCreditType().click();
			com.setTypeCredit(apo1.consumerCreditType().getText());
			apo1.creditTypeSubmit().click();
			try{
				apo2.creditAmountInput().isDisplayed();
			}
			catch(Exception e) {
				System.out.println("wyj¹tek");
			}
		} else {
			apo1.consumerCreditTypeNoCalculation().click();
			com.setTypeCredit(apo1.consumerCreditTypeNoCalculation().getText());
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
	}

	@Test
	public void a_component() throws InterruptedException {
		Assert.assertTrue(apm3.component());

	}

	@Test
	public void b_backButtonDisplayed() throws InterruptedException {
		Assert.assertTrue(apo3.buttonBack().isDisplayed());

	}

	@Test
	public void c_backButton() {
		Assert.assertTrue(apm3.buttonBack());

	}
	
	@Test
	public void isCreditTakerDisabled() throws InterruptedException {
		Assert.assertFalse(apm3.isCreditTakerDisabled());

	}

	@Test
	public void d_sourceOfIncomeTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.sourceOfIncomeTooltipIsNotEmpty());
	}

	@Test
	public void e_monthIncomeTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.monthIncomeTooltipIsNotEmpty());
	}

	@Test
	public void f_legalChargesTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.legalChargesTooltipIsNotEmpty());
	}

	@Test
	public void g_dependentsTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.dependentsTooltipIsNotEmpty());
	}

	@Test
	public void h_householdExpensesTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.dependentsTooltipIsNotEmpty());
	}

	@Test
	public void i_sourceOfIncomeIsEmpty() {
		Assert.assertTrue(apm3.sourceOfIncomeIsEmpty());
	}

	@Test
	public void j_sourceOfIncomeIsNotEmpty() {
		Assert.assertTrue(apm3.sourceOfIncomeIsNotEmpty());
	}

	@Test
	public void k_monthIncomeIsEmpty() {
		Assert.assertTrue(apm3.monthIncomeIsEmpty());
	}

	@Test
	public void l_monthIncomeLessThanMin() {
		Assert.assertTrue(apm3.monthIncomeLessThanMin());
	}

	@Test
	public void m_monthIncomeLessThanInstallment() {
		Assert.assertTrue(apm3.monthIncomeLessThanInstallment());
	}

	@Test
	public void n_monthIncomeMoreThanMax() {
		Assert.assertTrue(apm3.monthIncomeMoreThanMax());
	}

	@Test
	public void o_legalChargesIsEmpty() {
		Assert.assertTrue(apm3.legalChargesIsEmpty());
	}

	@Test
	public void p_legalChargesLessThanMin() {
		Assert.assertTrue(apm3.legalChargesLessThanMin());
	}

	@Test
	public void r_legalChargesMoreThanMax() {
		Assert.assertTrue(apm3.legalChargesMoreThanMax());
	}

	@Test
	public void s_payedInstallmentsText() {
		Assert.assertTrue(apm3.payedInstallmentsTextDisplayed());
	}

	@Test
	public void t_creditLimitsText() {
		Assert.assertTrue(apm3.CreditLimitsTextDisplayed());
		// com.setCreditLimits(ao.creditLimitsText().getText());
	}

	@Test
	public void u_dependents() {
		Assert.assertTrue(apm3.dependents());
	}

	@Test
	public void w_houeseholdExpensesIsEmpty() {
		Assert.assertTrue(apm3.houeseholdExpensesIsEmpty());
	}

	@Test
	public void y_householdExpensesLessThanMin() {
		Assert.assertTrue(apm3.householdExpensesLessThanMin());
	}

	@Test
	public void z_householdExpensesMoreThanMax() {
		Assert.assertTrue(apm3.householdExpensesMoreThanMax());
	}

	@Test
	public void za_whyAsk() {
		Assert.assertTrue(apm3.whyAsk());
	}

	@Test
	public void zb_count() throws InterruptedException {
		clearInput(apo3.monthIncome());
		apo3.monthIncome().sendKeys(prop.getProperty("monthIncomeMax"));
		com.setMonthIncome(apo3.monthIncome().getAttribute("value"));
		
		Assert.assertTrue(apm3.count());
	}
	
	@AfterTest
	public void CLose() {
		driver.close();
	}

}