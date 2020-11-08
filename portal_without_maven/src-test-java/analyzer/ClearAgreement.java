package analyzer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	public void a_IsCustomerExist() {
		bo.customerFileBox().click();
		bo.customerSearch().click();
		WebElement peselBox = bo.peselBox();
		peselBox.sendKeys(base.pesel);
		bo.searchButton().click();
		Assert.assertTrue(bo.customerFile().isDisplayed(), "Nie wyszukano kartoteki dla pesel: " + base.pesel);
	}
	
	@Test
	public void b_Clear() throws Exception {
		bo.customerFile().click();
		bo.agreements().click();
		if(NoAgreement()) {
			if(ButtonClickable())
			{
				bo.withdrawButton().click();
				Assert.assertTrue(bo.WithdrawButtonNoClickable().isDisplayed());
			}
		}
		
		
	}
	
	public boolean NoAgreement() {
		try {
			bo.withdrawButton().isDisplayed();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean ButtonClickable() {
		try {
			bo.WithdrawButtonNoClickable().isDisplayed();
			return false;
		}
		catch(Exception e) {
			return true;
		}
	}
}

