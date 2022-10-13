package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

//	Ucitati /home stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 10)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	
//	Ucitati /profile stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 20)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	
//	Ucitati /admin/cities stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 30)
	public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	
//	Ucitati /admin/users stranu
//	Verifikovati da se u url-u stranice javlja ruta /login
	
	@Test(priority = 40)
	public void forbidsVisitsToAdminUserseUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	
}
