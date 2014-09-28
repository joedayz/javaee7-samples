package pe.joedayz.ventas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pe.joedayz.ventas.model.Libro;


@ManagedBean
@ViewScoped
public class LibrosBean {

	private List<Libro> libros;
	private Libro nuevoLibro;
	

	
	public LibrosBean(){
		this.libros = new ArrayList<>();
		this.nuevoLibro = new Libro();
		this.libros.add(new Libro("Java SE 7", "Marlon Fuentes"));
		this.libros.add(new Libro("Ruby and Rails", "Dionisio Paredes"));
		this.libros.add(new Libro("Test Driven Development", "Angel Nuñez"));
		this.libros.add(new Libro("Django for dummies", "Joe Perez"));
		this.libros.add(new Libro("El alquista", "Cohelo"));
	}

	
	public void agregar(){
		this.libros.add(this.nuevoLibro);
		this.nuevoLibro = new Libro();
	}
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro getNuevoLibro() {
		return nuevoLibro;
	}

	public void setNuevoLibro(Libro nuevoLibro) {
		this.nuevoLibro = nuevoLibro;
	}
	
	
	
	
}
