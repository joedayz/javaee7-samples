package pe.joedayz.javaee7.bv.ejemplo3;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Libro03 {

	// ======================================
	// = Attributes =
	// ======================================

	private String titulo;
	private Float precio;
	private String descripcion;
	private String isbn;
	private Integer numberDePaginas;
	private Boolean ilustraciones;

	// ======================================
	// = Constructors =
	// ======================================

	public Libro03() {
	}

	public Libro03(@NotNull String titulo, 
			@NotNull @Min(2) Float precio, 
			@Size(max = 2000) String descripcion,
			String isbn, Integer numberDePaginas, Boolean ilustraciones) {
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.isbn = isbn;
		this.numberDePaginas = numberDePaginas;
		this.ilustraciones = ilustraciones;
	}

	// ======================================
	// = Getters & Setters =
	// ======================================

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumberDePaginas() {
		return numberDePaginas;
	}

	public void setNumberDePaginas(Integer numberDePaginas) {
		this.numberDePaginas = numberDePaginas;
	}

	public Boolean getIlustraciones() {
		return ilustraciones;
	}

	public void setIlustraciones(Boolean ilustraciones) {
		this.ilustraciones = ilustraciones;
	}

	@Override
	public String toString() {
		return "Libro03 [titulo=" + titulo + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", isbn=" + isbn
				+ ", numberDePaginas=" + numberDePaginas + ", ilustraciones="
				+ ilustraciones + "]";
	}
}
