package analyzer.mortgage_credit;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import analyzer.AnalyzerPage1Methods;
import analyzer.SignIn;
import base.Base;
import base.Component;
import pageObjects.SignInObjects;

public class Page1Test extends Base {
	private SignInObjects signIn;
	private Component com;
	private FileInputStream file;
	private SignIn si;
	private AnalyzerPage1Methods apm1;
	// private AnalyzerPage4Objects apo4;
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
	}

	@BeforeTest
	public void ab_PreviousSteps() throws InterruptedException, IOException {
		si.Zaloguj(Base.email, Base.pass, Base.pesel);
	}

	@Test
	public void b_LastCalculationDetails() throws InterruptedException, IOException {
		Assert.assertTrue(apm1.lastCalculationDetails());
	}

	@Test
	public void c_TypeCredit() throws InterruptedException, IOException {
		String s = "mortgage";
		if (com.isCalculationBefore())
			Assert.assertTrue(apm1.TypeCreditIfWasCalculation(s));
		else
			Assert.assertTrue(apm1.TypeCreditIfNoCalculation(s));
	}

	@Test
	public void d_FollowButton() throws InterruptedException, IOException {

		Assert.assertTrue(apm1.FollowButton());
	}

	@AfterTest
	public void CLose() {
		driver.close();
	}

}
