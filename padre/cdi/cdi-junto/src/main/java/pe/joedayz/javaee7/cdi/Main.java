package pe.joedayz.javaee7.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class Main {

  public static void main(String[] args) {

    Weld weld = new Weld();
    WeldContainer container = weld.initialize();

    LibroService bookService = container.instance().select(LibroService.class).get();

    Libro book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");

    System.out.println(book);

    weld.shutdown();
  }
}