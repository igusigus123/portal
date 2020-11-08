package analyzer;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import base.Component;
import pageObjects.SignInObjects;

public class SignIn extends Base {

	private Component com;
	private SignInObjects signIn;
	private String environment;
	WebDriverWait w;

	public SignIn(WebDriver driver) throws IOException {
		this.driver = driver;
		com = new Component(driver);
		signIn = new SignInObjects(driver);
		w = new WebDriverWait(driver, 10);

	}

	public void Zaloguj(String x, String y, String z) throws InterruptedException, IOException {
		environment = com.getEnvironment();
		String email = x;
		String pass = y;
		String pesel = z;

		signIn.CookiesComunnicateClose().click();
		signIn.Email().sendKeys(email);
		signIn.Password().sendKeys(pass);
		signIn.FirstActivePeselNumber();

		if (environment.equals("prod") || environment.equals("stt")) {
			WebElement[] tab = signIn.getActivePeselNumbers();
			char[] peselNumber = Pesel(pesel);
			for (int i = 0; i < 11; i++) {
				if (tab[i] == null) {
					continue;
				} else {
					String peselI = Character.toString(peselNumber[i]);

					tab[i].sendKeys(peselI);
				}
			}
		}
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

	public char[] Pesel(String pesel) {
		char[] peselNumber = new char[11];
		for (int i = 0; i < 11; i++) {
			peselNumber[i] = pesel.charAt(i);
		}
		return peselNumber;
	}

}
