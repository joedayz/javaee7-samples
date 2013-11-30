package pe.joedayz.javaee7.cdi.ejemplo34;

import javax.inject.Inject;

public class LibroService34 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private GeneradorNumero34 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro34 createBook(String title, Float price, String description) {
    Libro34 book = new Libro34(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
