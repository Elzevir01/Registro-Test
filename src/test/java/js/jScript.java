package js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jScript {
	
	private JavascriptExecutor js;
	String pageLoadStatus = "";
	
	/////ELEMENTO SELECCIONADO EN ROJO/////
	public boolean highLight(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		for (int iC = 0; iC < 1; iC++) {
			try {
				js.executeScript("arguments[0].setAttribute('style', 'background:red')", element);
				Thread.sleep(100);
				js.executeScript("arguments[0].setAttribute('style', 'background:')", element);
				Thread.sleep(100);
			} catch (Exception e) {
				System.err.println("JavaScript | Method: hightlight | Exception desc: " + e.getMessage());
			}

		}
		return true;
	}
	/////ESPERAR CARGA DE PAGINA/////
	public boolean waitForPageToLoad(WebDriver driver) {
		try {
			do {
				js = (JavascriptExecutor) driver;
				pageLoadStatus = (String) js.executeScript("return document.readyState");
			} while (!pageLoadStatus.equals("complete"));

		} catch (Exception e) {
			System.err.println("JavaScript | Method: waitForPageToLoad | Exception desc: " + e.getMessage());
		}
		return true;

	}
	/////SCROLL HACIA EL ELEMENTO/////
	public void moveToElement( WebDriver driver, WebElement elemento) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
	}
	//////////COMBINADO///////////
	public void moveyhightlight(WebDriver driver, WebElement elemento){
		moveToElement(driver, elemento);
		highLight(driver, elemento);
	}
}
