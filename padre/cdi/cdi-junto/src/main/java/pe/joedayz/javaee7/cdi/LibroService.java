package pe.joedayz.javaee7.cdi;

import javax.inject.Inject;


@Loggable
public class LibroService {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @TreceDigitos
  private GeneradorNumero numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro createBook(String title, Float price, String description) {
    Libro book = new Libro(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }
}
