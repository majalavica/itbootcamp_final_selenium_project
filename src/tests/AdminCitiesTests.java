package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
	public void visitTheAdminCitiesPageAndListCities() {

//		admin email: admin@admin.com
//		admin password: 12345	 
//		Klik na sign up dugme iz navigacije
//		Prijaviti se na sistem admin kredencijalima
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		Verifikovati da se u url-u stranice javlja /admin/cities ruta 

		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"ERROR: Url should contain '/admin/cities'");
	}

	@Test(priority = 20)
	public void checkInputTypesForCreateOrEditNewCity() {

//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		Kliknuti na New Item dugme
//		Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//		Verifikovati da polje za unos grada za atribut type ima tekst text

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();

		citiesPage.waitForDialogToBeVisible();

		Assert.assertEquals(citiesPage.getInputFromNewItemDialog().getAttribute("type"), ("text"),
				"ERROR: Input type should be text");
	}

	@Test(priority = 30)
	public void createNewCity() {

//		city: [Ime i prezime polaznika]’s city
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		Kliknuti na New Item dugme
//		Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//		Uneti ime grada u polje
//		Kliknuti na Save dugme
//		Sacekati da popu za prikaz poruke bude vidljiv
//		Verifikovati da poruka sadrzi tekst Saved successfully

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();

		citiesPage.waitForDialogToBeVisible();

		citiesPage.getInputFromNewItemDialog().sendKeys("Mariiaa ");
		citiesPage.getSaveButton().click();

		messagePopUpPage.waitForCitiesDialogToApper();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().contains("Saved successfully"),
				"ERROR: Message should contain 'Saved successfully'");
	}

	@Test(priority = 40)
	public void editCity() {

//		old city name: [Ime i prezime polaznika]’s city
//		new city name: [Ime i prezime polaznika]’s city Edited
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		U polje za pretragu uneti staro ime grada
//		Sacekati da broj redova u tabeli bude 1
//		Kliknuti na dugme Edit iz prvog reda
//		Uneti novo ime za grad
//		Kliknuti na dugme Save
//		Sacekati da popu za prikaz poruke bude vidljiv
//		Verifikovati da poruka sadrzi tekst Saved successfully

		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Mariiaa ");

		citiesPage.waitForRowsNumberToBeVisible(1);
		citiesPage.getEditButtonFromARow(1).click();
		citiesPage.getInputFromNewItemDialog().sendKeys("City Edited");
		citiesPage.getSaveButton().click();

		messagePopUpPage.waitForCitiesDialogToApper();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().contains("Saved successfully"),
				"ERROR: Message should contain 'Saved successfully'");
	}

	@Test(priority = 50)
	public void searchCity() {

//		city name: [Ime i prezime polaznika]’s city Edited
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		U polje za pretragu uneti staro ime grada
//		Sacekati da broj redova u tabeli bude 1
//		Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

		String city = "City Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys(city);
		citiesPage.waitForRowsNumberToBeVisible(1);

		Assert.assertTrue(citiesPage.getACellFromASpecificRow(1, 2).getText().contains(city),
				"ERROR: City name should contain 'City Edited'");
	}

	@Test(priority = 60)
	public void deleteCity() {
//		city name: [Ime i prezime polaznika]’s city Edited
//		Klik na admin dugme iz navigacije
//		Klik na Cities dugme iz padajuceg Admin menija
//		U polje za pretragu uneti staro ime grada
//		Sacekati da broj redova u tabeli bude 1
//		Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//		Kliknuti na dugme Delete iz prvog reda
//		Sacekati da se dijalog za brisanje pojavi
//		Kliknuti na dugme Delete iz dijaloga
//		Sacekati da popu za prikaz poruke bude vidljiv
//		Verifikovati da poruka sadrzi tekst Deleted successfully

		String city = "City Edited";
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys(city);
		citiesPage.waitForRowsNumberToBeVisible(1);

		Assert.assertTrue(citiesPage.getACellFromASpecificRow(1, 2).getText().contains(city),
				"ERROR: City name should contain 'City Edited'");

		citiesPage.getDeleteButtonFromARow(1).click();
		citiesPage.waitForDeleteDialog();
		citiesPage.getDeleteButton().click();

		messagePopUpPage.waitForCitiesDialogToApper();

		Assert.assertTrue(messagePopUpPage.getMessageText().getText().contains("Deleted successfully"),
				"ERROR: Message should contain 'Deleted successfully'");

	}

}
