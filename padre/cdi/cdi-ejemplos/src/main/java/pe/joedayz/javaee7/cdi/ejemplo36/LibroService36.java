package pe.joedayz.javaee7.cdi.ejemplo36;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class LibroService36 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private GeneradorNumero36 numberGenerator;

  @Inject @Added
  private Event<Libro36> bookAddedEvent;

  @Inject @Removed
  private Event<Libro36> bookRemovedEvent;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Libro36 createBook(String title, Float price, String description) {
    Libro36 book = new Libro36(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    bookAddedEvent.fire(book);
    return book;
  }

  public void deleteBook(Libro36 book) {
    bookRemovedEvent.fire(book);
  }
}
