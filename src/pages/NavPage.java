package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
