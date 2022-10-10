package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}

	public void waitForDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	}

	public void waitForDialogDeleteToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-body-1")));
	}

	public void getSaveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnSave")));
	}

	public void getDeleteButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = 'Delete']")));
	}

	public void waitForRowsNumberToBeVisible(int rowNum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNum));
	}

	public WebElement getACellFromASpecificRow(int rowNum, int cellNum) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[" + cellNum + "]"));
	}

	public WebElement getEditButtonFromARow(int rowNum) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNum + "]//button[@id='edit']"));
	}
	
	public WebElement getDeleteButtonFromARow(int rowNum) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNum + "]//div/button[2]"));
	}
	
}
