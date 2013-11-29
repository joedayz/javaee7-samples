package pe.joedayz.javaee7.cdi.ejemplo16;

import javax.inject.Inject;
import java.util.logging.Logger;


public class LibroService16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  Logger log = Logger.getLogger(LibroService16.class.getName());

  @Inject
  @TreceDigitos16

  private GeneradorNumero16 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro16 createBook(String title, Float price, String description) {
    log.warning("Debug message without injection");
    Libro16 book = new Libro16(title, price, description);
    book.setIsbn(numberGenerator.generarNumero());
    return book;
  }
}
