package pe.joedayz.javaee7.cdi.ejemplo07;

import javax.inject.Inject;


public class LegacyLibroService07 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @OchoDigitos07
  private GeneradorNumero07 generadorNumero;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro07 crearLibro(String titulo,
		  Float precio, String descripcion) {
    Libro07 libro = new Libro07(titulo, precio, descripcion);
    libro.setIsbn(generadorNumero.generarNumero());
    return libro;
  }
}
