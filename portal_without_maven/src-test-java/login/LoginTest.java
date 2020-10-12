package login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import base.Component;
import pageObjects.SignInObjects;

public class LoginTest extends Base {

	private SignInObjects signIn;
	private Component com;
	private Base base;
	private char[] peselNumber;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void initialize(String param) throws IOException, InterruptedException {
		//Assert.assertTrue(!com.getEnvironment().isEmpty());
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
		signIn = new SignInObjects(driver);
		signIn.CookiesComunnicateClose().click();

	}

	@Test
	public void Login() throws InterruptedException {
		String email = base.email;
		String pass = base.pass;
		String pesel = base.pesel;
		String badMail = "test@test.pl";
		String badPass = "badPass";
		String environment = com.getEnvironment();
		String badPesel = "12345678901";
		
		signIn.Submit().click();
		Assert.assertTrue((signIn.Email().getAttribute("class").contains("invalid validate")),
				"Email is not marked like an invalid validate");

		signIn.Email().sendKeys(badMail);
		signIn.Submit().click();
		
		Assert.assertTrue((signIn.Password().getAttribute("class").contains("validate")),
				"Email is not marked like an invalid validate");
		//System.out.println("1");
		signIn.Password().sendKeys(badPass);
		//System.out.println("2");
		Actions actions = new Actions(driver);
		actions.moveToElement(signIn.blindEye());
		//System.out.println("3");
		actions.clickAndHold().perform();
		//System.out.println("4");
		Assert.assertTrue(signIn.Password().getAttribute("type").equals("text"),
				"Password is not visible after click on a blind eye icon");
		//System.out.println("5");
		signIn.blindEye().click();
		//System.out.println("6");                                                                                                                              
		signIn.Submit().click();
		//System.out.println("7");
		Thread.sleep(5000);
		if(environment.equals("prod") || environment.equals("stt"))
		{
			Assert.assertTrue(signIn.BoxPesel().getAttribute("class").contains("validate"),
					"Pessel numbers are not marked like an invalid validate");
			PeselNumbers(badPesel);
		}
		signIn.Submit().click();
		//System.out.println("10");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		Assert.assertTrue(signIn.isImproperValidText(), "Improper login data text is not visible");
		//second try
		signIn.Email().clear();
		signIn.Email().sendKeys(email);
		signIn.Password().clear();
		signIn.Password().sendKeys(pass);
		Thread.sleep(5000);
		if(environment.equals("prod") || environment.equals("stt"))
			PeselNumbers(pesel);
		signIn.Submit().click();
		if(signIn.isElementPresent())
		{
			signIn.closeAnotherSessionCheckbox().click();
			signIn.Submit().click();
		}
		Reporter.log("User PESEL: "+ pesel);
		driver.close();
		
		
	}
	
	public void PeselNumbers(String pesel) {
		WebElement[] tab = signIn.getActivePeselNumbers();
		peselNumber = Pesel(pesel);
		for (int i = 0; i < 11; i++) {
			if (tab[i] == null) {
				continue;
			} else {
				String peselI = Character.toString(peselNumber[i]);

				tab[i].sendKeys(peselI);
			}
		}
	}
	
	public char[] Pesel(String pesel) {
		peselNumber = new char[11];
		for (int i = 0; i < 11; i++) {
			peselNumber[i] = pesel.charAt(i);
		}
		return peselNumber;
	}
}
