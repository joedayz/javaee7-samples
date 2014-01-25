package pe.joedayz.libros.modelos;

import java.util.List;

public class Libro {

	private Integer anoDePublicacion;
	private List<String> autores;
	private String editora;
	private String nombre;
	private String resumen;
	
	public Libro() {}

	public Libro(Integer anoDePublicacion, List<String> autores,
			String editora, String nombre, String resumen) {
		super();
		this.anoDePublicacion = anoDePublicacion;
		this.autores = autores;
		this.editora = editora;
		this.nombre = nombre;
		this.resumen = resumen;
	}

	public Integer getAnoDePublicacion() {
		return anoDePublicacion;
	}

	public void setAnoDePublicacion(Integer anoDePublicacion) {
		this.anoDePublicacion = anoDePublicacion;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	
	
}
