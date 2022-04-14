package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import js.jScript;

public class Base {
	WebDriver driver;
	jScript js = new jScript();
	String expectedTitle = "";

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Base() {
	}

	//// METODOS/////
	public void clickElement(WebDriver driver, WebElement elemento) {
		js.highLight(driver, elemento);
		elemento.click();
	}

	public void clickElementFocus(WebDriver driver, WebElement elemento) {
		js.moveyhightlight(driver, elemento);
		elemento.click();
		js.waitForPageToLoad(driver);
	}

	public void sendKey(WebDriver driver, WebElement elemento, String texto) {
		js.highLight(driver, elemento);
		elemento.sendKeys(texto);
	}

	public void cursorTo(WebDriver driver, WebElement elemento) {
		js.highLight(driver, elemento);
		new Actions(driver).moveToElement(elemento).perform();
	}

	public boolean checkElement(WebElement elemento) {
		try {
			if (elemento.isDisplayed()) {
				System.out.println("Elemento: [ " + elemento.getText() + " ] Existe");
			}
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Elemento: [ " + elemento.getText() + " ]X NO Existe");
			return false;
		}
	}

	public void navegar(WebDriver driver, String url) {
		driver.get(url);
		js.waitForPageToLoad(driver);
	}

	public String titulo(WebDriver driver) {
		return driver.getTitle();
	}

	public String getText(WebElement elemento) {
		if (checkElement(elemento))
			return elemento.getText();
		else
			return "";
	}
	public void clearText(WebElement elemento) {
		js.highLight(driver, elemento);
		elemento.clear();
	}
	public void esperarXpath(WebDriver driver, String elemento) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento)));
		
	}
	public void esperarCss(WebDriver driver, String elemento) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elemento)));
		
	}
	public void esperarWeb() {
		js.waitForPageToLoad(driver);
	}
}
