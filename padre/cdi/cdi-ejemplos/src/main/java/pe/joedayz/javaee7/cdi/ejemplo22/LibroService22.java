package pe.joedayz.javaee7.cdi.ejemplo22;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class LibroService22 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String title, description;
  private Float price;
  private Libro22 book;

  @Inject
  @TreceDigitos22
  private GeneradorNumero22 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String createBook() {
    book = new Libro22(title, price, description);
    book.setIsbn(numberGenerator.generarNumero());
    return "customer.xhtml";
  }
}
