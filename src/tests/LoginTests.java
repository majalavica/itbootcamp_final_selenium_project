package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

//	Postaviti EN jezik stranice
//	Klik na login dugme iz navigacije
//	Verifikovati da se u url-u stranice javlja ruta /login

	@Test(priority = 10)
	public void visitsTheLoginPage() throws InterruptedException {
		Thread.sleep(1000);
		navPage.getLanguageButton().click();
		navPage.getENLanguageButton().click();
		navPage.getLoginButton().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: /login should be displayed in the URL");

	}

//	Klik na login dugme iz navigacije
//	Verifikovati da polje za unos emaila za atribut type ima vrednost email
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password

	@Test(priority = 20)
	public void checksInputTypes() throws InterruptedException {
		navPage.getLoginButton().click();

		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
				"ERROR: Input type should be email");
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
				"ERROR: Input type should be password");
	}

//	email: non-existing-user@gmal.com
//	password: password123
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Klik na login dugme
//	Sacekati da popu za prikaz greske bude vidljiv
//	Verifikovati da greska sadrzi poruku User does not exists
//	Verifikovati da se u url-u stranice javlja /login ruta 

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginButton().click();

		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();

		messagePopUpPage.waitForPopUpToBeVisible();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().equals("User does not exists"));
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: /login should be displayed in the URL");

	}

//	email: admin@admin.com
//	password: password123
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Klik na login dugme
//	Sacekati da popu za prikaz poruke bude vidljiv
//	Verifikovati da greska sadrzi poruku Wrong password
//	Verifikovati da se u url-u stranice javlja /login ruta 

	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {
		navPage.getLoginButton().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();

		messagePopUpPage.waitForPopUpToBeVisible();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().equals("Wrong password"),
				"ERROR: The message should be Wrong password");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: /login should be displayed in the URL");
	}

//	email: admin@admin.com
//	password: 12345
//	Klik na login dugme iz navigacije
//	Popuniti login formu podacima za logovanje
//	Verifikovati da se u url-u stranice javlja /home ruta 

	@Test(priority = 50)
	public void login() throws InterruptedException {

		navPage.getLoginButton().click();

		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(1000);

		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "ERROR: /home should be displayed in the URL");
	}

//	Verifikovati da je dugme logout vidljivo na stranici
//	Kliknuti na logout dugme

	@Test(priority = 60)
	public void logout() {
		Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "ERROR: Logout button is not displayed");
		navPage.getLogoutButton().click();
	}

}
