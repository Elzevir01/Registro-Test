package com.registro;

import org.testng.annotations.Test;

import driver.BrowserFactory;
import driver.DriverFactory;
import basededatos.BDClass;
import pageModel.RegistroWeb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class RegistroTest {

	BDClass DB;
	WebDriver driver;
	DriverFactory df = null;
	BrowserFactory bf = null;
	RegistroWeb rw = null;
	String titulo= "DC: Road to Win";

	@Test(dataProvider = "DP")
	public void f(String ID, String Nombre, String Apellido, String Descripcion, String Email, String Direccion,
			String Telefono, String Edad, String Pin, String Compania){
		rw = new RegistroWeb(driver);
		rw.navegar("http://dcmassstream.myartsonline.com/RegistroAv.html");
		rw.usuarioNombre(Apellido+ID, Nombre);
		rw.password1y2(Nombre+ID, Nombre+ID);
		rw.correoytelefono(Email, Telefono);
		rw.checkyAceptar();
		rw.checkError();
		rw.esperarWeb();
		rw.confirmarTitulo(titulo);
	}

	@DataProvider
	public Object[][] DP() throws ClassNotFoundException, SQLException {
		String data[][] = BDClass.datos();
		return data;
	}

	@BeforeTest
	@Parameters({"browser", "nodeUrl"})
	public void beforeTest(String browser, String nodeUrl) {
		try {
			bf = new BrowserFactory();
			DriverFactory.getInstance().setDriver(bf.setDriver(browser, nodeUrl));
			driver = DriverFactory.getInstance().getDriver();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		bf.removeDriver();
	}

}
