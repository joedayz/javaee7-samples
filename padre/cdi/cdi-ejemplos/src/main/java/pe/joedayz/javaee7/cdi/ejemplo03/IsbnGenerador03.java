package pe.joedayz.javaee7.cdi.ejemplo03;

import java.util.Random;

public class IsbnGenerador03 implements GeneradorNumero03 {

	@Override
	public String generarNumero() {
		return "13-84356-" + Math.abs(new Random().nextInt());
	}

}
