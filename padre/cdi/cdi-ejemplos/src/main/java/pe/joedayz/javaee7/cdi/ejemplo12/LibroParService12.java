package pe.joedayz.javaee7.cdi.ejemplo12;

import javax.inject.Inject;


public class LibroParService12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @TreceDigitos12
  @Par12
  private GeneradorNumero12 generadorNumero;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro12 crearLibro(String titulo, Float precio, String descripcion) {
    Libro12 libro = new Libro12(titulo, precio, descripcion);
    libro.setIsbn(generadorNumero.generarNumero());
    return libro;
  }
}
