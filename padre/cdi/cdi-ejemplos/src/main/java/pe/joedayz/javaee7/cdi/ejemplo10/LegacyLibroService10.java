package pe.joedayz.javaee7.cdi.ejemplo10;

import javax.inject.Inject;

public class LegacyLibroService10 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @NumeroDeDigitos10(value = Digitos.EIGHT, odd = true)
  private GeneradorNumero10 generadorNumero;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro10 crearLibro(String titulo,
		  Float precio, String descripcion) {
    Libro10 libro = new Libro10(titulo, precio, descripcion);
    libro.setIsbn(generadorNumero.generarNumero());
    return libro;
  }
}
