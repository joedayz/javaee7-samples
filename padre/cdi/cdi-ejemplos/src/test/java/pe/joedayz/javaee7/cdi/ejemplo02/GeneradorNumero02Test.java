package pe.joedayz.javaee7.cdi.ejemplo02;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeneradorNumero02Test {

	@Test
	  public void deberiaVerificarQueNumeroEsDeTreceDigitos() {

	    LibroService02 libroService = new LibroService02();

	    Libro02 libro = libroService.
	    			crearLibro("H2G2",
	    					12.5f, "Geeky scifi Book");

	    assertTrue(libro.getIsbn().startsWith("13"));
	  }
}
