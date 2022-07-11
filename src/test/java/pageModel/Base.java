package pageModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriver driver;
	String expectedTitle = "";

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Base() {
	}

	//// METODOS/////
	public WebElement findElemento(By elemento) {
		return driver.findElement(elemento);
	}

	public void clickElemento(By elemento) {
		findElemento(elemento).click();
	}

	public void sendKey(By elemento, String texto) {
		findElemento(elemento).sendKeys(texto);
	}

	public void clearText(By elemento) {
		findElemento(elemento).clear();
	}

	public void cursorTo(By elemento) {
		new Actions(driver).moveToElement(findElemento(elemento)).perform();
	}

	public void navegar(String url) {
		driver.get(url);
	}

	public String titulo(WebDriver driver) {
		return driver.getTitle();
	}

	public void clearText(WebElement elemento) {
		elemento.clear();
	}

	public void esperarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}

	public void esperarWeb() {
	}

	public void confirmarTitulo(String titulo) {
		ExpectedConditions.titleIs(titulo);
	}

	public boolean checkElement(By elemento) {
		try {
			if (findElemento(elemento).isDisplayed()) {
				System.out.println("Element exist");
			}
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element NO exist");
			return false;
		}
	}
}
