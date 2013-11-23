package pe.joedayz.javaee7.cdi.ejemplo04;

import javax.inject.Inject;


public class LibroService04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject 
  private GeneradorNumero04 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro04 crearLibro(String title, Float price, String description) {
    Libro04 book = new Libro04(title, price, description);
    book.setIsbn(numberGenerator.generadorNumero());
    return book;
  }
}
