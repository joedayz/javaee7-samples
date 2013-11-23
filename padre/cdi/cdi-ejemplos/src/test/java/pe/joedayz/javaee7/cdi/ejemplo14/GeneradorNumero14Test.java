package pe.joedayz.javaee7.cdi.ejemplo14;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class GeneradorNumero14Test {

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
  public void deberiaChequearQuenumeroEsDeTreceDigitos() {
    LibroService14 libroService = 
    		container.instance().select(LibroService14.class).get();
    Libro14 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(libro.getIsbn().startsWith("MOCK"));
  }
}