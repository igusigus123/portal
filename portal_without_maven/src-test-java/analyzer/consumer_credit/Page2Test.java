package analyzer.consumer_credit;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import analyzer.AnalyzerPage1Methods;
import analyzer.AnalyzerPage2Methods;
import analyzer.SignIn;
import base.Base;
import base.Component;
import pageObjects.AnalyzerPage1Objects;
import pageObjects.AnalyzerPage2Objects;
import pageObjects.SignInObjects;

public class Page2Test extends Base {
	private SignInObjects signIn;
	private Component com;
	private FileInputStream file;
	private SignIn si;
	private AnalyzerPage1Objects apo1;
	private AnalyzerPage2Objects apo2;
	private AnalyzerPage1Methods apm1;
	private AnalyzerPage2Methods apm2;
	

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
		apo1 = new AnalyzerPage1Objects(driver);
		apo2 = new AnalyzerPage2Objects(driver);
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
	}
	
	@Test
	public void a_AgreementCheckbox() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.AgreeCheckbox());
	}

	@Test
	public void b_correctTypeCreditLink() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.typeCreditLink());
	}

	@Test
	public void c_CreditAmountSlider() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.SliderVerify(apo2.CreditAmountSliderPoint(), apo2.CreditAmountSlider(),
				apo2.creditAmountInput(), apo2.CreditAmountMin(), apo2.CreditAmountMax()));
	}

	@Test
	public void d_CreditAmountEmptyImput() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.EmptyInput(apo2.creditAmountInput(), "Amount"));

	}

	@Test
	public void e_CreditAmountLessThanMin() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.MinValueInputLess(apo2.creditAmountInput(), apo2.CreditAmountMin(), "Amount"));

	}

	@Test
	public void f_CreditAmountMoreThanMax() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.MaxValueInputMore(apo2.creditAmountInput(), apo2.CreditAmountMax(), "Amount"));

	}

	@Test
	public void g_InstalltmentsCountRadio() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.InstalltmentsCountRadio().isSelected());
	}

	@Test
	public void h_InstalltmentsCountSlider() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.SliderVerify(apo2.CreditInstallmentsSliderPoint(), apo2.CreditInstallmentsSlider(),
				apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMin(), apo2.CreditInstallmentsMax()));
	}

	@Test
	public void i_InstalltmentsCountEmptyImput() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.EmptyInput(apo2.CreditInstallmentsInput(), "Installments"));

	}

	@Test
	public void k_InstalltmentsCountLessThanMin() throws InterruptedException, IOException {

		Assert.assertTrue(
				apm2.MinValueInputLess(apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMin(), "Installments"));

	}

	@Test
	public void l_InstalltmentsCountMoreThanMax() throws InterruptedException, IOException {

		Assert.assertTrue(
				apm2.MaxValueInputMore(apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMax(), "Installments"));

	}

	@Test
	public void m_InstalltmentsValueRadio() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.InstalltmentsValueRadio().isSelected());
	}

	@Test
	public void n_InstalltmentsValueSlider() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.SliderVerify(apo2.CreditInstallmentsSliderPoint(), apo2.CreditInstallmentsSlider(),
				apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMin(), apo2.CreditInstallmentsMax()));
	}

	@Test
	public void o_InstalltmentsValueEmptyImput() throws InterruptedException, IOException {

		Assert.assertTrue(apm2.EmptyInput(apo2.CreditInstallmentsInput(), "Installments"));
	}

	@Test
	public void p_InstalltmentsValueLessThanMin() throws InterruptedException, IOException {

		Assert.assertTrue(
				apm2.MinValueInputLess(apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMin(), "Installments"));
	}

	@Test
	public void r_InstalltmentsValueMoreThanMax() throws InterruptedException, IOException {
		Assert.assertTrue(
				apm2.MaxValueInputMore(apo2.CreditInstallmentsInput(), apo2.CreditInstallmentsMax(), "Installments"));
	}

	@Test
	public void s_RelationInstallmentsMLessThanMin() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.RelationInstallmentsMLessThanMin());
	}

	@Test
	public void t_RelationInstallmentsMoreThanMax() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.RelationInstallmentsMoreThanMax());
	}

	@Test
	public void u_RelationInstallmentsTooSmall() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.RelationInstallmentsTooSmall());
	}

	@Test
	public void w_RelationInstallmentsTooLarge() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.RelationInstallmentsTooLarge());
	}

	@Test
	public void y_tooltipAmount() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.tooltipAmountIsNotEmpty());
	}

	@Test
	public void z_tooltipHowToPay() throws InterruptedException, IOException {
		Assert.assertTrue(apm2.tooltipHowToPayIsNotEmpty());
	}
	
	@Test
	public void za_submit() throws InterruptedException {
		Assert.assertTrue(apm2.amountCreditCriteriaSubmit());
	}
	
	@AfterTest
	public void CLose() {
		driver.close();
	}

}
