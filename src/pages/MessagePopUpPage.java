package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//	Message Pop Up Page
//	metodu koja ceka da pop up bude vidljiv
//	Elemente koji u sebi sadrze tekstove poruke
//	Close dugme
//	metodu koja ceka da se verify your account dijalog pojavi
//	metodu koja vraca zaglavlje iz verify your account dijaloga koji sadrzi tekst IMPORTANT: Verify your account
//	Close dugme iz verify account dijaloga

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void waitForPopUpToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
	}

	public WebElement getElementWithNewPopUpMessage() {
		return this.driver.findElement(By.className("dlgVerifyAccount"));
	}

	public WebElement getMessageText() {
		return driver.findElement(By.className("success"));
	}

	public WebElement getCloseButtonFromVerifyPopUp() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--text')]"));
	}

	public void waitDialogToBeVisable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
	}

	public void waitForCitiesDialogToApper() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]//div[@role='status']")));
	}

	public WebElement getVerifyYourAccountText() {
		return this.driver.findElement(By.xpath("//div[contains(@class, 'dlgVerifyAccount')]"));
	}

	public WebElement getCloseButton() {
		return driver.findElement(By.className("btnClose"));
	}

}
