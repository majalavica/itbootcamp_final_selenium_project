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
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a"));
	}
	
	public WebElement getAboutLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[2]"));
	}
	
	public WebElement getMyProfileLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[3]"));
	}
	
	public WebElement getAdminButton(){
		return driver.findElement(By.className("btnAdmin"));
	}
	
	public WebElement getCitiesLink() {
		return driver.findElement(By.id("list-item-222"));
	}
	
	public WebElement getUsersLink() {
		return driver.findElement(By.id("list-item-225"));
	}
	
	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[4]"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[3]"));
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/button[2]"));
	}
	public WebElement getLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/button[3]"));
	}
	
	public WebElement getENLanguageButton() {
		return driver.findElement(By.id("list-item-281"));
	}
	
	public WebElement getESLanguageButton() {
		return driver.findElement(By.id("list-item-283"));
	}
	
	public WebElement getFRLanguageButton() {
		return driver.findElement(By.id("list-item-285"));
	}
	
	public WebElement getCNLanguageButton() {
		return driver.findElement(By.id("list-item-287"));
	}
}
