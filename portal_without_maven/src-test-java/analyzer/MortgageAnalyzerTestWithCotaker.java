package analyzer;

import java.io.FileInputStream;
import java.io.IOException;

import org.javatuples.Pair;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import base.Component;
import pageObjects.AnalizatorObjects;
import pageObjects.SignInObjects;

public class MortgageAnalyzerTestWithCotaker extends Base {
	//private static Logger log = LogManager.getLogger(base.class.getName());
	private AnalizatorObjects ao;
	private SignInObjects signIn;
	private Component com;
	private FileInputStream file;
	private Analyzer an;
	
	@Parameters({"environment"})
	@BeforeTest
	public void initialize(String param) throws IOException, InterruptedException {
		if(param.equals("uat")) {
			com.setEnvironment("uat");
		}
		else if(param.equals("prod")) {
			com.setEnvironment("prod");
		}
		else if(param.equals("stt")) {
			com.setEnvironment("stt");
		}
		driver = initializeDriver("Logowanie");
		ao = new AnalizatorObjects(driver);
		signIn = new SignInObjects(driver);
		com = new Component(driver);
		String path = System.getProperty("user.dir");
		file = new FileInputStream(path + "\\src-main-resources\\analyzer.properties");
		prop.load(file);
		an = new Analyzer(driver);
		//log.info("Driver is initialized");
		
	}
	
	@Test
	public void aa_Zaloguj() throws InterruptedException, IOException {
		
		an.Zaloguj(Base.email, Base.pass, Base.pesel);
		
	}
	
