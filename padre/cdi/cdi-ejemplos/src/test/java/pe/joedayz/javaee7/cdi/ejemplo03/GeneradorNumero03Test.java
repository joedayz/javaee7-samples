package pe.joedayz.javaee7.cdi.ejemplo03;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeneradorNumero03Test {

	@Test
	public void deberiaChequearQueNumeroEsDeTreceDigitos() {
		LibroService03 libroService = new LibroService03(new IsbnGenerador03());
		Libro03 book = libroService.crearLibro("H2G2", 12.5f,
				"Geeky scifi Book");
		assertTrue(book.getIsbn().startsWith("13"));
	}

	@Test
	public void deberiaChequearQueNumeroEsDeOchoDigitos() {
		LibroService03 libroService = new LibroService03(new IssnGenerador03());
		Libro03 book = libroService.crearLibro("H2G2", 12.5f,
				"Geeky scifi Book");
		assertTrue(book.getIsbn().startsWith("8"));
	}
}
