package pe.joedayz.javaee7.cdi.ejemplo36;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class InventarioService36 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;
  List<Libro36> inventory = new ArrayList<>();

  // ======================================
  // =          Business methods          =
  // ======================================

  public void addBook(@Observes @Added Libro36 book) {
    logger.warning("#### Adding book " + book.getTitle() + " to inventory");
    inventory.add(book);
  }

  public void removeBook(@Observes @Removed Libro36 book) {
    logger.warning("#### Removing book " + book.getTitle() + " to inventory");
    inventory.remove(book);
  }
}
