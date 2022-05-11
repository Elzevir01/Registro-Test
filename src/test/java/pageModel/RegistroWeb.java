package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import js.jScript;

public class RegistroWeb extends pageModel.Base{
	// WebDriver driver;
	jScript js = new jScript();

	// ---DATOS PRINCIPALES---//
	@FindBy(xpath = "//*[@id='usuario']")
	WebElement txtUsuario;
	@FindBy(xpath = "//*[@id='nombre']")
	WebElement txtNombre;
	@FindBy(xpath = "//*[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath = "//*[@id='password2']")
	WebElement txtPassword2;
	@FindBy(xpath = "//*[@id='correo']")
	WebElement txtCorreo;
	@FindBy(xpath = "//*[@id='telefono']")
	WebElement txtTelefono;
	@FindBy(xpath = "//*[@id='terminos']")
	WebElement chkTerminos;
	@FindBy(xpath = "//button[text()='Enviar']")
	WebElement btnAceptar;
	@FindBy(xpath = "//*[@id='formulario__mensaje']")
	WebElement msgError;

	/////CONSTRUCTOR/////
	public RegistroWeb(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	public RegistroWeb() {
		}

	////METODOS/////
	public void sendUsuario(String usuario) {
		clearText(txtUsuario);
		sendKey(driver, txtUsuario, usuario);
	}
	public void sendNombre(String nombre) {
		clearText(txtNombre);
		sendKey(driver, txtNombre, nombre);
	}
	public void sendPassword(String pass) {
		clearText(txtPassword);
		sendKey(driver, txtPassword, pass);
	}
	public void sendPassword2(String pass) {	
		clearText(txtPassword2);
		sendKey(driver, txtPassword2, pass);
	}
	public void sendCorreo(String correo) {	
		clearText(txtCorreo);
		sendKey(driver, txtCorreo, correo);
	}
	public void sendTelefono(String telefono) {	
		clearText(txtTelefono);
		sendKey(driver, txtTelefono, telefono);
	}
	public void clickTermino() {	
		clickElement(driver, chkTerminos);
	}
	public void clickAceptar() {
		clickElement(driver, btnAceptar);
	}
	public void error() {
		checkElement(msgError);
	}
	///---extras---///
	public void usuarioNombre(String usuario, String nombre) {	
		sendUsuario(usuario);
		sendNombre(nombre);
	}
	public void password1y2(String pass1, String pass2) {	
		sendPassword(pass1);
		sendPassword2(pass2);
	}
	public void correoytelefono(String correo, String telefono) {
		sendCorreo(correo);
		sendTelefono(telefono);
	}
	public void checkyAceptar() {
		clickTermino();
		clickAceptar();
	}
	public void checkError(){
		checkElement(msgError);
	}
	public int ranDomInt(int max, int min){
	    System.out.println("Random value in int from "+min+" to "+max+ ":");
	                int random_int = (int)(Math.random() * (max - min + 1) + min);
	                System.out.println(random_int);
	                return random_int;
  }
}
