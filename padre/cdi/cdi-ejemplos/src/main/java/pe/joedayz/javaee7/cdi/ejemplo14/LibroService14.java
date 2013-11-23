package pe.joedayz.javaee7.cdi.ejemplo14;

import javax.inject.Inject;

public class LibroService14 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private GeneradorNumero14 generadorNumero;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro14 crearLibro(String titulo, Float precio, String descripcion) {
    Libro14 libro = new Libro14(titulo, precio, descripcion);
    libro.setIsbn(generadorNumero.generarNumero());
    return libro;
  }
}
