package pe.joedayz.javaee7.cdi.ejemplo12;

import javax.inject.Inject;


public class LegacyLibroService12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @OchoDigitos12
  @Par12
  private GeneradorNumero12 numeroGenerador;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro12 crearLibro(String titulo, Float precio, String descripcion) {
    Libro12 libro = new Libro12(titulo, precio, descripcion);
    libro.setIsbn(numeroGenerador.generarNumero());
    return libro;
  }
}
