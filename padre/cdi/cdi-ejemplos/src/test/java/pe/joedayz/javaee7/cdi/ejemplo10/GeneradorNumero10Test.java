package pe.joedayz.javaee7.cdi.ejemplo10;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneradorNumero10Test {

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
	  public void deberiaChequearQueEsDeTreceDigitosPar() {
	    LibroParService10 libroService = container.instance().select(LibroParService10.class).get();
	    Libro10 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
	    assertTrue(libro.getIsbn().startsWith("131"));
	  }

	  @Test
	  public void deberiaChequearQueEsDeTreceDigitosImpar() {
	    LibroImparService10 libroService = container.instance().select(LibroImparService10.class).get();
	    Libro10 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
	    assertTrue(libro.getIsbn().startsWith("132"));
	  }

	  @Test
	  public void deberiaChequearQueEsDeOchoDigitos() {
	    LegacyLibroService10 libroService = container.instance().select(LegacyLibroService10.class).get();
	    Libro10 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
	    assertTrue(libro.getIsbn().startsWith("8"));
	  }
}
