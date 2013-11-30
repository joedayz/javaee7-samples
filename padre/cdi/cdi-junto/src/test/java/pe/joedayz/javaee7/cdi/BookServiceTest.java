package pe.joedayz.javaee7.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BookServiceTest {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsMock() {

    Weld weld = new Weld();
    WeldContainer container = weld.initialize();

    LibroService bookService = container.instance().select(LibroService.class).get();

    Libro book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");

    assertTrue(book.getNumber().startsWith("MOCK"));

    weld.shutdown();
  }
}