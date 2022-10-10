package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void waitForPopUpToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'v-snack__content')]")));
	}
	
	public WebElement getMessageText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(By.className("success"));
		}
	
	public WebElement getCloseButtonFromVerifyPopUp() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--text')]"));
	}
	
	public void waitForVerifyYourAccountDialogToBeVisable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'v-dialog--persistent')]")));
	}
	
	public void waitForVerifyYourAccountText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}
	
	public WebElement getCloseButton() {
		return driver.findElement(By.className("btnClose"));
	}
	
}
