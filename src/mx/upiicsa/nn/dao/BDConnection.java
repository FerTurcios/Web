package mx.upiicsa.nn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
	protected  Connection connection = null;
	
	public Connection getConnection() {
	try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/PRUEBA", "root", "password");
        System.err.println("-->Conexionexitosa");
     } catch (SQLException ex) {
    	 System.err.println("-->SQL errorConexionexitosa");
    	 ex.printStackTrace();
     } catch (ClassNotFoundException e) {
    	 System.err.println("-->E errorConexionexitosa");
		e.printStackTrace();
	}
	return connection;
	}
	
	public  void cerrrarConexion() {
		try {
		if(connection!=null) {
			connection.close();
		}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}