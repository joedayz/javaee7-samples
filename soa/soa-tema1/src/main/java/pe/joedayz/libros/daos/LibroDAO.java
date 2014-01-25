package pe.joedayz.libros.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.joedayz.libros.modelos.Libro;

public class LibroDAO {

	
	public List<Libro> listarLibros() {
		List<Libro> livros = new ArrayList<Libro>();
		livros.add(new Libro(2012, new ArrayList<String>(Arrays.asList("Paulo Silveira", "Adriano Almeida")), "Oreilly", "Guia do Programador", "Ud \"nunca a programado\" ..."));
		livros.add(new Libro(2012, new ArrayList<String>(Arrays.asList("Roberto Baggio Fuentes")), "Apress", "Ruby on Rails", "Cree rapidamente aplicaciones web"));
		return livros;
	}
}
