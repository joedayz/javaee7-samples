package pe.joedayz.javaee7.cdi.ejemplo06;

import javax.enterprise.inject.Default;
import javax.inject.Inject;


public class LibroService06 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @Default
  private GeneradorNumero06 generadorNumero;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro06 crearLibro(String titulo,
		  Float precio, String descripcion) {
    Libro06 book = new Libro06(titulo, precio, descripcion);
    book.setIsbn(generadorNumero.generarNumero());
    return book;
  }
}
