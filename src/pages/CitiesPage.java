package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Cities Page
//dugme New Item
//input za pretragu
//metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//metodu koja ceka da se dijalog za brisanje pojavi
//save dugme iz dijalog za editovanje i kreiranje
//delete dugme iz dijaloga za brisanje
//metodu koja ceka da se u tabeli pojavi odredjeni broj redova. Metoda kao parametar prima broj redova. Ako se metoda pozove sa parametrom 5,
//to znaci da metoda ceka da se u tabeli pojavi 5 redova.
//metodu koja vraca celiju iz odredjenog reda. Metoda kao parametre prima red i kolonu a vraca td iz tabele. Npr: ukoliko se metoda pozove 
//row=2, cell=3 tada metoda vraca trecu celiju iz 2 reda.
//metodu koja vraca edit dugme trazenog reda. Metoda kao parametar prima red a vraca dugme. Npr ako se metoda pozove row=3, metoda vraca 
//edit dugme iz treceg reda tabele
//metodu koja vraca delete dugme trazenog reda. Metoda kao parametar prima red a vraca dugme. Npr ako se metoda pozove row=3, metoda vraca 
//delete dugme iz treceg reda tabele

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
