package pe.joedayz.ventas.model;

public enum TipoMovimiento {

	VENTAS("Ventas"),
	COMPRAS("Compras");
	
	private String descripcion;
	
	TipoMovimiento(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
}
