package pe.joedayz.javaee7.cdi.ejemplo02;



public class LibroService02 {


	private GeneradorNumero02 generadorNumero;

	public LibroService02(){
		generadorNumero = new IsbnGenerador02();
	}

	public Libro02 crearLibro(String titulo, Float precio, String descripcion) {
		Libro02 libro = new Libro02(titulo, precio, descripcion);
		libro.setIsbn(generadorNumero.generarNumero());
		return libro;
	}
}
