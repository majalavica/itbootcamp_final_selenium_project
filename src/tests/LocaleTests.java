package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
	@Test(priority = 10)
	public void setLocaleToES() {

//		Postaviti jezik na ES
//		Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

		navPage.getLanguageButton().click();
		navPage.getESLanguageButton().click();

		Assert.assertTrue(navPage.getHeader().getText().equals("Página de aterrizaje"),
				"ERROR: Header should contain 'Página de aterrizaje'");
	}

	@Test(priority = 20)
	public void setLocaleToEN() {

//		Postaviti jezik na EN
//		Verifikovati da se na stranici u hederu javlja tekst Landing

		navPage.getLanguageButton().click();
		navPage.getENLanguageButton().click();

		Assert.assertTrue(navPage.getHeader().getText().equals("Landing"), "ERROR: Header should contain 'Landing'");
	}

	@Test(priority = 30)
	public void setLocaleToCN() {

//		Postaviti jezik na CN
//		Verifikovati da se na stranici u hederu javlja tekst 首页

		navPage.getLanguageButton().click();
		navPage.getCNLanguageButton().click();

		Assert.assertTrue(navPage.getHeader().getText().equals("首页"), "ERROR: Header should contain '首页'");
	}

	@Test(priority = 40)
	public void setLocaleToFR() {

//		Postaviti jezik na FR
//		Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage

		navPage.getLanguageButton().click();
		navPage.getFRLanguageButton().click();

		Assert.assertTrue(navPage.getHeader().getText().equals("Page d'atterrissage"),
				"ERROR: Header should contain 'Page d'atterrissage'");
	}
}
