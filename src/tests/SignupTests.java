package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

//	Klik na sign up dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja /signup ruta 

	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), "ERROR: /signup should be displayed in URL");
	}

//	Klik na sign up dugme iz navigacije
//	Verifikovati da polje za unos emaila za atribut type ima vrednost email
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email",
				"ERROR: Input type should be email");
		Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), "password",
				"ERROR: Input type should be password");
		Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), "password",
				"ERROR: Input type should be password");
	}

//	name: Another User
//	email: admin@admin.com
//	password: 12345
//	confirm password: 12345
//	Klik na sign up dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja /signup ruta 
//	Popuniti formu za registraciju podacima
//	Klik na sign up dugme
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da greska sadrzi poruku E-mail already exists
//	Verifikovati da se u url-u stranice javlja /signup ruta 

	@Test(priority = 30)
	public void displayErrorsWhenUserAlreadyExists() {

		navPage.getSignUpButton().click();

		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), "ERROR: /signup should be displayed in URL");

		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();

		messagePopUpPage.waitForPopUpToBeVisible();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().equals("E-mail already exists"),
				"ERROR: Message should be E-mail already exists");
	}

//	name: Ime i prezime polaznika
//	email template: ime.prezime@itbootcamp.rs
//	password: 12345
//	confirm password: 12345
//	Klik na sign up dugme iz navigacije
//	Popuniti formu podacima za registraciju
//	Klik na sign up dugme
//	Ucitati stranicu /home
//	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//	Kliknuti na Close dugme iz dijaloga
//	Kliknuti na logout

	@Test(priority = 40)
	public void signUp() throws InterruptedException {
		navPage.getSignUpButton().click();

		Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"), "ERROR: Url should be contains /signup.");

		signupPage.getNameInput().sendKeys("Marija Jovanovic");
		signupPage.getEmailInput().sendKeys("marija.jovanoviec@itbootcamp.rs");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();

		Thread.sleep(2000);

		Assert.assertTrue(messagePopUpPage.getElementWithNewPopUpMessage().getText().equals("IMPORTANT: Verify your account"),
			"ERROR: Wrong message.");

		messagePopUpPage.getCloseButton().click();
		navPage.getLogoutButton().click();
	}
}
