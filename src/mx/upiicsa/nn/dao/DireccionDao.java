
package mx.upiicsa.nn.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.upiicsa.nn.bean.*;

import mx.upiicsa.nn.bean.Direccion;

public class DireccionDao extends BDConnection {

	public int registrarDireccion(Direccion direccion) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "insert into Persona(nombre) values(?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, direccion.getCalle());
				 resultado = preparedStatement.executeUpdate();
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
				} else {
					System.err.println("No se logro insertr ningun registro");
					resultado=-1;
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public Direccion findById(int id) {
		Direccion dir = new Direccion();
		try {
			Connection connection = getConnection();

			if (connection != null) {

				String query = "select * from Direccion where idDireccion=? and calle=?";
				PreparedStatement preparestatement = connection.prepareStatement(query);
				preparestatement.setString(1, Integer.toString(id));
				ResultSet rs = preparestatement.executeQuery();
				System.out.println("Número de coincidencias: " + rs.getRow());
				if (rs.getRow() > 0) {
					if (rs.next()) {
						dir.setCalle(rs.getString(1));
						dir.setCodigo(1);
						
					}
				} else {
					dir.setCodigo(-1);// Error
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		return dir;
	}

	public Integer actualizaPersona(Direccion direccion) {
		try {
			String query = "insert into Direccion(calle) values (?)";
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, direccion.getCalle());
			Integer row = preparedStatement.executeUpdate();
			if (row > 0) {
				direccion.setCodigo(1);
				System.err.println("Se actualizo la información correctamente");
			} else {
				direccion.setCodigo(-1);
				System.err.println("No se puedo realizar la actualización");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return direccion.getCodigo();
	}
}
