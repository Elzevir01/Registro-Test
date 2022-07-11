package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistroWeb extends pageModel.Base{

	// ---DATOS PRINCIPALES---//
	private By txtUsuario = By.xpath("//*[@id='usuario']");
	private By txtNombre = By.xpath("//*[@id='nombre']");
	private By txtPassword = By.xpath("//*[@id='password']");
	private By txtPassword2 = By.xpath("//*[@id='password2']");
	private By txtCorreo = By.xpath("//*[@id='correo']");
	private By txtTelefono = By.xpath("//*[@id='telefono']");
	private By chkTerminos = By.xpath("//*[@id='terminos']");
	private By btnAceptar = By.xpath("//button[text()='Enviar']");
	private By msgError = By.xpath("//*[@id='formulario__mensaje']");

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
		sendKey(txtUsuario, usuario);
	}
	public void sendNombre(String nombre) {
		clearText(txtNombre);
		sendKey(txtNombre, nombre);
	}
	public void sendPassword(String pass) {
		clearText(txtPassword);
		sendKey(txtPassword, pass);
	}
	public void sendPassword2(String pass) {	
		clearText(txtPassword2);
		sendKey(txtPassword2, pass);
	}
	public void sendCorreo(String correo) {	
		clearText(txtCorreo);
		sendKey(txtCorreo, correo);
	}
	public void sendTelefono(String telefono) {	
		clearText(txtTelefono);
		sendKey(txtTelefono, telefono);
	}
	public void clickTermino() {	
		findElemento(chkTerminos).click();
	}
	public void clickAceptar() {
		findElemento(btnAceptar).click();
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
