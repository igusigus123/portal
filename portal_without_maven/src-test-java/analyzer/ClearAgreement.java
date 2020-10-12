package analyzer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import base.Component;
import pageObjects.BoObjects;
import pageObjects.SignInObjects;

public class ClearAgreement extends Base {
	private BoObjects bo;
	private Base base;

	@Parameters({ "environment" })
	@BeforeTest
	public void initialize(String param) throws IOException, InterruptedException {

		if (param.equals("uat")) {
			com.setEnvironment("uat");
		} else if (param.equals("prod")) {
			com.setEnvironment("prod");
		} else if (param.equals("stt")) {
			com.setEnvironment("stt");
		}
		driver = initializeDriver("BO");
		bo = new BoObjects(driver);
	}

	@Test
	public void clear() throws Exception {
		bo.customerFileBox().click();
		bo.customerSearch().click();
		WebElement peselBox = bo.peselBox();
		peselBox.sendKeys(base.pesel);
		bo.searchButton().click();
		if (bo.IsPresentCustomerFile()) {
			bo.customerFile().click();
			bo.agreements().click();
			if (bo.IsPresentwithdrawButton()) {
				//System.out.println(bo.withdrawButton().getAttribute("disabled"));
				if (bo.IsDesabledwithdrawButton()) {
					Reporter.log("Zgoda zosta³a ju¿ wczeœniej wycofana");
				} else {
					bo.withdrawButton().click();
					Thread.sleep(2000);
					Reporter.log("Zgoda na analizator zosta³a wycofana");
				}

			} else
				Reporter.log("Zgoda na analizator nie zosta³a udzielona");
		} else
			Reporter.log("Nie wyszukano kartoteki dla pesel: " + base.pesel);
		driver.close();
	}
}