	@Test
	public void aa_wasCalculationBefore() throws InterruptedException, IOException {
		//boolean result = an.wasCalculationBefore();
		//Assert.assertTrue(result, "No information about calculation before");
		Pair<Boolean, String> p = an.lastCalculationDetails();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void ab_TypeCredit() throws InterruptedException, IOException {
		Pair<Boolean, String> p = an.TypeCredit("mortgage");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		
	}
	
	@Test
	public void ba_PropertyValue() throws InterruptedException, IOException {
		Pair<Boolean, String> p;
		p = an.EmptyInput(ao.propertyValueInput(), "Property");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MinValueInputLess(ao.propertyValueInput(), ao.propertyValueInput(), "Property");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MaxValueInputMore(ao.propertyValueInput(), ao.propertyValueInput(), "Property");
		Assert.assertTrue(p.getValue0(), p.getValue1());

	}
	
	@Test
	public void bb_CreditAmount() throws InterruptedException, IOException {
		Pair<Boolean, String> p = an.SliderVerify(ao.CreditAmountSliderPoint(), ao.CreditAmountSlider(), ao.creditAmountInput(),
				ao.CreditAmountMin(), ao.CreditAmountMax());
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p = an.EmptyInput(ao.creditAmountInput(), "Amount");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MinValueInputLess(ao.creditAmountInput(), ao.CreditAmountMin(), "Amount");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MaxValueInputMore(ao.creditAmountInput(), ao.CreditAmountMax(), "Amount");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.relationAmountProperty();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void bba_checkboxSelected() throws InterruptedException {
		if (!com.isCalculationBefore()) {
			Pair<Boolean, String> p = an.checkbox();
			Assert.assertTrue(p.getValue0(), p.getValue1());
		}
	}


	@Test
	public void bc_InstalltmentsCount() throws InterruptedException, IOException {
		WebElement installtmentsCount = ao.InstallmentsCount();
		WebElement installtmentsCountIfChecked = ao.InstallmentsCountIfChecked();
		installtmentsCount.click();
		Assert.assertTrue(installtmentsCountIfChecked.isSelected(), "pierwszy nie jest zaznaczony");
		
		Pair<Boolean, String> p = an.SliderVerify(ao.CreditInstallmentsSliderPoint(), ao.CreditInstallmentsSlider(), ao.CreditInstallmentsInput(),
				ao.CreditInstallmentsMin(), ao.CreditInstallmentsMax());
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p = an.EmptyInput(ao.CreditInstallmentsInput(), "Installments");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MinValueInputLess(ao.CreditInstallmentsInput(), ao.CreditInstallmentsMin(), "Installments");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MaxValueInputMore(ao.CreditInstallmentsInput(), ao.CreditInstallmentsMax(), "Installments");
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void bd_InstalltmentsValue() throws InterruptedException, IOException {
		WebElement installtmentsValue = ao.InstallmentsValue();
		installtmentsValue.click();
		WebElement installtmentsValueIfChecked = ao.InstallmentsValueIfChecked();
		Assert.assertTrue(installtmentsValueIfChecked.isSelected());
		
		Pair<Boolean, String> p = an.SliderVerify(ao.CreditInstallmentsSliderPoint(), ao.CreditInstallmentsSlider(), ao.CreditInstallmentsInput(),
				ao.CreditInstallmentsMin(), ao.CreditInstallmentsMax());
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MinValueInputLess(ao.CreditInstallmentsInput(), ao.CreditInstallmentsMin(), "Installments");
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p=an.MaxValueInputMore(ao.CreditInstallmentsInput(), ao.CreditInstallmentsMax(), "Installments");
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void be_relationAmountInstallments() throws InterruptedException, IOException {
		Pair<Boolean, String> p = an.relationAmountInstallments();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void bf_verifyTooltips() {
		Pair<Boolean, WebElement> p;
		p = an.getTooltipText("propertyValueTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("tooltipAmount");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("tooltipHowToPay");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
	}

	@Test
	public void bg_submit() throws InterruptedException {
		boolean b = an.amountCreditCriteriaSubmit();
		Assert.assertTrue(b, "Submit not direct to a new site");
	}

	@Test
	public void ca_component() throws InterruptedException {
		Pair<Boolean, String> p = an.component();
		Assert.assertTrue(p.getValue0(), p.getValue1());

	}

	@Test
	public void cb_backButton() {
		Assert.assertTrue(ao.buttonBack().isDisplayed(), "Button back is not displayed");
		ao.buttonBack().click();
		Assert.assertTrue(ao.creditAmountInput().isDisplayed(),
				"A page after back button click is different than expected");
		ao.Submit().click();
		Assert.assertTrue(ao.dependents().isDisplayed(), "A page after click on the submit button is different than expected");

	}

	@Test
	public void cb_verifyTooltips() {
		Pair<Boolean, WebElement> p;
		p = an.getTooltipText("sourceOfIncomeTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("monthIncomeTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("legalChargesTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("dependentsTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("householdExpensesTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("creditTakerTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
	}
	
	@Test
	public void cc_creditTaker() throws InterruptedException {
		Pair<Boolean, String> p = an.creditTaker("coCreditTaker");
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void cd_sourceOfIncome() {
		Pair<Boolean, String> p = an.sourceOfIncome();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	@Test
	public void cd_sourceOfIncome2() {
		Pair<Boolean, String> p = an.sourceOfIncome2();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void ce_MonthIncome2() {
		Pair<Boolean, String> p = an.monthIncome2();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void cf_legalCharges2() {
		Pair<Boolean, String> p = an.legalCharges2();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void cf_payedInstallments() {
		Assert.assertTrue(ao.PayedInstallmentsText().isDisplayed(),
				"There is no text about payed installments from the report");
		com.setPayedInstallments(ao.PayedInstallmentsText().getText());
	}

	@Test
	public void cg_creditLimits() {
		Assert.assertTrue(ao.creditLimitsText().isDisplayed(), "There is no text about credit limits from the report");
		com.setCreditLimits(ao.creditLimitsText().getText());
	}
	
	@Test
	public void cg_payedInstallments2() {
		Pair<Boolean, String> p = an.payedInstallments();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void ch_creditLimits2() {
		Pair<Boolean, String> p = an.creditLimits();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void ci_dependents() {
		Pair<Boolean, String> p = an.dependents();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void cj_houeseholdExpenses() {
		Pair<Boolean, String> p = an.houeseholdExpenses();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}

	@Test
	public void ck_whyAsk() {
		ao.linkWhyAsk().click();
		Assert.assertTrue(ao.buttonCloseWhyAsk().isDisplayed(), "There is no popup why ask");
		ao.buttonCloseWhyAsk().click();

	}

	@Test
	public void cl_count() throws InterruptedException {
		boolean b = an.count();
		Assert.assertTrue(b, "There is no direct to summary page");
	}

	@Test
	public void da_summaryVerifyTooltips() throws InterruptedException, IOException {
		
		//Assert.assertTrue(ao.toHomePage().isDisplayed(), "HomePage button is not displayed");
		
		Pair<Boolean, WebElement> p;
		p = an.getTooltipText("scoreTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("punctualityPaymentTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("scoringTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("budgetChargeTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");
		p = an.getTooltipText("creditSumTooltip");
		Assert.assertTrue(p.getValue0(), "Tooltip text is empty");

		com.setCreditChance(an.getTooltipText("scoreTooltip").getValue1().getText());
	}
	
	@Test
	public void db_summaryCreditCriteriaSummary() throws InterruptedException, IOException {
		Pair<Boolean, String> p = an.creditCriteriaSummary();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void dc_summarySeeMoreLess() throws InterruptedException, IOException {
		Pair<Boolean, String> p;
		p = an.punctualityPayment();
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p = an.scoring();
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p = an.budgetCharge();
		Assert.assertTrue(p.getValue0(), p.getValue1());
		p = an.creditSum();
		Assert.assertTrue(p.getValue0(), p.getValue1());
	}
	
	@Test
	public void dd_summaryRemain() throws Exception {
		Pair<Boolean, String> p = an.compareDate();
		Assert.assertTrue(p.getValue0(), p.getValue1());
		boolean b;
		b = an.verifyIcon();
		Assert.assertTrue(b, "Icon marker is not displayed");
		b = an.countAnotherCredit();
		Assert.assertTrue(b, "countAnotherCredit button is not displayed");
		b = an.homePage();
		Assert.assertTrue(b, "homePage button is not displayed");
		an.getComponentDataWithCotaker();
		driver.quit();
	}
}