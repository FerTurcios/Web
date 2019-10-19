package mx.upiicsa.nn.bs;
import mx.upiicsa.nn.bean.*;
import mx.upiicsa.nn.dao.*;

public class DireccionBS {
public int registrarDireccion (Direccion direccion) {
	    DireccionDao dirDao = new DireccionDao();
	    int codigo=(Integer)dirDao.registrarDireccion(direccion);
	    return codigo;
	    
}
public Direccion findById (Integer id) {
	DireccionDao dirDao = new DireccionDao();
	Direccion direccion;
	direccion = dirDao.findById(id);
	System.out.println("--->BS.direccion" + direccion);
	return direccion;
}
public static void main(String [] args) {
	DireccionDao dirDao = new DireccionDao();
	Direccion direccion;
	direccion = dirDao.findById(1);
	if(direccion != null) {
		System.out.println("Calle: " +direccion.getCalle());
		System.out.println("Colonia: "+direccion.getColonia());
		System.out.println("Municipio: "+direccion.getMunicipio());
		System.out.println("Codigo Postal: "+direccion.getCodigoPostal());
		System.out.println("Numero Exterior: "+direccion.getNumeroExterior());
		System.out.println("Numero Interior: "+direccion.getNumeroInterior());
		System.out.println("Estado: "+direccion.getEstado());
	}else {
		System.out.println("Se genero un error");
	}
}
		
}
