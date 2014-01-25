package pe.joedayz.libros.servicios;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import pe.joedayz.libros.daos.LibroDAO;
import pe.joedayz.libros.modelos.Libro;


@WebService
public class ListaDeLibros {

	public List<Libro> listarLibros(){
		LibroDAO libroDAO = obtenerDAO();
		return libroDAO.listarLibros();
	}
	
	private LibroDAO obtenerDAO(){
		return new LibroDAO();
	}
	
	public static void main(String[] args){
		Endpoint.publish("http://localhost:8080/libros",
				new ListaDeLibros());
		System.out.println("Servicio inicializado");
	}
}
