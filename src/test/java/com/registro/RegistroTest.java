package com.registro;

import org.testng.annotations.Test;
import basededatos.BDClass;
import driver.BrowserFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class RegistroTest {
	
	BDClass DB ;
	WebDriver driver;
	BrowserFactory df = null;
	
  @Test(dataProvider = "dp")
  public void f(String ID, String Nombre, String Apellido, String Descripcion, String Email, 
		  String Direccion, String Telefono, String Edad, String Pin, String Compania) {
	  
  }

  @DataProvider
  public Object[][] DP() throws ClassNotFoundException, SQLException{
	  String data[][] = BDClass.datos();
		return data;
  }
  @BeforeTest
  public void beforeTest(String browser, String nodeUrl) {
  }

  @AfterTest
  public void afterTest() {
  }

}
