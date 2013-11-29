package pe.joedayz.javaee7.cdi.ejemplo04;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class Generadornumero04Test {

	protected static Weld weld;
	protected static WeldContainer container;

	@BeforeClass
	public static void init() {
		weld = new Weld();
		container = weld.initialize();
	}

	@Test
	public void deberiaChequearQueNumeroEsDeTreceDigitos() {
		LibroService04 libroService = container.instance()
				.select(LibroService04.class).get();
		Libro04 libro = libroService.crearLibro("H2G2", 12.5f,
				"Geeky scifi Book");
		assertTrue(libro.getIsbn().startsWith("13"));
	}
	
	
	@AfterClass
	public static void close() {
		weld.shutdown();
	}



}
