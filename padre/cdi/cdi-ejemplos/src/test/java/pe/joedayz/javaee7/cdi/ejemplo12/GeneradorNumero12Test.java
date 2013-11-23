package pe.joedayz.javaee7.cdi.ejemplo12;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneradorNumero12Test {

	// ======================================
	// = Attributes =
	// ======================================

	protected static Weld weld;
	protected static WeldContainer container;

	// ======================================
	// = Lifecycle Methods =
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
	// = Methods =
	// ======================================

	@Test
	public void deberiaChequearSiNumeroEsDeTreceDigitosYPar() {
		LibroParService12 libroService = container.instance()
				.select(LibroParService12.class).get();
		Libro12 libro = libroService.crearLibro("H2G2", 12.5f,
				"Geeky scifi Book");
		assertTrue(libro.getIsbn().startsWith("131"));
	}

	@Test
	public void deberiaChequearSiNumeroEsDeTreceDigitosEImpar() {
		LibroImparService12 libroService = container.instance()
				.select(LibroImparService12.class).get();
		Libro12 libro = libroService.crearLibro("H2G2", 12.5f,
				"Geeky scifi Book");
		assertTrue(libro.getIsbn().startsWith("132"));
	}

	@Test
	public void deberiaChequearSiNumeroEsDeOchoDigitos() {
		LegacyLibroService12 libroService = container.instance()
				.select(LegacyLibroService12.class).get();
		Libro12 libro = libroService.crearLibro("H2G2", 12.5f, "Geeky scifi Book");
		assertTrue(libro.getIsbn().startsWith("8"));
	}

}
