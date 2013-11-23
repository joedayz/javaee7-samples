package pe.joedayz.javaee7.cdi.ejemplo03;

import java.util.Random;

public class IssnGenerador03 implements GeneradorNumero03 {

	@Override
	public String generarNumero() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
