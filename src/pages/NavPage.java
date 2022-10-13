package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
//	Nav Page
//	Home link
//	About link
//	My profile link
//	Admin dugme
//	Cities link iz padajuceg Admin menija
//	Users link iz padajuceg Admin menija
//	Sign up dugme
//	Login dugme
//	Logout dugme
//	Dugme za izbor jezika
//	EN dugme iz padajuceg menija za izbor jezika
//	ES dugme iz padajuceg menija za izbor jezika
//	FR dugme iz padajuceg menija za izbor jezika
//	CN dugme iz padajuceg menija za izbor jezika

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getHomeLink() {
		return driver.findElement(By.className("btnHome"));
	}

	public WebElement getAboutLink() {
		return driver.findElement(By.className("btnAbout"));
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	public WebElement getCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	public WebElement getUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//a[@href='/signup']"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//a[@href='/login']"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}

	public WebElement getENLanguageButton() {
		return driver.findElement(By.className("btnEN"));
	}

	public WebElement getESLanguageButton() {
		return driver.findElement(By.className("btnES"));
	}

	public WebElement getFRLanguageButton() {
		return driver.findElement(By.className("btnFR"));
	}

	public WebElement getCNLanguageButton() {
		return driver.findElement(By.className("btnCN"));
	}
	
	public WebElement getHeader() {
		return this.driver.findElement(By.xpath("//h1"));
	}
}
