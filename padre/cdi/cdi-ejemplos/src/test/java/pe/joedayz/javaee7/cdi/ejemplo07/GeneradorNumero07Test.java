package pe.joedayz.javaee7.cdi.ejemplo07;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneradorNumero07Test {

	// ======================================
	  // =             Attributes             =
	  // ======================================

	  protected static Weld weld;
	  protected static WeldContainer container;

	  // ======================================
	  // =          Lifecycle Methods         =
	  // ======================================

	  @BeforeClass
	  public static void init() {
	    weld = new Weld();
	    container = weld.initialize();
	  }

	  @AfterClass
	  public static void close() {
	    weld.shutdown();
	  }

	  // ======================================
	  // =              Methods               =
	  // ======================================

	  @Test
	  public void deberiaChequearQueNumeroEsDeTreceDigitos() {
		  LibroService07 libroService = container.instance().select(LibroService07.class).get();
	    Libro07 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
	    assertTrue(libro.getIsbn().startsWith("13"));
	  }

	  @Test
	  public void deberiaChequearQueNumeroEsDeOchoDigitos() {
	    LegacyLibroService07 bookService = container.instance().select(LegacyLibroService07.class).get();
	    Libro07 libro = bookService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
	    assertTrue(libro.getIsbn().startsWith("8"));
	  }
}
