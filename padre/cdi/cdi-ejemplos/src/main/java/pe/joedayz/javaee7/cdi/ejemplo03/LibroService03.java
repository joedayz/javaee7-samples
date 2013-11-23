package pe.joedayz.javaee7.cdi.ejemplo03;


public class LibroService03 {

	// ======================================
	// = Attributes =
	// ======================================

	private GeneradorNumero03 generadorNumero;

	// ======================================
	// = Constructors =
	// ======================================

	public LibroService03(GeneradorNumero03 generadorNumero) {
		this.generadorNumero = generadorNumero;
	}

	// ======================================
	// = Business methods =
	// ======================================

	public Libro03 crearLibro(String titulo, Float precio, String descripcion) {
		Libro03 book = new Libro03(titulo, precio, descripcion);
		book.setIsbn(generadorNumero.generarNumero());
		return book;
	}
}
