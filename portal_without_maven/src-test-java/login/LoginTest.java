package login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
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
	private String email;
	private String pass;
	private String pesel;
	private String badMail;
	private String badPass;
	private String environment;
	private String badPesel;
	private WebDriverWait w;
		
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
		signIn = new SignInObjects(driver);
		signIn.CookiesComunnicateClose().click();
		
		email = base.email;
		pass = base.pass;
		pesel = base.pesel;
		badPass = "badPass";
		environment = com.getEnvironment();

	}

	@Test
	public void a_EmptyMail() throws InterruptedException {		
		signIn.Submit().click();
		Assert.assertTrue((signIn.Email().getAttribute("class").contains("invalid validate"))); 
		}
	
	@Test
	public void b_EmptyPass() throws InterruptedException {	

		signIn.Email().sendKeys(email);
		signIn.Submit().click();
		Assert.assertTrue((signIn.Password().getAttribute("class").contains("validate")));
	}
	
	@Test
	public void c_BlindEye() throws InterruptedException {	
		signIn.Password().sendKeys(badPass);
		Actions actions = new Actions(driver);
		actions.moveToElement(signIn.blindEye());
		actions.clickAndHold().perform();
		Assert.assertTrue(signIn.Password().getAttribute("type").equals("text"));
		signIn.blindEye().click();                     
	}
	
	@Test
	public void d_hasPeselActiveNumbers() throws InterruptedException {
		Assert.assertTrue(signIn.FirstActivePeselNumber().isDisplayed());
	}
	
	@Test
	public void e_EmptyPesel() throws InterruptedException {	
		signIn.Submit().click();
		if(environment.equals("prod") || environment.equals("stt"))
		{
			//Pesel numbers becomes red, when values are empty
			Assert.assertTrue(signIn.BoxPesel().getAttribute("class").contains("validate"));
		}
	}
	
	@Test
	public void f_ImproperData() throws InterruptedException {
		if(environment.equals("prod") || environment.equals("stt"))
			PeselNumbers(pesel);
		signIn.Submit().click();             
		Assert.assertTrue(signIn.improperValidText().isDisplayed());
	}
	
	@Test
	public void g_properData() throws InterruptedException {
		signIn.Password().clear();
		signIn.Password().sendKeys(pass);
		if(environment.equals("prod") || environment.equals("stt"))
			PeselNumbers(pesel);
		signIn.Submit().click();
		//check if previous customer session is open
		try {
			signIn.closeAnotherSessionCheckbox();
			signIn.closeAnotherSessionCheckbox().click();
			signIn.Submit().click();
			signIn.ProfileSubmit().click();
		}
		catch(Exception e) {
			signIn.ProfileSubmit().click();
		}
				
	}
	
	@AfterTest
	public void Report() {
		Reporter.log("User PESEL: "+ pesel);
		driver.close();
	}
	
	public void PeselNumbers(String pesel) {
		WebElement[] tab = signIn.getActivePeselNumbers();
		peselNumber = new char[11];
		for (int i = 0; i < 11; i++) {
			peselNumber[i] = pesel.charAt(i);
		}
		for (int i = 0; i < 11; i++) {
			if (tab[i] == null) {
				continue;
			} else {
				String peselI = Character.toString(peselNumber[i]);

				tab[i].sendKeys(peselI);
			}
		}
	}
}
