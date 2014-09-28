package pe.joedayz.ventas.persistence;

import javax.persistence.Persistence;

public class CrearTablas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("VentasPU");

	}

}
