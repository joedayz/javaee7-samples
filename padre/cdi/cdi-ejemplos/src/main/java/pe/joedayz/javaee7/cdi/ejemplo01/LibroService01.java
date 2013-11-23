package pe.joedayz.javaee7.cdi.ejemplo01;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Vetoed
public class LibroService01 {

	@Inject
	private GeneradorNumero01 generadorNumero;

	@Inject
	private EntityManager em;

	Date fechaCreacion;

	@PostConstruct
	private void iniciarFecha() {
		fechaCreacion = new Date();
	}

	@Transactional
	public Libro01 crearLibro(String titulo, Float precio, String descripcion) {
		Libro01 libro = new Libro01(titulo, precio, descripcion);
		libro.setIsbn(generadorNumero.generarNumero());
		libro.setFechaCreacion(fechaCreacion);
		em.persist(libro);
		return libro;
	}
}
