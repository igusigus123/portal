package analyzer.mortgage_credit;

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

public class Page3CreditCotakerTest extends Base{
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
	public void d_isCreditTakerDisabled() throws InterruptedException {
		Assert.assertTrue(apm3.isCreditTakerDisabled());

	}
	
	@Test
	public void e_sourceOfIncomeTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.sourceOfIncomeTooltipIsNotEmpty());
	}

	@Test
	public void f_creditTakerTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.creditTakerTooltipIsNotEmpty());
	}
	
	@Test
	public void g_monthIncomeTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.monthIncomeTooltipIsNotEmpty());
	}

	@Test
	public void h_legalChargesTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.legalChargesTooltipIsNotEmpty());
	}

	@Test
	public void i_dependentsTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.dependentsTooltipIsNotEmpty());
	}

	@Test
	public void j_householdExpensesTooltip() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.dependentsTooltipIsNotEmpty());
	}
	
	@Test
	public void k_CreditTakerCotaker() throws InterruptedException, IOException {
		Assert.assertTrue(apm3.creditTakerCotaker());
	}

	@Test
	public void l_sourceOfIncomeIsEmpty() {
		Assert.assertTrue(apm3.sourceOfIncomeIsEmpty());
	}

	@Test
	public void m_sourceOfIncomeIsNotEmpty() {
		Assert.assertTrue(apm3.sourceOfIncomeIsNotEmpty());
	}
	
	@Test
	public void n_sourceOfIncome2IsEmpty() {
		Assert.assertTrue(apm3.sourceOfIncome2IsEmpty());
	}

	@Test
	public void o_sourceOfIncome2IsNotEmpty() {
		Assert.assertTrue(apm3.sourceOfIncomeIs2NotEmpty());
	}
	
	@Test
	public void p_monthIncomeIsEmpty() {
		Assert.assertTrue(apm3.monthIncomeIsEmpty());
	}

	@Test
	public void r_monthIncomeLessThanMin() {
		Assert.assertTrue(apm3.monthIncomeLessThanMin());
	}

	@Test
	public void s_monthIncomeLessThanInstallment() {
		Assert.assertTrue(apm3.monthIncomeLessThanInstallment());
	}

	@Test
	public void t_monthIncomeMoreThanMax() {
		Assert.assertTrue(apm3.monthIncomeMoreThanMax());
	}
	
	@Test
	public void u_monthIncome2IsEmpty() {
		Assert.assertTrue(apm3.monthIncome2IsEmpty());
	}

	@Test
	public void w_monthIncome2LessThanMin() {
		Assert.assertTrue(apm3.monthIncome2LessThanMin());
	}

	@Test
	public void y_monthIncome2LessThanInstallment() {
		Assert.assertTrue(apm3.monthIncome2LessThanInstallment());
	}

	@Test
	public void z_monthIncome2MoreThanMax() {
		Assert.assertTrue(apm3.monthIncome2MoreThanMax());
	}

	@Test
	public void za_legalChargesIsEmpty() {
		Assert.assertTrue(apm3.legalChargesIsEmpty());
	}

	@Test
	public void zb_legalChargesLessThanMin() {
		Assert.assertTrue(apm3.legalChargesLessThanMin());
	}

	@Test
	public void zc_legalChargesMoreThanMax() {
		Assert.assertTrue(apm3.legalChargesMoreThanMax());
	}
	
	@Test
	public void zd_legalCharges2IsEmpty() {
		Assert.assertTrue(apm3.legalCharges2IsEmpty());
	}

	@Test
	public void ze_legalCharges2LessThanMin() {
		Assert.assertTrue(apm3.legalCharges2LessThanMin());
	}

	@Test
	public void zf_legalCharges2MoreThanMax() {
		Assert.assertTrue(apm3.legalCharges2MoreThanMax());
	}

	@Test
	public void zg_payedInstallmentsText() {
		Assert.assertTrue(apm3.payedInstallmentsTextDisplayed());
	}
	
	@Test
	public void zh_payedInstallmentsIsEmpty() {
		Assert.assertTrue(apm3.payedInstallmentsIsEmpty());
	}
	
	@Test
	public void zi_payedInstallmentsLessThanMin() {
		Assert.assertTrue(apm3.payedInstallmentsLessThanMin());
	}
	
	@Test
	public void zj_payedInstallmentsMoreThanMax() {
		Assert.assertTrue(apm3.payedInstallmentsMoreThanMax());
	}
	
	@Test
	public void zk_creditLimitsText() {
		Assert.assertTrue(apm3.CreditLimitsTextDisplayed());
	}
	
	@Test
	public void zl_creditLimitsIsEmpty() {
		Assert.assertTrue(apm3.CreditLimitsIsEmpty());
	}
	
	@Test
	public void zm_creditLimitsLessThanMin() {
		Assert.assertTrue(apm3.CreditLimitsLessThanMin());
	}
	
	@Test
	public void zn_creditLimitsMoreThanMax() {
		Assert.assertTrue(apm3.CreditLimitsMoreThanMax());
	}

	@Test
	public void zo_dependents() {
		Assert.assertTrue(apm3.dependents());
	}

	@Test
	public void zp_houeseholdExpensesIsEmpty() {
		Assert.assertTrue(apm3.houeseholdExpensesIsEmpty());
	}

	@Test
	public void zr_householdExpensesLessThanMin() {
		Assert.assertTrue(apm3.householdExpensesLessThanMin());
	}

	@Test
	public void zs_householdExpensesMoreThanMax() {
		Assert.assertTrue(apm3.householdExpensesMoreThanMax());
	}

	@Test
	public void zt_whyAsk() {
		Assert.assertTrue(apm3.whyAsk());
	}

	@Test
	public void zu_count() throws InterruptedException {
		clearInput(apo3.monthIncome());
		clearInput(apo3.monthIncome2());
		apo3.monthIncome().sendKeys(prop.getProperty("monthIncomeMax"));
		apo3.monthIncome2().sendKeys(prop.getProperty("monthIncomeMax"));
		com.setMonthIncome(apo3.monthIncome().getAttribute("value"));
		com.setMonthIncome2(apo3.monthIncome2().getAttribute("value"));
		
		Assert.assertTrue(apm3.count());
	}
	
	@AfterTest
	public void CLose() {
		driver.close();
	}
	
}
