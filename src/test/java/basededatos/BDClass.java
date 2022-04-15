package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;



public class BDClass {
	
    private static final String URL = "jdbc:mysql://localhost:3306/UsuariosR";
    private static final String USUARIO = "elzevir";//"root"//3608726_sqlelzevir
    private static final String CLAVE = "password";

    
    public static void main(String[] args) {
        
        
    }
    
    
    public static String[][] datos() throws ClassNotFoundException, SQLException{
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    	
    	ResultSet rs = stmt.executeQuery ("SELECT rg.ID, Nombre, Apellido, se.Descripcion, Email, Direccion, Telefono, Edad, Pin, Compania FROM rGente rg, Sexo se WHERE rg.Descripcion = se.ID AND rg.ID BETWEEN 11 and 16 ORDER BY ID ");
    		rs.last();
    		
    	int rows = rs.getRow();
    	System.out.println("rows: " +rows);
    	ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
    	int cols = rsmd.getColumnCount();
    	System.out.println("cols: " +cols);
    	String datos[][]= new String[rows][cols];
    	
    	
    	
    	int i=0;
    	rs.beforeFirst();
    	
    	while(rs.next()){
    		for(int j=0;j<cols;j++) {
    			datos[i][j]=(String)rs.getString(j+1);
    		}
    			i++;
    			}
    		//conexion.close();
    		//rs.close();
    		//con.close();
    	return datos;
    }
}
    
    
		
	
	    
		
	
	
	

